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
		this.credentials = credentials;
		createOAuthService(clazz);
	}
	
	private void createOAuthService(Class<? extends Api> clazz) {
		this.service = new ServiceBuilder()
							.provider(clazz)
							.apiKey(credentials.getConsumerKey())
							.apiSecret(credentials.getConsumerSecret())
							.build();
	}
	
	/* (non-Javadoc)
	 * @see com.simplegeo.android.client.Client#executeRequest(com.simplegeo.android.client.AbstractClient.SGHttpMethod, java.lang.String, android.os.Bundle, com.simplegeo.android.callback.SmorgasbordCallback)
	 */
	@Override
	public Response executeRequest(Verb httpMethod, String url, Bundle params) throws IOException {
		OAuthRequest request = buildRequest(httpMethod, url, params);
		request = signRequest(request);
		return request.send();
	}
	
	private OAuthRequest buildRequest(Verb httpMethod, String url, Bundle params) {
		OAuthRequest request = new OAuthRequest(httpMethod, url);
		switch (httpMethod) {
			case GET:
				request = addQueryParams(request, params);
				break;
			case PUT:
			case POST:
				request = addBodyParams(request, params);
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

}
