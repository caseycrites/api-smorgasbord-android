package com.simplegeo.android.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Set;

import android.os.AsyncTask;
import android.os.Bundle;

import com.simplegeo.android.callback.SGCallback;
import com.simplegeo.android.type.OAuthConfig;

public class SGHttpRequest {
	public static final String TAG = "SGHttpRequest";
	
	private String url;
	private SGHttpMethod method;
	private OAuthConfig oAuthConfig;
	
	public SGHttpRequest(SGHttpMethod method, String url, OAuthConfig oAuthConfig) {
		this.method = method;
		this.url = url;
		this.oAuthConfig = oAuthConfig;
	}

	public void startAsynchronous(Bundle params, SGCallback callback) {
		// TODO This try/catch feels wrong.  In ways other than the obvious.
		try {
			HttpURLConnection request = this.buildRequest(params);
			SGHttpRequestTask requestTask = new SGHttpRequestTask(request, callback);
			requestTask.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private HttpURLConnection buildRequest(Bundle params) throws IOException {
		// TODO Need to build and add headers.
		String encodedString = createEncodedString(params);
		HttpURLConnection request = null;
		String httpMethodStr = "";
		switch (method) {
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
		return oAuthConfig.signRequest(request, params);
	}
	
	public static String createEncodedString(Bundle params) {
		if (params == null) { return ""; }
		StringBuffer query = new StringBuffer();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			Object value = params.get(key);
			if (value != null) {
				if (query.length() > 0) { query.append("&"); }
				query.append(URLEncoder.encode(key) + "+" + URLEncoder.encode(value.toString()));
			}
		}
		return query.toString();
	}
	
	// Inner classes
	
	private class SGHttpRequestTask extends AsyncTask<Void, Void, SGHttpResponse> {

		private HttpURLConnection request;
		private SGCallback callback;
		
		public SGHttpRequestTask(HttpURLConnection request, SGCallback callback) {
			this.request = request;
			this.callback = callback;
		}
		
		@Override
		protected SGHttpResponse doInBackground(Void... params) {
			SGHttpResponse response = null;
			try {
				response = new SGHttpResponse(request);
			} catch (IOException e) {
				// TODO Not sure what to do here.
			}
			return response;
		}
		
		@Override
		protected void onPostExecute(SGHttpResponse response) {
			if (response.wasSuccessful()) {
				callback.onSuccess(response);
			} else {
				callback.onError(response);
			}
		}
	}

}
