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

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.simplegeo.android.clients.Client.RequestType;
import com.simplegeo.android.types.OAuthCredentials;
import com.simplegeo.android.util.SGListener;

@SuppressWarnings({"unchecked", "unused"})
public class HttpRequestService extends Service {
	private final static String TAG = HttpRequestService.class.getSimpleName();
	
	private final static int maxAttempts = 3;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Bundle extras = intent.getExtras();
		RequestType requestType = (RequestType) extras.getSerializable("requestType");
		OAuthCredentials credentials = (OAuthCredentials) extras.getParcelable("credentials");
		Messenger messenger = (Messenger) extras.getParcelable("messenger");
		String redirectUrl = extras.getString("redirectUrl");
		Class<? extends Api> clazz = (Class<? extends Api>) extras.getSerializable("clazz");

		OAuthService service = createOAuthService(clazz, credentials, redirectUrl);

		switch(requestType) {
			case REQUEST_TOKEN:
				getRequestToken(service, messenger);
				break;
			case ACCESS_TOKEN:
				getAccessToken(service, extras, messenger);
				break;
			case API_CALL:
				doApiCall(service, credentials, extras, messenger);
				break;
			default:
				throw new IllegalArgumentException();
		}
		
		return Service.START_REDELIVER_INTENT;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	// Actual Http Requests
	
	public void getAccessToken(final OAuthService service, Bundle extras, final Messenger messenger) {
		final Token reqToken = (Token) extras.getSerializable("token");
		final Verifier verifier = new Verifier(extras.getString("verifierCode"));
		new Thread() {
			public void run() {
				Token token = null;
				String errorMessage = "";
				try {
					token = service.getAccessToken(reqToken, verifier);
				} catch (RuntimeException e) {
					errorMessage = e.getMessage();
				}
				Bundle values = new Bundle();
				if (token != null) {
					values.putSerializable("accessToken", token);
					values.putBoolean("success", true);
					sendMessage(values);
				} else {
					values.putString("errorMessage", errorMessage);
					sendMessage(values);
				}
			}
			
			private void sendMessage(Bundle values) {
				Message msg = Message.obtain();
				msg.setData(values);
				try {
					messenger.send(msg);
				} catch (RemoteException e) {
					Log.wtf(TAG, e.getMessage(), e);
				}
			}

		}.run();
		stopSelf();
	}
	
	public void getRequestToken(final OAuthService service, final Messenger messenger) {
		new Thread() {
			public void run() {
				Token token = null;
				String errorMessage = "";
				try {
					token = service.getRequestToken();
				} catch (RuntimeException e) {
					errorMessage = e.getMessage();
				}
				Bundle values = new Bundle();
				if (token != null) {
					values.putSerializable("requestToken", token);
					values.putBoolean("success", true);
					sendMessage(values);
				} else {
					values.putString("errorMessage", errorMessage);
					sendMessage(values);
				}
			}

			private void sendMessage(Bundle values) {
				Message msg = Message.obtain();
				msg.setData(values);
				try {
					messenger.send(msg);
				} catch (RemoteException e) {
					Log.wtf(TAG, e.getMessage(), e);
				}
			}

		}.run();
		stopSelf();
	}
	
	public void doApiCall(final OAuthService service, OAuthCredentials credentials, Bundle extras, final Messenger messenger) {
		Bundle params = extras.getBundle("params") != null ? extras.getBundle("params") : new Bundle();
		String payload = extras.getString("payload") != null ? extras.getString("payload") : "";

		final OAuthRequest request = signRequest(service, buildRequest((Verb) extras.getSerializable("httpMethod"), extras.getString("url"), params, payload), credentials);

		new Thread() {
			public void run() {
				Bundle values = new Bundle();
				values.putInt("responseCode", 0);
				values.putString("responseBody", "");
				boolean success = false;
				int attempts = 1;
				do {
					try {
						Response response = request.send();
						values.putInt("responseCode", response.getCode());
						values.putString("responseBody", response.getBody());
						if (values.getInt("responseCode") >= 200 & values.getInt("responseCode") < 400) {
							values.putBoolean("success", true);
							sendMessage(values);
							success = true;
							break;
						}
					} catch (RuntimeException e) {
						// The internal client is catching these messages, so whether we pass back the error message in the responseBody
						// is questionable.
						values.putString("responseBody", e.getMessage());
					}
					++attempts;
				} while (shouldRetry(values.getInt("responseCode")) && attempts <= maxAttempts);
				if (!success) {
					sendMessage(values);
				}
			}

			private void sendMessage(Bundle values) {
				Message msg = Message.obtain();
				msg.setData(values);
				try {
					messenger.send(msg);
				} catch (RemoteException e) {
					Log.wtf(TAG, e.getMessage(), e);
				}
			}

		}.run();
		stopSelf();
	}
	
	// Util methods

	private boolean shouldRetry(int statusCode) {
		if (statusCode == 0 || statusCode == 408 || statusCode >= 500) return true;
		return false;
	}
	
	protected OAuthService createOAuthService(Class<? extends Api> clazz, OAuthCredentials credentials, String redirectUrl) {
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

}