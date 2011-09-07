package com.simplegeo.android.types;

import android.os.Bundle;

public class TwitterList {

	private String listId;
	private String slug;
	private String ownerId;
	private String ownerScreenName;
	
	public TwitterList(String listId) {
		this.listId = listId;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerScreenName() {
		return ownerScreenName;
	}

	public void setOwnerScreenName(String ownerScreenName) {
		this.ownerScreenName = ownerScreenName;
	}
	
	public Bundle appendToBundle(Bundle params) {
		if (this.listId != null) { params.putString("list_id", this.listId); }
		if (this.slug != null) { params.putString("slug", this.slug); }
		if (this.ownerId != null) { params.putString("owner_id", this.ownerId); }
		if (this.ownerScreenName != null) { params.putString("owner_screen_name", this.ownerScreenName); }
		return params;
	}
	
}
