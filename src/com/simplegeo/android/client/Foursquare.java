package com.simplegeo.android.client;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;

public class Foursquare extends AbstractHttpClient {
	
	public Bundle apiEndpoints;
	
	public Foursquare() {
		apiEndpoints.putString("getVenue", "venues/%s");
		apiEndpoints.putString("getVenue", "venues/add");
		apiEndpoints.putString("getCategories", "venues/categories");
		apiEndpoints.putString("exploreVenues", "venues/explore");
		apiEndpoints.putString("searchVenues", "venues/search");
		apiEndpoints.putString("trendingVenues", "venues/trending");
		apiEndpoints.putString("hereNow", "venues/%s/herenow");
		apiEndpoints.putString("venueTips", "venues/%s/tips");
		apiEndpoints.putString("venuePhotos", "venues/%s/photos");
		apiEndpoints.putString("venueLinks", "venues/%s/links");
		apiEndpoints.putString("markVenueToDo", "venues/%s/marktodo");
		apiEndpoints.putString("flagVenue", "venues/%s/flag");
		apiEndpoints.putString("editVenue", "venues/%s/edit");
		apiEndpoints.putString("proposeEditVenue", "venues/%s/proposeedit");
		apiEndpoints.putString("getCheckin", "checkins/%s");
		apiEndpoints.putString("checkin", "checkins/add");
		apiEndpoints.putString("getRecentCheckins", "checkins/recent");
		apiEndpoints.putString("addComment", "checkins/%s/addcomment");
		apiEndpoints.putString("deleteComment", "checkins/%s/deletecomment");
		apiEndpoints.putString("getTip", "tips/%s");
		apiEndpoints.putString("addTip", "tips/add");
		apiEndpoints.putString("searchTips", "tips/search");
		apiEndpoints.putString("markTipToDo", "tips/%s/marktodo");
		apiEndpoints.putString("markTipDone", "tips/%s/markdone");
		apiEndpoints.putString("unmarkTip", "tips/%s/unmmeark");
		apiEndpoints.putString("getPhoto", "photos/%s");
		apiEndpoints.putString("addPhoto", "photos/add");
		apiEndpoints.putString("getSetting", "settings/%s");
		apiEndpoints.putString("setSetting", "settings/%s/set");
		apiEndpoints.putString("getSpecial", "specials/%s");
		apiEndpoints.putString("searchSpecials", "specials/search");
	}

	// Users endpoints
	
	// Venues endpoints
	
