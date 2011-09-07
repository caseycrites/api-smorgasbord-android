package com.simplegeo.android.types;

import android.os.Bundle;

public class User {
	
	private String userId;
	private String screenName;
	
	public User(String userId, String screenName) {
		this.userId = userId;
		this.screenName = screenName;
	}
	
	public User() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	public Bundle appendToBundle(Bundle params) {
		if (this.userId != null) { params.putString("user_id", this.userId); return params; }
		if (this.screenName != null) { params.putString("screen_name", this.screenName); return params; }
		return params;
	}

}
