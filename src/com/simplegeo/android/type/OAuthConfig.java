package com.simplegeo.android.type;

import java.net.HttpURLConnection;

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
	
	public HttpURLConnection signRequest(HttpURLConnection connection) {
		return connection;
	}
}
