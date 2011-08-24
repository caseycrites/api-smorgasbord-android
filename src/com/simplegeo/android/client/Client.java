package com.simplegeo.android.client;

import java.io.IOException;

import org.scribe.model.Response;
import org.scribe.model.Verb;

import android.os.Bundle;

public interface Client {

	public Response executeRequest(Verb httpMethod, String url,
			Bundle params, String payload) throws IOException;
}