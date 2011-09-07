package com.simplegeo.android.types;

import java.util.ArrayList;

import android.os.Bundle;

public class UserCollection {

	private ArrayList<User> users;
	
	public UserCollection(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public Bundle appendToBundle(Bundle params) {
		ArrayList<String> userIds = new ArrayList<String>();
		ArrayList<String> screenNames = new ArrayList<String>();
		for (User user : this.users) {
			if (user.getUserId() != null) { userIds.add(user.getUserId()); continue;}
			if (user.getScreenName() != null) { screenNames.add(user.getScreenName()); }
		}
		if (userIds.size() > 0) { params.putStringArrayList("user_id", userIds); }
		if (screenNames.size() > 0) { params.putStringArrayList("screen_name", screenNames); }
		return params;
	}
	
}
