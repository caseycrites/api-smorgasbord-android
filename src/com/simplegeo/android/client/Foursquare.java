package com.simplegeo.android.client;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.http.SGHttpMethod;
import com.simplegeo.android.http.SGHttpResponse;
import com.simplegeo.android.type.OAuthConfig;
import com.simplegeo.android.util.Util;

public class Foursquare extends AbstractClient {
	public static final String TAG = "Foursquare";
	
	private static final String foursquareUrl = "https://api.foursquare.com/v2";

	public Foursquare(OAuthConfig credentials) {
		super(credentials);
	}

	// Users endpoints
	
	/**
	 * Get a user.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getUser(String userId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s", URLEncoder.encode(userId)), null);
	}
	
	/**
	 * Get the users leaderboard.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/leaderboard.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getLeaderboard(Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, "/users/leaderboard", params);
	}
		
	/**
	 * Get the users friend requests.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getFriendRequests() throws IOException {
		return this.executeRequest(SGHttpMethod.GET, "/users/requests", null);
	}
		
	/**
	 * Get the users badges.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getUsersBadges(String userId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/badges", URLEncoder.encode(userId)), null);
	}
	
	/**
	 * Get the users checkins.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getUsersCheckins(String userId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/checkins", URLEncoder.encode(userId)), null);
	}
	
	/**
	 * Get the users friends.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/friends.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getUsersFriends(String userId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/friends", URLEncoder.encode(userId)), params);
	}	
	
	/**
	 * Get the users mayorships.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getUsersMayorships(String userId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/mayorships", URLEncoder.encode(userId)), null);
	}
	
	/**
	 * Get the users tips.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/tips.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getUsersTips(String userId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/tips", URLEncoder.encode(userId)), params);
	}
	
	/**
	 * Get the users to-dos.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/todos.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getUsersToDos(String userId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/todos", URLEncoder.encode(userId)), params);
	}
	
	/**
	 * Get the users venue history.
	 * 
	 * @param userId A String id of a user.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/venuehistory.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getUsersVenueHistory(String userId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/venuehistory", URLEncoder.encode(userId)), params);
	}
	
	/**
	 * Send a friend request.
	 * 
	 * @param userId A String id of a user whose friendship to request.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse sendFriendRequest(String userId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/request", URLEncoder.encode(userId)), null);
	}
	
	/**
	 * Unfriend a user.
	 * 
	 * @param userId A String id of a user to unfriend.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse unfriendUser(String userId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/unfriend", URLEncoder.encode(userId)), null);
	}
	
	/**
	 * Approve a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be approved.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse approveFriendRequest(String userId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/approve", URLEncoder.encode(userId)), null);
	}
	
	/**
	 * Deny a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse denyFriendRequest(String userId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/deny", URLEncoder.encode(userId)), null);
	}
	
	/**
	 * Turn pings on or off.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param value A Boolean.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse setPings(String userId, boolean value) throws IOException {
		Bundle params = new Bundle(1);
		params.putBoolean("value", value);
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/users/%s/setpings", URLEncoder.encode(userId)), params);
	}
	
	// Venues endpoints
	
	/**
	 * Get venue details.
	 * 
	 * @param venueId A String id of a venue.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getVenue(String venueId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s", URLEncoder.encode(venueId)), null);
	}
	
	/**
	 * Add a new venue.
	 * 
	 * @param name A String name of the venue.
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse addVenue(String name, String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("name", name);
		params.putString("ll", latLon);
		return this.executeRequest(SGHttpMethod.POST, "/venues/add", params);
	}
	
	/**
	 * Get a list of venue categories.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getCategories() throws IOException {
		return this.executeRequest(SGHttpMethod.GET, "/venues/categories", null);
	}
	
	/**
	 * Explore nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/explore.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse exploreVenues(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(SGHttpMethod.GET, "/venues/explore", params);
	}
	
	/**
	 * Search nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/search.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse searchVenues(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(SGHttpMethod.GET, "/venues/explore", params);
	}
		
	/**
	 * Return trending venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/trending.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse trendingVenues(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(SGHttpMethod.GET, "/venues/trending", params);
	}
	
	/**
	 * Retrieve who's at return this venue now.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/herenow.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse hereNow(String venueId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/herenow", URLEncoder.encode(venueId)), params);
	}
	
	/**
	 * Return tips for a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/tips.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse venueTips(String venueId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/tips", URLEncoder.encode(venueId)), params);
	}
	
	/**
	 * Retrieve photos of return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/photos.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse venuePhotos(String venueId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/photos", URLEncoder.encode(venueId)), params);
	}
	
	/**
	 * Retrieve links of return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse venueLinks(String venueId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/links", URLEncoder.encode(venueId)), null);
	}
	
	/**
	 * Mark return this venue as a to-do and optionally set a tip.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/marktodo.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse markVenueToDo(String venueId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/marktodo", URLEncoder.encode(venueId)), params);
	}
		
	/**
	 * Flag return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param problem A String problem that's one of mislocated, closed or duplicate.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse flagVenue(String venueId, String problem) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("problem", problem);
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/flag", URLEncoder.encode(venueId)), params);
	}
	
	/**
	 * Edit return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/edit.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse editVenue(String venueId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/edit", URLEncoder.encode(venueId)), params);
	}
		
	/**
	 * Propose an edit return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/proposeedit.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse proposeEditVenue(String venueId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/proposeedit", URLEncoder.encode(venueId)), params);
	}
	
	// Checkins endpoints
	
	/**
	 * Get checkin details.
	 * 
	 * @param checkinId A string id of the checkin.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/checkins.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getCheckin(String checkinId, Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/checkins/%s", URLEncoder.encode(checkinId)), params);
	}
	
	/**
	 * Check in to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param broadcast A String list telling foursquare who to tell about return this checkin.  private|public|public,facebook
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse checkin(String venueId, boolean broadcast, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venueId", venueId);
		params.putBoolean("broadcast", broadcast);
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + "/checkins/add", params);
	}
		
	/**
	 * Check in to a venue without an id.
	 * 
	 * @param venueName A String name of a venue.
	 * @param broadcast A String list telling foursquare who to tell about return this checkin.  private|public|public,facebook
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse checkinToVenueWithoutId(String venueName, boolean broadcast, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venue", venueName);
		params.putBoolean("broadcast", broadcast);
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + "/checkins/add", params);
	}
		
	/**
	 * Shout.
	 * 
	 * @param shout A String of a shout.
	 * @param broadcast A String list telling foursquare who to tell about return this checkin.  private|public|public,facebook
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse shout(String shout, boolean broadcast, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("shout", shout);
		params.putBoolean("broadcast", broadcast);
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + "/checkins/add", params);
	}
	
	/**
	 * Get recent checkins from friends.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/recent.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getRecentCheckins(Bundle params) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + "/checkins/recent", params);
	}
	
	/**
	 * Comment on a check-in.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param text A String comment.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse commentOnCheckin(String checkinId, String text) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("text", text);
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/checkins/%s/addcomment", URLEncoder.encode(checkinId)), params);
	}
	
	/**
	 * Remove a comment from a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param commentId A String id of a comment.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse deleteComment(String checkinId, String commentId) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("commentId", commentId);
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/checkins/%s/deletecomment", URLEncoder.encode(checkinId)), params);
	}
	
	// Tips endpoints
	
	/**
	 * Retrieve a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getTip(String tipId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/tips/%s", URLEncoder.encode(tipId)), null);
	}
	
	/**
	 * Add a tip to a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param text A String of the tip text.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse addTip(String venueId, String text, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venueId", venueId);
		params.putString("text", text);
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + "/tips/add", params);
	}
		
	/**
	 * Retrieves a list of tips near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/search.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse searchTips(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + "/tips/search", params);
	}
	
	/**
	 * Mark a tip as to-do.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse markTipToDo(String tipId) throws IOException {
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/marktodo", URLEncoder.encode(tipId)), null);
	}
	
	/**
	 * Mark a tip as done.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse markTipDone(String tipId) throws IOException {
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/markdone", URLEncoder.encode(tipId)), null);
	}
		
	/**
	 * Unmark a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse unmarkTip(String tipId) throws IOException {
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/unmark", URLEncoder.encode(tipId)), null);
	}
	
	// Photos endpoints
	
	/**
	 * Retrieve a photo.
	 * 
	 * @param photoId A String id of the photo.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getPhoto(String photoId) throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/photos/%s", URLEncoder.encode(photoId)), null);
	}
	
	/**
	 * Add a photo to a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param photo A Bitmap of the photo.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse addPhotoToCheckin(String checkinId, Bitmap photo, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("checkinId", checkinId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + "/photos/add", params);
	}
		
	/**
	 * Add a photo to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param photo A Bitmap of the photo.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse addPhotoToVenue(String venueId, Bitmap photo, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("venueId", venueId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + "/photos/add", params);
	}
		
	/**
	 * Add a photo to a tip.
	 * 
	 * @param tipId A String id of a tip.
	 * @param photo A Bitmap of the photo.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse addPhotoToTip(String tipId, Bitmap photo, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("tipId", tipId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + "/photos/add", params);
	}
	
	// Settings endpoints
	
	/**
	 * Retrieves the value for the desired setting.
	 * 
	 * @param setting A String of the name of the desired setting.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getSetting(String setting) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("setting_id", setting);
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + "/settings/all", params);
	}
	
	/**
	 * Convenience method for grabbing all settings.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getAllSettings() throws IOException {
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + "/settings/all", null);
	}
	
	/**
	 * 
	 * @param setting A string name of the desired setting.
	 * @param value A string value to set the setting to.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse setSetting(String setting, String value) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("value", value);
		return this.executeRequest(SGHttpMethod.POST, foursquareUrl + String.format(Locale.US, "/settings/%s/set", URLEncoder.encode(setting)), params);
	}
	
	// Specials endpoints
	
	/**
	 * Retrieve a single special.
	 * 
	 * @param specialId A string of the id of the special.
	 * @param venueId A string of the id of the venue.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse getSpecial(String specialId, String venueId) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("venueId", venueId);
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + String.format(Locale.US, "/specials/%s", URLEncoder.encode(specialId)), params);
	}
	
	/**
	 * Retrieves a list of specials near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/specials/specials.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link SGHttpResponse}
	 * @throws IOException 
	 */
	public SGHttpResponse searchSpecials(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(SGHttpMethod.GET, foursquareUrl + "/specials/search", params);
	}
	
}
