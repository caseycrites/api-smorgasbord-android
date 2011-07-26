package com.simplegeo.android.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.os.Bundle;
import android.util.Log;

import com.simplegeo.android.type.OAuthConfig;

public class SGHttpRequest {
	public static final String TAG = "SGHttpRequest";
	
	private String url;
	private SGHttpMethod method;
	private Map<String, String> headers;
	private OAuthConfig oAuthConfig;
	private HttpURLConnection request;
	private String queryParams;
	private String bodyParams;
	
	public SGHttpRequest(SGHttpMethod method, String url, OAuthConfig oAuthConfig) {
		Log.d(TAG, "method: " + method.toString());
		Log.d(TAG, "url: " + url);
		this.method = method;
		this.url = url;
		this.oAuthConfig = oAuthConfig;
	}

	public SGHttpResponse start(Bundle params) throws IOException {
		createRequest(params);
		oAuthConfig.signRequest(this, params);
		addHeaders();
		setBody();
		return new SGHttpResponse(request);
	}
	
	public void addHeaders() {
		Set<Entry<String, String>> entries = getHeaders().entrySet();
		for (Entry<String, String> entry : entries) {
			Log.d(TAG, entry.getKey() + " - " + entry.getValue());
			getRequest().setRequestProperty(entry.getKey(), entry.getValue());
		}
	}

	public void setBody() throws IOException {
		if (bodyParams != null) {
			getRequest().setDoOutput(true);
			getRequest().getOutputStream().write(bodyParams.getBytes());
		}
	}

	private void createRequest(Bundle params) throws IOException {
		String encodedString = createEncodedString(params);
		String httpMethod = "";
		Log.d(TAG, "payload: " + encodedString);
		switch (method) {
			case GET:
				httpMethod = "GET";
				setQueryParams(encodedString);
				break;
			case DELETE:
				httpMethod = "DELETE";
				break;
			case PUT:
				httpMethod = "PUT";
				setBodyParams(encodedString);
				setHeader("Content-Length", String.valueOf(encodedString.length()));
				setHeader("Content-Type", "application/x-www-form-urlencoded");
				break;
			case POST:
				httpMethod = "POST";
				setBodyParams(encodedString);
				setHeader("Content-Length", String.valueOf(encodedString.length()));
				setHeader("Content-Type", "application/x-www-form-urlencoded");
				break;
			default:
				break;
		}
		setQueryParams(queryParams == null ? url : url+"?"+queryParams);
		setRequest((HttpURLConnection) new URL(url).openConnection());
		getRequest().setRequestMethod(httpMethod);
	}
	
	public static String createEncodedString(Bundle params) {
		if (params == null) { return ""; }
		StringBuffer query = new StringBuffer();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			Object value = params.get(key);
			if (value != null) {
				if (query.length() > 0) { query.append("&"); }
				query.append(URLEncoder.encode(key) + "=" + URLEncoder.encode(value.toString()));
			}
		}
		return query.toString();
	}

	// Getters/Setters

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SGHttpMethod getMethod() {
		return method;
	}
	
	public Map<String, String> getHeaders() {
		if (headers == null) { headers = new HashMap<String, String>(); }
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public void setHeader(String name, String value) {
		getHeaders().put(name, value);
	}

	public void setMethod(SGHttpMethod method) {
		this.method = method;
	}

	public OAuthConfig getoAuthConfig() {
		return oAuthConfig;
	}

	public void setoAuthConfig(OAuthConfig oAuthConfig) {
		this.oAuthConfig = oAuthConfig;
	}

	public HttpURLConnection getRequest() {
		return request;
	}

	public void setRequest(HttpURLConnection request) {
		this.request = request;
	}
	
	public String getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}

	public String getBodyParams() {
		return bodyParams;
	}

	public void setBodyParams(String bodyParams) {
		this.bodyParams = bodyParams;
	}
	
}