	/**
	 * Get venue details.
	 * 
	 * @param venueId A String id of a venue.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getVenue(String venueId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Add a new venue.
	 * 
	 * @param name A String name of the venue.
	 * @param latLon A String of the form lat,lon.
	 * @param extraParams A Bundle containing optional keys address, crossStreet, city, state, zip, phone, primaryCategoryId.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addVenue(String name, String latLon, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Get a list of venue categories.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getCategories(SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Explore nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param extraParams A Bundle containing optional keys llAcc, alt, altAcc, radius, section, query, limit, basis.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void exploreVenues(String latLon, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Search nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param extraParams A Bundle containing optional keys llAcc, alt, altAcc, radius, section, query, limit, basis.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchVenues(String latLon, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Return trending venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param extraParams A Bundle containing optional keys limit, radius.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void trendingVenues(String latLon, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve who's at this venue now.
	 * 
	 * @param venueId A String id of the venue.
	 * @param extraParams A Bundle containing optional keys limit, offset, afterTimestamp.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void hereNow(String venueId, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve who's at this venue now.
	 * 
	 * @param venueId A String id of the venue.
	 * @param extraParams A Bundle containing optional keys sort, limit, offset.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void venueTips(String venueId, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve photos of this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param extraParams A Bundle containing optional keys group, limit, offset.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void venuePhotos(String venueId, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve links of this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void venueLinks(String venueId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Mark this venue as a to-do and optionally set a tip.
	 * 
	 * @param venueId A String id of the venue.
	 * @param extraParams A Bundle containing optional key text.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void markVenueToDo(String venueId, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Flag this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param extraParams A Bundle containing optional key problem.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void flagVenue(String venueId, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Edit this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param extraParams A Bundle containing optional keys name, address, crossStreet, city, state, zip, phone, ll, categoryId.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void editVenue(String venueId, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Propose an edit this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param extraParams A Bundle containing optional keys name, address, crossStreet, city, state, zip, phone, ll, primaryCategoryId.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void proposeEditVenue(String venueId, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// Checkins endpoints
	
	/**
	 * Get checkin details.
	 * 
	 * @param checkinId A string id of the checkin.
	 * @param extraParams A Bundle containing optional key signature.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getCheckin(String checkinId, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Check in to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param extraParams A Bundle containing optional keys ll, llAcc, alt, altAcc.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void checkin(String venueId, boolean broadcast, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Check in to a venue without an id.
	 * 
	 * @param venueName A String name of a venue.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param extraParams A Bundle containing optional keys ll, llAcc, alt, altAcc.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void checkinToVenueWithoutId(String venueName, boolean broadcast, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Shout.
	 * 
	 * @param shout A String of a shout.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param extraParams A Bundle containing optional keys ll, llAcc, alt, altAcc.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void shout(String shout, boolean broadcast, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Get recent checkins from friends.
	 * 
	 * @param params A Bundle containing optional keys ll, limit, afterTimestamp.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRecentCheckins(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Comment on a check-in.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param text A String comment.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addComment(String checkinId, String text, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Remove a comment from a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param commentId A String id of a comment.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void deleteComment(String checkinId, String commentId, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// Tips endpoints
	
	/**
	 * Retrieve a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getTip(String tipId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Add a tip to a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param text A String of the tip text.
	 * @param extraParams A Bundle containing optional key url.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addTip(String venueId, String text, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Retrieves a list of tips near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param extraParams An Bundle of extra params. Accepted keys are limit, offset, filter and query.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchTips(String latLon, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Mark a tip as to-do.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void markTipToDo(String tipId, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Mark a tip as done.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void markTipDone(String tipId, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Unmark a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unmarkTip(String tipId, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// Photos endpoints
	
	/**
	 * Retrieve a photo.
	 * 
	 * @param photoId A String id of the photo.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getPhoto(String photoId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Add a photo to either a checkin, venue or tip.
	 * 
	 * @param photo A Bitmap of the photo.
	 * @param parameters A Bundle containing optional keys broadcast, ll, llAcc, alt and altAcc.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addPhotoToCheckin(String checkinId, Bitmap photo, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Add a photo to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param photo A Bitmap of the photo.
	 * @param parameters A Bundle containing optional keys broadcast, ll, llAcc, alt and altAcc.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addPhotoToVenue(String venueId, Bitmap photo, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Add a photo to a tip.
	 * 
	 * @param tipId A String id of a tip.
	 * @param photo A Bitmap of the photo.
	 * @param parameters A Bundle containing optional keys broadcast, ll, llAcc, alt and altAcc.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addPhotoToTip(String tipId, Bitmap photo, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// Settings endpoints
	
	/**
	 * Retrieves the value for the desired setting.
	 * 
	 * @param setting A String of the name of the desired setting.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSetting(String setting, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Convenience method for grabbing all settings.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getAllSettings(SmorgasbordCallback callback) {
		String setting = "all";
		// HttpGet
	}
	
	/**
	 * 
	 * @param setting A string name of the desired setting.
	 * @param value A string value to set the setting to.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void setSetting(String setting, String value, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// Specials endpoints
	
	/**
	 * Retrieve a single special.
	 * 
	 * @param specialId A string of the id of the special.
	 * @param venueId A string of the id of the venue.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSpecial(String specialId, String venueId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieves a list of specials near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param extraParams An Bundle of extra params. Accepted keys are llAcc, alt, altAcc and limit.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchSpecials(String latLon, Bundle extraParams, SmorgasbordCallback callback) {
		// HttpGet
	}
	
}
