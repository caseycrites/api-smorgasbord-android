package com.simplegeo.android.util;

import android.os.Bundle;

/**
 * Smorgasbord specific Listener for asynchronous methods.
 * 
 * @author caseycrites
 *
 */
public interface SGListener {
	
	/**
	 * Callback method for successful operations.
	 * 
	 * @param values
	 */
	public void onSuccess(Bundle values);
	
	/**
	 * Callback method for erred operations.
	 * 
	 * @param values
	 */
	public void onError(Bundle values);

}
