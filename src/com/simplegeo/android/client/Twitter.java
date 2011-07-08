package com.simplegeo.android.client;

import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;

public class Twitter extends AbstractClient {

	private static final String HTTP_URL = "";
	public Bundle apiEndpoints;
	
	public Twitter() {
		apiEndpoints.putString("verifyCredentials", "account/verify_credentials.%s");
	}
			
	// Account endpoints
	
	/**
	 * Verify a users supplied credentials.
	 * 
	 * @param params A {@link Bundle} containing optional keys include_entities, skip_status.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void verifyCredentials(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	// Block endpoints
	
	// Timeline endpoints
	
	// Tweet endpoints
	
	// User endpoints
	
	// Trends endpoints
	
	// Local Trends endpoints
	
	// List endpoints
	
	// List Member endpoints
	
	// List Subscriber endpoints
	
	// Direct Message endpoints
	
	// Friendship endpoints
	
	// Friend And Follower endpoints
	
	// Favorites endpoints
	
	// Notification endpoints
	
	// Spam Reporting endpoints
	
	// Saved Searches endpoints
	
	// OAuth endpoints
	
	// Geo endpoints
	
	// Legal endpoints
	
	// Help endpoints
	
	// Search endpoints

}
