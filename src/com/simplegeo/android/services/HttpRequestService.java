package com.simplegeo.android.services;

import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.Api;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.simplegeo.android.clients.Client.RequestType;
import com.simplegeo.android.types.OAuthCredentials;

public class HttpRequestService extends IntentService {
	private final static String TAG = HttpRequestService.class.getSimpleName();
	
	private final static int maxAttempts = 3;
	
	public HttpRequestService() {
		super(TAG);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onHandleIntent(Intent intent) {
		Bundle extras = intent.getExtras();
		
		RequestType requestType = (RequestType) extras.getSerializable("requestType");
		Messenger messenger = (Messenger) extras.get("messenger");
		OAuthCredentials credentials = (OAuthCredentials) extras.get("credentials");
		String redirectUrl = extras.getString("redirectUrl");
		Class<? extends Api> clazz = (Class<? extends Api>) extras.getSerializable("clazz");
		
		OAuthService service = createOAuthService(clazz, credentials, redirectUrl);
		
		Message msg = null;
		switch(requestType) {
			case REQUEST_TOKEN:
				msg = getRequestToken(service, extras);
				break;
			case ACCESS_TOKEN:
				msg = getAccessToken(service, extras);
				break;
			case API_CALL:
				msg = doApiCall(service, credentials, extras, messenger);
				break;
			default:
				throw new IllegalArgumentException();
		}
		
		try {
			messenger.send(msg);
		} catch (RemoteException e) {
			Log.e(TAG, e.getMessage(), e);
		}
	}
	
	// Actual Http Requests
	
	private Message getAccessToken(OAuthService service, Bundle extras) {
		
		Token reqToken = (Token) extras.getSerializable("token");
		String verifierCode = extras.getString("verifierCode");
		
		Verifier verifier = new Verifier(verifierCode);
		
		Token token = service.getAccessToken(reqToken, verifier);
		
		Message msg = Message.obtain();
		Bundle msgData = new Bundle();
		msgData.putSerializable("token", token);
		msgData.putBoolean("success", true);
		msg.setData(msgData);
		
		return msg;
	}
	
	private Message getRequestToken(OAuthService service, Bundle extras) {
		Token token = service.getRequestToken();
		
		Message msg = Message.obtain();
		Bundle msgData = new Bundle();
		msgData.putSerializable("token", token);
		msgData.putBoolean("success", true);
		msg.setData(msgData);
		
		return msg;
	}
	
	private Message doApiCall(OAuthService service, OAuthCredentials credentials, Bundle extras, Messenger messenger) {
		Verb httpMethod = (Verb) extras.getSerializable("httpMethod");
		String url = extras.getString("url");
		Bundle params = extras.getBundle("params") != null ? extras.getBundle("params") : new Bundle();
		String payload = extras.getString("payload") != null ? extras.getString("payload") : "";
		
		OAuthRequest request = buildRequest(httpMethod, url, params, payload);
		request = signRequest(service, request, credentials);
		
		Message msg = Message.obtain();
		Bundle msgData = new Bundle();
		int responseCode = 0;
		String responseBody = "";
		int attempts = 1;
		while (shouldRetry(responseCode) && attempts <= maxAttempts) {
			try {
				Response response = request.send();
				responseCode = response.getCode();
				responseBody = response.getBody();
				if (responseCode >= 200 & responseCode < 400) {
					msgData.putBoolean("success", true);
				}
			} catch (RuntimeException e) {
				// The internal client is catching these messages, so whether we pass back the error message in the responseBody
				// is questionable.
				responseBody = e.getMessage();
			}
			++attempts;
		}
		
		msgData.putInt("responseCode", responseCode);
		msgData.putString("responseBody", responseBody);
		msg.setData(msgData);
		
		return msg;
	}
	
	// Util methods
	
	private OAuthService createOAuthService(Class<? extends Api> clazz, OAuthCredentials credentials, String redirectUrl) {
		ServiceBuilder builder = new ServiceBuilder()
							.provider(clazz)
							.apiKey(credentials.getConsumerKey())
							.apiSecret(credentials.getConsumerSecret());
		if (!"".equals(redirectUrl)) builder.callback(redirectUrl);
		return builder.build();
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
				try {
					new JSONObject(payload);
					request.addHeader("Content-type", "application/json");
				} catch (JSONException e) {
					request.addHeader("Content-type", "application/x-www-form-urlencoded");
				}
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
	
	private OAuthRequest signRequest(OAuthService service, OAuthRequest request, OAuthCredentials credentials) {
		Token token = new Token(credentials.getAccessToken() == null ? "" : credentials.getAccessToken(), 
				credentials.getAccessSecret() == null ? "" : credentials.getAccessSecret());
		service.signRequest(token, request);
		return request;
	}
	
	private boolean shouldRetry(int statusCode) {
		if (statusCode == 0 || statusCode == 408 || statusCode >= 500) return true;
		return false;
	}

}