package com.simplegeo.android.type;

import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import android.os.Bundle;

public class OAuthConfig {

	private String accessToken;
	private String accessSecret;
	private String consumerKey;
	private String consumerSecret;
	
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
	
	public HttpURLConnection signRequest(HttpURLConnection request, Bundle params) {
		Bundle oAuthParams = this.generateOAuthParams();
		params.putAll(oAuthParams);
		oAuthParams.putString("oauth_signature", this.generateSignature(params));
		this.addAuthHeader(request, oAuthParams);
		return request;
	}
	
	private String generateSignature(Bundle params) {
		StringBuffer sig = new StringBuffer();
		List<String> sortedKeys = this.asSortedList(params.keySet());
		for (String key : sortedKeys) {
			sig.append(URLEncoder.encode(key)+"="+URLEncoder.encode(params.getString(key)));
		}
		return sig.toString();
	}
	
	private void addAuthHeader(HttpURLConnection request, Bundle params) {
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
		oAuthParams.putString("oauth_token", this.getAccessToken());
		oAuthParams.putString("oauth_version", "1.0");
		return oAuthParams;
	}
	
	private String generateNonce() {
		Random generator = new Random(System.currentTimeMillis());
		return String.valueOf(generator.nextInt(50));
	}
}
