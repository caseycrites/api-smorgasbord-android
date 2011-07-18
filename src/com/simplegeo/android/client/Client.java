package com.simplegeo.android.client;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.json.JSONException;

import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;
import com.simplegeo.android.client.AbstractClient.HttpMethod;

public interface Client {

	public void executeRequest(HttpMethod httpMethod, String url,
			Bundle params, SmorgasbordCallback callback) throws IOException;

	public void handleResponse(HttpURLConnection connection, SmorgasbordCallback callback) throws IOException, JSONException;

}