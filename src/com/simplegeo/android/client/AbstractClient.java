package com.simplegeo.android.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;
import com.simplegeo.android.concurrent.NamedThreadFactory;
import com.simplegeo.android.type.OAuthConfig;
import com.simplegeo.android.util.Util;

public abstract class AbstractClient implements Client {
	
	public static OAuthConfig config;
	private static ThreadPoolExecutor threadExecutor;
	
	public static enum HttpMethod { GET, POST, PUT, DELETE }
	
	public AbstractClient(OAuthConfig config) {
		this.config = config;
		
		this.threadExecutor = new ThreadPoolExecutor(1, 8, Integer.MAX_VALUE, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new NamedThreadFactory(this.getClass().getName()));
	}
	
	/* (non-Javadoc)
	 * @see com.simplegeo.android.client.Client#executeRequest(com.simplegeo.android.client.AbstractClient.HttpMethod, java.lang.String, android.os.Bundle, com.simplegeo.android.callback.SmorgasbordCallback)
	 */
	@Override
	public void executeRequest(HttpMethod httpMethod, String url, Bundle params, SmorgasbordCallback callback) throws IOException {
		final HttpURLConnection request = buildRequest(httpMethod, url, params);
		final SmorgasbordCallback finalCallback = callback;
		threadExecutor.execute(new Thread() {
			public void run() {
				try {
					request.connect();
					handleResponse(request, finalCallback);
				} catch (IOException e) {
				}
			}
		});
	}
	
	private boolean successful(int code) {
		return code >= 200 && code < 300;
	}
	
	private HttpURLConnection buildRequest(HttpMethod httpMethod, String url, Bundle params) throws IOException {
		String encodedString = Util.createEncodedString(params);
		HttpURLConnection request = null;
		String httpMethodStr = "";
		switch (httpMethod) {
			case GET:
				if ("".equals(encodedString)) { url += "?" + encodedString; }
				request = (HttpURLConnection) new URL(url).openConnection();
				request.setRequestMethod("GET");
				break;
			case DELETE:
				request = (HttpURLConnection) new URL(url).openConnection();
				request.setRequestMethod("DELETE");
				break;
			case PUT:
				httpMethodStr = "PUT";
			case POST:
				if ("".equals(httpMethodStr)) { httpMethodStr = "POST"; }
				request = (HttpURLConnection) new URL(url).openConnection();
				request.setRequestMethod(httpMethodStr);
				request.setRequestProperty("Content-Length", String.valueOf(encodedString.length()));
				request.setDoOutput(true);
				request.getOutputStream().write(encodedString.getBytes());
			default:
				break;
		}
		return config.signRequest(request, params);
	}
	
	/* (non-Javadoc)
	 * @see com.simplegeo.android.client.Client#handleResponse(com.simplegeo.android.callback.SmorgasbordCallback)
	 */
	@Override
	public void handleResponse(HttpURLConnection connection, SmorgasbordCallback callback) throws IOException, JSONException {
		int code = connection.getResponseCode();
		if (successful(code)) {
			callback.onSuccess(new JSONObject(connection.getInputStream().toString()));
		} else {
			callback.onError(new JSONObject(connection.getErrorStream().toString()));
		}
	}
	
}
