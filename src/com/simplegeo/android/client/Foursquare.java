package com.simplegeo.android.client;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;

public class Foursquare extends AbstractClient {
	
	private static final String HTTP_URL = "https://api.foursquare.com/v2/";
	public Bundle apiEndpoints;
	
	public Foursquare() {
		apiEndpoints.putString("getUser", "users/%s");
		apiEndpoints.putString("getLeaderboard", "users/leaderboard");
		apiEndpoints.putString("getFriendRequests", "users/leaderboard");
		apiEndpoints.putString("getUsersBadges", "users/%s/badges");
		apiEndpoints.putString("getUsersCheckins", "users/%s/checkins");
		apiEndpoints.putString("getUsersFriends", "users/%s/friends");
		apiEndpoints.putString("getUsersMayorships", "users/%s/mayorships");
		apiEndpoints.putString("getUsersTips", "users/%s/tips");
		apiEndpoints.putString("getUsersToDos", "users/%s/todos");
		apiEndpoints.putString("getUsersVenueHistory", "users/%s/venuehistory");
		apiEndpoints.putString("sendFriendRequest", "users/%s/request");
		apiEndpoints.putString("unfriendUser", "users/%s/unfriend");
		apiEndpoints.putString("approveFriendRequest", "users/%s/approve");
		apiEndpoints.putString("denyFriendRequest", "users/%s/deny");
		apiEndpoints.putString("setPings", "users/%s/setpings");
		apiEndpoints.putString("getVenue", "venues/%s");
		apiEndpoints.putString("addVenue", "venues/add");
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
	
	/**
	 * Get a user.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUser(String userId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get the users leaderboard.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/leaderboard.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getLeaderboard(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Get the users friend requests.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFriendRequests(SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Get the users badges.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersBadges(String userId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get the users checkins.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersCheckins(String userId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get the users friends.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/friends.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersFriends(String userId, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}	
	
	/**
	 * Get the users mayorships.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersMayorships(String userId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get the users tips.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/tips.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersTips(String userId, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get the users to-dos.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/todos.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersToDos(String userId, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get the users venue history.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/venuehistory.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersVenueHistory(String userId, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Send a friend request.
	 * 
	 * @param userId A String id of a user whose friendship to request.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void sendFriendRequest(String userId, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Unfriend a user.
	 * 
	 * @param userId A String id of a user to unfriend.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unfriendUser(String userId, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Approve a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be approved.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void approveFriendRequest(String userId, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Deny a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void denyFriendRequest(String userId, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Turn pings on or off.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param value A Boolean.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void setPings(String userId, boolean value, SmorgasbordCallback callback) {
		// HttpPost
	}
	
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
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/add.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addVenue(String name, String latLon, Bundle params, SmorgasbordCallback callback) {
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
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/explore.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void exploreVenues(String latLon, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Search nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/search.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchVenues(String latLon, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Return trending venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/trending.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void trendingVenues(String latLon, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve who's at this venue now.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/herenow.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void hereNow(String venueId, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Return tips for a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/tips.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void venueTips(String venueId, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve photos of this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/photos.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void venuePhotos(String venueId, Bundle params, SmorgasbordCallback callback) {
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
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/marktodo.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void markVenueToDo(String venueId, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Flag this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/flag.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void flagVenue(String venueId, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Edit this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/edit.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void editVenue(String venueId, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Propose an edit this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/proposeedit.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void proposeEditVenue(String venueId, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// Checkins endpoints
	
	/**
	 * Get checkin details.
	 * 
	 * @param checkinId A string id of the checkin.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/checkins.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getCheckin(String checkinId, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Check in to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void checkin(String venueId, boolean broadcast, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Check in to a venue without an id.
	 * 
	 * @param venueName A String name of a venue.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void checkinToVenueWithoutId(String venueName, boolean broadcast, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Shout.
	 * 
	 * @param shout A String of a shout.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void shout(String shout, boolean broadcast, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Get recent checkins from friends.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/recent.html">here</a>.
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
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/add.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addTip(String venueId, String text, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Retrieves a list of tips near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/search.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchTips(String latLon, Bundle params, SmorgasbordCallback callback) {
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
	 * Add a photo to a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param photo A Bitmap of the photo.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addPhotoToCheckin(String checkinId, Bitmap photo, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Add a photo to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param photo A Bitmap of the photo.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addPhotoToVenue(String venueId, Bitmap photo, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Add a photo to a tip.
	 * 
	 * @param tipId A String id of a tip.
	 * @param photo A Bitmap of the photo.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addPhotoToTip(String tipId, Bitmap photo, Bundle params, SmorgasbordCallback callback) {
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
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/specials/specials.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchSpecials(String latLon, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
}
