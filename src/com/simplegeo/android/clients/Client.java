package com.simplegeo.android.clients;

import java.io.IOException;

import org.scribe.model.Verb;

import android.os.Bundle;
import android.os.Handler;

public interface Client {
	
	public enum RequestType {
		REQUEST_TOKEN,
		ACCESS_TOKEN,
		API_CALL
	}

	public void executeRequest(Verb httpMethod, String url,
			Bundle params, String payload, Handler handler) throws IOException;
}