package com.simplegeo.android.client;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.json.JSONException;

import android.os.Bundle;

import com.simplegeo.android.callback.SGCallback;
import com.simplegeo.android.http.SGHttpMethod;

public interface Client {

	public void executeRequest(SGHttpMethod httpMethod, String url,
			Bundle params, SGCallback callback) throws IOException;
}