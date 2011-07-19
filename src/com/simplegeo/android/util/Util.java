package com.simplegeo.android.util;

import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Set;

import android.graphics.Bitmap;
import android.os.Bundle;

public class Util {
	
	public static Bundle initBundle(Bundle params, int size) {
		if (params == null) {
			return new Bundle(size);
		}
		return params;
	}

	public static byte[] bitmapToByteArray(Bitmap bmp) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		return stream.toByteArray();
	}
	
}
