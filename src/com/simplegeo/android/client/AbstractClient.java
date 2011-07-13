package com.simplegeo.android.client;

import android.os.Bundle;

public abstract class AbstractClient {

	public static Bundle initBundle(Bundle params, int size) {
		if (params == null) {
			return new Bundle(size);
		}
		return params;
	}
}
