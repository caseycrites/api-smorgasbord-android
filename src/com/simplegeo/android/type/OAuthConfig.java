package com.simplegeo.android.type;

import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import android.os.Bundle;
import android.util.Base64;

import com.simplegeo.android.http.SGHttpRequest;

public class OAuthConfig {
	public static final String TAG = "OAuthConfig";

	private String accessToken;
	private String accessSecret;
	private String consumerKey;
	private String consumerSecret;
	
	public static final String ALGO = "HmacSHA1";
	public static final String EQUALS = "=";
	public static final String EQUALS_ENCODED = "%3D";
	public static final String AMPERSAND = "&";
	public static final String AMPERSAND_ENCODED = "%26";
	
	public OAuthConfig(String accessToken) {
		this(accessToken, null, null, null);
	}
	
	public OAuthConfig(String consumerKey, String consumerSecret) {
		this(null, null, consumerKey, consumerSecret);
	}
	
	public OAuthConfig(String accessToken, String accessSecret, String consumerKey, String consumerSecret) {
		this.accessToken = accessToken;
		this.accessSecret = accessSecret;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessSecret() {
		return accessSecret;
	}

	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}
	
	public SGHttpRequest signRequest(SGHttpRequest request, Bundle params) {
		Bundle oAuthParams = this.generateOAuthParams();
		params.putAll(oAuthParams);
		oAuthParams.putString("oauth_signature", this.generateOAuthSignature(request, params));
		this.addAuthHeader(request, oAuthParams);
		return request;
	}
	
	private String generateOAuthSignature(SGHttpRequest request, Bundle params) {
		StringBuffer baseBuf = new StringBuffer();
		List<String> sortedKeys = asSortedList(params.keySet());
		baseBuf.append(request.getRequest().getRequestMethod()+AMPERSAND+URLEncoder.encode(request.getRequest().getURL().toString())+AMPERSAND);
		for (String key : sortedKeys) {
			if (sortedKeys.indexOf(key) != 0) { baseBuf.append(AMPERSAND_ENCODED); }
			baseBuf.append(URLEncoder.encode(key)+EQUALS_ENCODED+URLEncoder.encode(params.getString(key)));
		}
		String base = baseBuf.toString();
		return this.sign(this.consumerSecret + AMPERSAND + this.accessSecret, base);
	}
	
	private String sign(String key, String baseString) {
		byte[] digest = null;
		try {
			Mac hmac = Mac.getInstance(ALGO);
			SecretKeySpec secret = new SecretKeySpec(key.getBytes(), hmac.getAlgorithm());
			hmac.init(secret);
			digest = hmac.doFinal(baseString.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return Base64.encodeToString(digest, Base64.DEFAULT);
	}
	
	private void addAuthHeader(SGHttpRequest request, Bundle params) {
		StringBuffer headerValueBuf = new StringBuffer();
		List<String> sortedKeys = asSortedList(params.keySet());
		headerValueBuf.append("OAuth ");
		for (String key : sortedKeys) {
			if (sortedKeys.indexOf(key) != 0) { headerValueBuf.append(", "); }
			headerValueBuf.append(URLEncoder.encode(key)+EQUALS+URLEncoder.encode(params.getString(key)));
		}
		String headerValue = headerValueBuf.toString();
		request.setHeader("Authorization", headerValue);
	}
	
	private static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
		List<T> list = new ArrayList<T>(c);
		java.util.Collections.sort(list);
		return list;
	}
	
	private Bundle generateOAuthParams() {
		Bundle oAuthParams = new Bundle();
		oAuthParams.putString("oauth_nonce", this.generateNonce());
		oAuthParams.putString("oauth_signature_method", "HMAC-SHA1");
		oAuthParams.putString("oauth_timestamp", String.valueOf(System.currentTimeMillis()));
		oAuthParams.putString("oauth_consumer_key", this.getConsumerKey());
		if (this.getAccessToken() != null) { oAuthParams.putString("oauth_token", this.getAccessToken()); }
		oAuthParams.putString("oauth_version", "1.0");
		return oAuthParams;
	}
	
	private String generateNonce() {
		Random generator = new Random(System.currentTimeMillis());
		return String.valueOf(generator.nextInt(50));
	}
}
