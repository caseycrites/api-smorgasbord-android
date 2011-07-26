package com.simplegeo.android.client;

import java.io.IOException;

import android.os.Bundle;

import com.simplegeo.android.http.SGHttpMethod;
import com.simplegeo.android.http.SGHttpRequest;
import com.simplegeo.android.http.SGHttpResponse;
import com.simplegeo.android.type.OAuthConfig;

public abstract class AbstractClient implements Client {
	
	public OAuthConfig config;
	
	public AbstractClient(OAuthConfig config) {
		this.config = config;
	}
	
	/* (non-Javadoc)
	 * @see com.simplegeo.android.client.Client#executeRequest(com.simplegeo.android.client.AbstractClient.SGHttpMethod, java.lang.String, android.os.Bundle, com.simplegeo.android.callback.SmorgasbordCallback)
	 */
	@Override
	public SGHttpResponse executeRequest(SGHttpMethod httpMethod, String url, Bundle params) throws IOException {
		SGHttpRequest request = new SGHttpRequest(httpMethod, url, config);
		return request.start(params);
	}

}
