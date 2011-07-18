package com.simplegeo.android.client;

import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;
import com.simplegeo.android.client.AbstractClient.HttpMethod;

public interface Client {

	public void executeRequest(HttpMethod httpMethod, String url,
			Bundle params, SmorgasbordCallback callback);

	public void handleResponse(SmorgasbordCallback callback);

}