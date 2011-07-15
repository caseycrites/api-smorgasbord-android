package com.simplegeo.android.client;

import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;

public abstract class AbstractClient {
	
	public static enum HttpMethod { GET, POST, PUT, DELETE }
	
	// TODO Perhaps this should just be a Credentials object?
	public AbstractClient(String accessToken) {
		this(null, null, accessToken, null);
	}

	public AbstractClient(String consumerKey, String consumerSecret) {
		this(consumerKey, consumerSecret, null, null);
	}

	public AbstractClient(String consumerKey, String consumerSecret, String accessToken, String accessSecret) {
	}

	public static Bundle initBundle(Bundle params, int size) {
		if (params == null) {
			return new Bundle(size);
		}
		return params;
	}

	public static String dictFormat(String format, Bundle values) {
		StringBuffer convFormat = new StringBuffer(format);
		Set<String> keys = values.keySet();
		ArrayList valueList = new ArrayList();
		int currentPos = 1;
		Iterator<String> keysIter = keys.iterator();
		while (keysIter.hasNext()) {
			String key = keysIter.next(),
					formatKey = "%(" + key + ")",
					formatPos = "%" + Integer.toString(currentPos) + "$";
			int index = -1;
			while ((index = convFormat.indexOf(formatKey, index)) != -1) {
				convFormat.replace(index, index + formatKey.length(), formatPos);
				index += formatPos.length();
			}
			// If it's an array list, we need to make it a string
			Object value = values.get(key);
			if (value instanceof ArrayList) {
				String newValue = ((ArrayList) value).toString();
				value = newValue.substring(1, newValue.length());
			}
			valueList.add(URLEncoder.encode((String)value));
			++currentPos;
		}
		return String.format(Locale.US, convFormat.toString(), valueList.toArray());
	}
	
	public void executeRequest(HttpMethod httpMethod, String url, Bundle params, SmorgasbordCallback callback) {
		
	}
	
	private void handleResponse() {
		// This should handle the response from executeRequest and then send it to the appropriate method in the SmorgasbordCallback.
	}
	
	public byte[] bitmapToByteArray(Bitmap bmp) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		return stream.toByteArray();
	}

}
