package com.simplegeo.android.client;

import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;

public abstract class AbstractClient {
	
	public static enum HttpMethod { GET, POST, PUT, DELETE }
	
	// TODO Perhaps this should just be a Credentials object?
	public AbstractClient(String accessToken) {
		this(null, null, accessToken, null);
	}

	public AbstractClient(String consumerKey, String consumerSecret) {
		this(consumerKey, consumerSecret, null, null);
	}

	public AbstractClient(String consumerKey, String consumerSecret, String accessToken, String accessSecret) {
	}
	
	public void executeRequest(HttpMethod httpMethod, String url, Bundle params, SmorgasbordCallback callback) {
		
	}
	
	private void handleResponse(SmorgasbordCallback callback) {
		// This should handle the response from executeRequest and then send it to the appropriate method in the SmorgasbordCallback.
	}
	
}
