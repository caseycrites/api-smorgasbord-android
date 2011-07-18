package com.simplegeo.android.client;

import java.net.URLEncoder;
import java.util.Locale;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;
import com.simplegeo.android.util.Util;

public class Foursquare extends AbstractClient {
	
	private static Foursquare foursquare = null;
	private static final String foursquareUrl = "https://api.foursquare.com/v2";

	public Foursquare(String accessToken) {
		super(accessToken);
	}
	
	// Users endpoints
	
	/**
	 * Get a user.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUser(String userId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s", URLEncoder.encode(userId)), null, callback);
	}
	
	/**
	 * Get the users leaderboard.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/leaderboard.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getLeaderboard(Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, "/users/leaderboard", params, callback);
	}
		
	/**
	 * Get the users friend requests.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFriendRequests(SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, "/users/requests", null, callback);
	}
		
	/**
	 * Get the users badges.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersBadges(String userId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/badges", URLEncoder.encode(userId)), null, callback);
	}
	
	/**
	 * Get the users checkins.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersCheckins(String userId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/checkins", URLEncoder.encode(userId)), null, callback);
	}
	
	/**
	 * Get the users friends.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/friends.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersFriends(String userId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/friends", URLEncoder.encode(userId)), params, callback);
	}	
	
	/**
	 * Get the users mayorships.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersMayorships(String userId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/mayorships", URLEncoder.encode(userId)), null, callback);
	}
	
	/**
	 * Get the users tips.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/tips.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersTips(String userId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/tips", URLEncoder.encode(userId)), params, callback);
	}
	
	/**
	 * Get the users to-dos.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/todos.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersToDos(String userId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/todos", URLEncoder.encode(userId)), params, callback);
	}
	
	/**
	 * Get the users venue history.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/venuehistory.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersVenueHistory(String userId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/venuehistory", URLEncoder.encode(userId)), params, callback);
	}
	
	/**
	 * Send a friend request.
	 * 
	 * @param userId A String id of a user whose friendship to request.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void sendFriendRequest(String userId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/request", URLEncoder.encode(userId)), null, callback);
	}
	
	/**
	 * Unfriend a user.
	 * 
	 * @param userId A String id of a user to unfriend.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unfriendUser(String userId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/unfriend", URLEncoder.encode(userId)), null, callback);
	}
	
	/**
	 * Approve a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be approved.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void approveFriendRequest(String userId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/approve", URLEncoder.encode(userId)), null, callback);
	}
	
	/**
	 * Deny a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void denyFriendRequest(String userId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/deny", URLEncoder.encode(userId)), null, callback);
	}
	
	/**
	 * Turn pings on or off.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param value A Boolean.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void setPings(String userId, boolean value, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params.putBoolean("value", value);
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/setpings", URLEncoder.encode(userId)), params, callback);
	}
	
	// Venues endpoints
	
	/**
	 * Get venue details.
	 * 
	 * @param venueId A String id of a venue.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getVenue(String venueId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s", URLEncoder.encode(venueId)), null, callback);
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
		params = Util.initBundle(params, 2);
		params.putString("name", name);
		params.putString("ll", latLon);
		this.executeRequest(HttpMethod.POST, "/venues/add", params, callback);
	}
	
	/**
	 * Get a list of venue categories.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getCategories(SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, "/venues/categories", null, callback);
	}
	
	/**
	 * Explore nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/explore.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void exploreVenues(String latLon, Bundle params, SmorgasbordCallback callback) {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(HttpMethod.GET, "/venues/explore", params, callback);
	}
	
	/**
	 * Search nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/search.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchVenues(String latLon, Bundle params, SmorgasbordCallback callback) {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(HttpMethod.GET, "/venues/explore", params, callback);
	}
		
	/**
	 * Return trending venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/trending.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void trendingVenues(String latLon, Bundle params, SmorgasbordCallback callback) {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(HttpMethod.GET, "/venues/trending", params, callback);
	}
	
	/**
	 * Retrieve who's at this venue now.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/herenow.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void hereNow(String venueId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/herenow", URLEncoder.encode(venueId)), params, callback);
	}
	
	/**
	 * Return tips for a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/tips.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void venueTips(String venueId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/tips", URLEncoder.encode(venueId)), params, callback);
	}
	
	/**
	 * Retrieve photos of this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/photos.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void venuePhotos(String venueId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/photos", URLEncoder.encode(venueId)), params, callback);
	}
	
	/**
	 * Retrieve links of this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void venueLinks(String venueId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/links", URLEncoder.encode(venueId)), null, callback);
	}
	
	/**
	 * Mark this venue as a to-do and optionally set a tip.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/marktodo.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void markVenueToDo(String venueId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/marktodo", URLEncoder.encode(venueId)), params, callback);
	}
		
	/**
	 * Flag this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param problem A String problem that's one of mislocated, closed or duplicate.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void flagVenue(String venueId, String problem, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params.putString("problem", problem);
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/flag", URLEncoder.encode(venueId)), params, callback);
	}
	
	/**
	 * Edit this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/edit.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void editVenue(String venueId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/edit", URLEncoder.encode(venueId)), params, callback);
	}
		
	/**
	 * Propose an edit this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/proposeedit.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void proposeEditVenue(String venueId, Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/proposeedit", URLEncoder.encode(venueId)), params, callback);
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
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/checkins/%s", URLEncoder.encode(checkinId)), params, callback);
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
		params = Util.initBundle(params, 2);
		params.putString("venueId", venueId);
		params.putBoolean("broadcast", broadcast);
		this.executeRequest(HttpMethod.POST, foursquareUrl + "/checkins/add", params, callback);
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
		params = Util.initBundle(params, 2);
		params.putString("venue", venueName);
		params.putBoolean("broadcast", broadcast);
		this.executeRequest(HttpMethod.POST, foursquareUrl + "/checkins/add", params, callback);
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
		params = Util.initBundle(params, 2);
		params.putString("shout", shout);
		params.putBoolean("broadcast", broadcast);
		this.executeRequest(HttpMethod.POST, foursquareUrl + "/checkins/add", params, callback);
	}
	
	/**
	 * Get recent checkins from friends.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/recent.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRecentCheckins(Bundle params, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + "/checkins/recent", params, callback);
	}
	
	/**
	 * Comment on a check-in.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param text A String comment.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void commentOnCheckin(String checkinId, String text, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params.putString("text", text);
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/checkins/%s/addcomment", URLEncoder.encode(checkinId)), params, callback);
	}
	
	/**
	 * Remove a comment from a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param commentId A String id of a comment.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void deleteComment(String checkinId, String commentId, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params.putString("commentId", commentId);
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/checkins/%s/deletecomment", URLEncoder.encode(checkinId)), params, callback);
	}
	
	// Tips endpoints
	
	/**
	 * Retrieve a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getTip(String tipId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/tips/%s", URLEncoder.encode(tipId)), null, callback);
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
		params = Util.initBundle(params, 2);
		params.putString("venueId", venueId);
		params.putString("text", text);
		this.executeRequest(HttpMethod.POST, foursquareUrl + "/tips/add", params, callback);
	}
		
	/**
	 * Retrieves a list of tips near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/search.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchTips(String latLon, Bundle params, SmorgasbordCallback callback) {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(HttpMethod.GET, foursquareUrl + "/tips/search", params, callback);
	}
	
	/**
	 * Mark a tip as to-do.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void markTipToDo(String tipId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/marktodo", URLEncoder.encode(tipId)), null, callback);
	}
	
	/**
	 * Mark a tip as done.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void markTipDone(String tipId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/markdone", URLEncoder.encode(tipId)), null, callback);
	}
		
	/**
	 * Unmark a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unmarkTip(String tipId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/unmark", URLEncoder.encode(tipId)), null, callback);
	}
	
	// Photos endpoints
	
	/**
	 * Retrieve a photo.
	 * 
	 * @param photoId A String id of the photo.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getPhoto(String photoId, SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/photos/%s", URLEncoder.encode(photoId)), null, callback);
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
		params = Util.initBundle(params, 1);
		params.putString("checkinId", checkinId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		this.executeRequest(HttpMethod.POST, foursquareUrl + "/photos/add", params, callback);
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
		params = Util.initBundle(params, 1);
		params.putString("venueId", venueId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		this.executeRequest(HttpMethod.POST, foursquareUrl + "/photos/add", params, callback);
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
		params = Util.initBundle(params, 1);
		params.putString("tipId", tipId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		this.executeRequest(HttpMethod.POST, foursquareUrl + "/photos/add", params, callback);
	}
	
	// Settings endpoints
	
	/**
	 * Retrieves the value for the desired setting.
	 * 
	 * @param setting A String of the name of the desired setting.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSetting(String setting, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params.putString("setting_id", setting);
		this.executeRequest(HttpMethod.GET, foursquareUrl + "/settings/all", params, callback);
	}
	
	/**
	 * Convenience method for grabbing all settings.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getAllSettings(SmorgasbordCallback callback) {
		this.executeRequest(HttpMethod.GET, foursquareUrl + "/settings/all", null, callback);
	}
	
	/**
	 * 
	 * @param setting A string name of the desired setting.
	 * @param value A string value to set the setting to.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void setSetting(String setting, String value, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params.putString("value", value);
		this.executeRequest(HttpMethod.POST, foursquareUrl + String.format(Locale.US, "/settings/%s/set", URLEncoder.encode(setting)), params, callback);
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
		Bundle params = new Bundle(1);
		params.putString("venueId", venueId);
		this.executeRequest(HttpMethod.GET, foursquareUrl + String.format(Locale.US, "/specials/%s", URLEncoder.encode(specialId)), params, callback);
	}
	
	/**
	 * Retrieves a list of specials near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/specials/specials.html">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchSpecials(String latLon, Bundle params, SmorgasbordCallback callback) {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(HttpMethod.GET, foursquareUrl + "/specials/search", params, callback);
	}
	
}
