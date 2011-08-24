package com.simplegeo.android.client;

import java.io.IOException;
import java.util.Set;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.Api;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import android.os.Bundle;

import com.simplegeo.android.type.OAuthCredentials;

public abstract class AbstractClient implements Client {
	
	private OAuthCredentials credentials;
	private OAuthService service;

	public AbstractClient(OAuthCredentials credentials, Class<? extends Api> clazz) {
		this(credentials, clazz, "");
	}
		
	public AbstractClient(OAuthCredentials credentials, Class<? extends Api> clazz, String redirectUrl) {
		this.credentials = credentials;
		createOAuthService(clazz, redirectUrl);
	}
	
	private void createOAuthService(Class<? extends Api> clazz, String redirectUrl) {
		ServiceBuilder builder = new ServiceBuilder()
							.provider(clazz)
							.apiKey(credentials.getConsumerKey())
							.apiSecret(credentials.getConsumerSecret());
		if (!"".equals(redirectUrl)) builder.callback(redirectUrl);
		this.service = builder.build();
	}
	
	/* (non-Javadoc)
	 * @see com.simplegeo.android.client.Client#executeRequest(com.simplegeo.android.client.AbstractClient.SGHttpMethod, java.lang.String, android.os.Bundle)
	 */
	public Response executeRequest(Verb httpMethod, String url, Bundle params, String payload) throws IOException {
		OAuthRequest request = buildRequest(httpMethod, url, params, payload);
		request = signRequest(request);
		return request.send();
	}

	private OAuthRequest buildRequest(Verb httpMethod, String url, Bundle params, String payload) {
		OAuthRequest request = new OAuthRequest(httpMethod, url);
		switch (httpMethod) {
			case GET:
				if (params != null) request = addQueryParams(request, params);
				break;
			case PUT:
			case POST:
				if (params != null) request = addBodyParams(request, params);
				if (!"".equals(payload) && payload != null) request.addPayload(payload);
				break;
			default:
				break;
		}
		return request;
	}
	
	private OAuthRequest addQueryParams(OAuthRequest request, Bundle params) {
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			request.addQuerystringParameter(key, params.getString(key));
		}
		return request;
	}
	
	private OAuthRequest addBodyParams(OAuthRequest request, Bundle params) {
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			request.addBodyParameter(key, params.getString(key));
		}
		return request;
	}
	
	private OAuthRequest signRequest(OAuthRequest request) {
		Token token = new Token(credentials.getAccessToken(), credentials.getAccessSecret());
		service.signRequest(token, request);
		return request;
	}

	public OAuthCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(OAuthCredentials credentials) {
		this.credentials = credentials;
	}

	public OAuthService getService() {
		return service;
	}

	public void setService(OAuthService service) {
		this.service = service;
	}
	
}
