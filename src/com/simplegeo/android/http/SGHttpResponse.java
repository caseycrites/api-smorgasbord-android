package com.simplegeo.android.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;

public class SGHttpResponse {

	private int code;
	private String body;
	private InputStream stream;
	private HashMap<String, String> headers;
	
	public SGHttpResponse(HttpURLConnection request) throws IOException {
	    try {
	      request.connect();
	      code = request.getResponseCode();
	      headers = parseHeaders(request);
	      stream = wasSuccessful() ? request.getInputStream() : request.getErrorStream();
	    } catch (UnknownHostException e) {
	      code = 404;
	      body = "";
	    }
	}
	
	public boolean wasSuccessful() {
		return getCode() >= 200 && getCode() < 300;
	}
	
	private HashMap<String, String> parseHeaders(HttpURLConnection conn) {
	    HashMap<String, String> headers = new HashMap<String, String>();
	    for (String key : conn.getHeaderFields().keySet()) {
	      headers.put(key, conn.getHeaderFields().get(key).get(0));
	    }
	    return headers;
	}

	public int getCode() {
		return code;
	}

	public String getBody() {
		return body;
	}

	public InputStream getStream() {
		return stream;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}
	
}
