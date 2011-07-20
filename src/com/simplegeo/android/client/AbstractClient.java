package com.simplegeo.android.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

import com.simplegeo.android.callback.SGCallback;
import com.simplegeo.android.http.SGHttpMethod;
import com.simplegeo.android.http.SGHttpRequest;
import com.simplegeo.android.type.OAuthConfig;
import com.simplegeo.android.util.Util;

public abstract class AbstractClient implements Client {
	
	public OAuthConfig config;
	
	public AbstractClient(OAuthConfig config) {
		this.config = config;
	}
	
	/* (non-Javadoc)
	 * @see com.simplegeo.android.client.Client#executeRequest(com.simplegeo.android.client.AbstractClient.SGHttpMethod, java.lang.String, android.os.Bundle, com.simplegeo.android.callback.SmorgasbordCallback)
	 */
	@Override
	public void executeRequest(SGHttpMethod httpMethod, String url, Bundle params, SGCallback callback) throws IOException {
		SGHttpRequest request = new SGHttpRequest(httpMethod, url, config);
		request.startAsynchronous(params, callback);
	}

}
