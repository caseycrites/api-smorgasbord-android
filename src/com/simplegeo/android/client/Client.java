package com.simplegeo.android.client;

import java.io.IOException;

import android.os.Bundle;

import com.simplegeo.android.http.SGHttpMethod;
import com.simplegeo.android.http.SGHttpResponse;

public interface Client {

	public SGHttpResponse executeRequest(SGHttpMethod httpMethod, String url,
			Bundle params) throws IOException;
}