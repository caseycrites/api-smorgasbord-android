package com.simplegeo.android.clients;

import java.io.IOException;

import org.scribe.builder.api.Api;
import org.scribe.model.Token;
import org.scribe.model.Verb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;

import com.simplegeo.android.services.HttpRequestService;
import com.simplegeo.android.types.OAuthCredentials;
import com.simplegeo.android.util.SGListener;


public abstract class AbstractClient implements Client {
	
	private Class<? extends Api> clazz;
	private Context context;
	private OAuthCredentials credentials;
	private String redirectUrl;
	
	public AbstractClient(OAuthCredentials credentials, Class<? extends Api> clazz, String redirectUrl, Context context) {
		this.credentials = credentials;
		this.clazz = clazz;
		this.redirectUrl = redirectUrl;
		this.context = context;
	}

	public void executeRequest(Verb httpMethod, String url, Bundle params, String payload, SGListener listener) throws IOException {
		Intent intent = new Intent(context, HttpRequestService.class);
		
		Bundle extras = new Bundle();
		extras.putSerializable("requestType", RequestType.API_CALL);
		extras.putSerializable("httpMethod", httpMethod);
		extras.putString("url", url);
		if (payload != null && !"".equals(payload)) extras.putString("payload", payload);
		if (params != null) extras.putBundle("params", params);
		extras.putParcelable("messenger", new Messenger(new ResponseHandler(listener)));
		extras.putParcelable("credentials", credentials);
		extras.putSerializable("clazz", clazz);
		extras.putString("redirectUrl", redirectUrl);
		
		intent.putExtras(extras);
		
		context.startService(intent);
	}
	
	public void getRequestToken(SGListener listener) {
		Intent intent = new Intent(context, HttpRequestService.class);
		
		Bundle extras = new Bundle();
		extras.putSerializable("requestType", RequestType.REQUEST_TOKEN);
		extras.putParcelable("messenger", new Messenger(new ResponseHandler(listener)));
		extras.putParcelable("credentials", credentials);
		extras.putSerializable("clazz", clazz);
		extras.putString("redirectUrl", redirectUrl);
		
		intent.putExtras(extras);
		
		context.startService(intent);
	}
	
	public void getAccessToken(Token requestToken, String verifierCode, SGListener listener) {
		Intent intent = new Intent(context, HttpRequestService.class);
		
		Bundle extras = new Bundle();
		extras.putSerializable("requestType", RequestType.ACCESS_TOKEN);
		extras.putParcelable("messenger", new Messenger(new ResponseHandler(listener)));
		extras.putParcelable("credentials", credentials);
		extras.putSerializable("clazz", clazz);
		extras.putString("redirectUrl", redirectUrl);
		extras.putSerializable("token", requestToken);
		extras.putString("verifierCode", verifierCode);
		
		intent.putExtras(extras);
		
		context.startService(intent);
	}
	
	public OAuthCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(OAuthCredentials credentials) {
		this.credentials = credentials;
	}
	
	public abstract String getAuthorizationUrl(Bundle params);
	
	private class ResponseHandler extends Handler {
		private final SGListener listener;
		
		public ResponseHandler(SGListener listener) {
			this.listener = listener;
		}
		
		@Override
		public void handleMessage(Message msg) {
			Bundle data = msg.getData();
			if (data.getBoolean("success")) {
				listener.onSuccess(data);
			} else {
				listener.onError(data);
			}
		}
	};

}
