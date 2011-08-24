package com.simplegeo.android.client;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

import org.scribe.builder.api.Foursquare2Api;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.type.OAuthCredentials;
import com.simplegeo.android.util.Util;

public class Foursquare extends AbstractClient {
	public static final String TAG = "Foursquare";
	
	private static final String foursquareUrl = "https://api.foursquare.com/v2";

	public Foursquare(OAuthCredentials credentials, String redirectUrl) {
		super(credentials, Foursquare2Api.class, redirectUrl);
	}

	// Users endpoints
	
	/**
	 * Get a user.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUser(String userId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s", URLEncoder.encode(userId)), null, null);
	}
	
	/**
	 * Get the users leaderboard.
	 * 
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/leaderboard.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getLeaderboard(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, "/users/leaderboard", params, null);
	}
		
	/**
	 * Get the users friend requests.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getFriendRequests() throws IOException {
		return this.executeRequest(Verb.GET, "/users/requests", null, null);
	}
		
	/**
	 * Get the users badges.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersBadges(String userId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/badges", URLEncoder.encode(userId)), null, null);
	}
	
	/**
	 * Get the users checkins.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersCheckins(String userId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/checkins", URLEncoder.encode(userId)), null, null);
	}
	
	/**
	 * Get the users friends.
	 * 
	 * @param userId A String id of a user.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/friends.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersFriends(String userId, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/friends", URLEncoder.encode(userId)), params, null);
	}	
	
	/**
	 * Get the users mayorships.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersMayorships(String userId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/mayorships", URLEncoder.encode(userId)), null, null);
	}
	
	/**
	 * Get the users tips.
	 * 
	 * @param userId A String id of a user.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/tips.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersTips(String userId, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/tips", URLEncoder.encode(userId)), params, null);
	}
	
	/**
	 * Get the users to-dos.
	 * 
	 * @param userId A String id of a user.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/todos.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersToDos(String userId, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/todos", URLEncoder.encode(userId)), params, null);
	}
	
	/**
	 * Get the users venue history.
	 * 
	 * @param userId A String id of a user.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/venuehistory.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersVenueHistory(String userId, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/venuehistory", URLEncoder.encode(userId)), params, null);
	}
	
	/**
	 * Send a friend request.
	 * 
	 * @param userId A String id of a user whose friendship to request.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response sendFriendRequest(String userId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/request", URLEncoder.encode(userId)), null, null);
	}
	
	/**
	 * Unfriend a user.
	 * 
	 * @param userId A String id of a user to unfriend.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unfriendUser(String userId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/unfriend", URLEncoder.encode(userId)), null, null);
	}
	
	/**
	 * Approve a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be approved.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response approveFriendRequest(String userId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/approve", URLEncoder.encode(userId)), null, null);
	}
	
	/**
	 * Deny a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response denyFriendRequest(String userId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/deny", URLEncoder.encode(userId)), null, null);
	}
	
	/**
	 * Turn pings on or off.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param value A Boolean.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response setPings(String userId, boolean value) throws IOException {
		Bundle params = new Bundle(1);
		params.putBoolean("value", value);
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/setpings", URLEncoder.encode(userId)), params, null);
	}
	
	// Venues endpoints
	
	/**
	 * Get venue details.
	 * 
	 * @param venueId A String id of a venue.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getVenue(String venueId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s", URLEncoder.encode(venueId)), null, null);
	}
	
	/**
	 * Add a new venue.
	 * 
	 * @param name A String name of the venue.
	 * @param latLon A String of the form lat,lon.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response addVenue(String name, String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("name", name);
		params.putString("ll", latLon);
		return this.executeRequest(Verb.POST, "/venues/add", params, null);
	}
	
	/**
	 * Get a list of venue categories.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getCategories() throws IOException {
		return this.executeRequest(Verb.GET, "/venues/categories", null, null);
	}
	
	/**
	 * Explore nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/explore.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response exploreVenues(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(Verb.GET, "/venues/explore", params, null);
	}
	
	/**
	 * Search nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/search.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response searchVenues(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(Verb.GET, "/venues/explore", params, null);
	}
		
	/**
	 * Return trending venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/trending.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response trendingVenues(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(Verb.GET, "/venues/trending", params, null);
	}
	
	/**
	 * Retrieve who's at return this venue now.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/herenow.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response hereNow(String venueId, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/herenow", URLEncoder.encode(venueId)), params, null);
	}
	
	/**
	 * Return tips for a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/tips.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response venueTips(String venueId, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/tips", URLEncoder.encode(venueId)), params, null);
	}
	
	/**
	 * Retrieve photos of return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/photos.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response venuePhotos(String venueId, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/photos", URLEncoder.encode(venueId)), params, null);
	}
	
	/**
	 * Retrieve links of return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response venueLinks(String venueId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/links", URLEncoder.encode(venueId)), null, null);
	}
	
	/**
	 * Mark return this venue as a to-do and optionally set a tip.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/marktodo.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response markVenueToDo(String venueId, Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/marktodo", URLEncoder.encode(venueId)), params, null);
	}
		
	/**
	 * Flag return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param problem A String problem that's one of mislocated, closed or duplicate.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response flagVenue(String venueId, String problem) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("problem", problem);
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/flag", URLEncoder.encode(venueId)), params, null);
	}
	
	/**
	 * Edit return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/edit.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response editVenue(String venueId, Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/edit", URLEncoder.encode(venueId)), params, null);
	}
		
	/**
	 * Propose an edit return this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/proposeedit.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response proposeEditVenue(String venueId, Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/proposeedit", URLEncoder.encode(venueId)), params, null);
	}
	
	// Checkins endpoints
	
	/**
	 * Get checkin details.
	 * 
	 * @param checkinId A string id of the checkin.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/checkins.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getCheckin(String checkinId, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/checkins/%s", URLEncoder.encode(checkinId)), params, null);
	}
	
	/**
	 * Check in to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param broadcast A String list telling foursquare who to tell about return this checkin.  private|public|public,facebook
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response checkin(String venueId, boolean broadcast, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venueId", venueId);
		params.putBoolean("broadcast", broadcast);
		return this.executeRequest(Verb.POST, foursquareUrl + "/checkins/add", params, null);
	}
		
	/**
	 * Check in to a venue without an id.
	 * 
	 * @param venueName A String name of a venue.
	 * @param broadcast A String list telling foursquare who to tell about return this checkin.  private|public|public,facebook
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response checkinToVenueWithoutId(String venueName, boolean broadcast, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venue", venueName);
		params.putBoolean("broadcast", broadcast);
		return this.executeRequest(Verb.POST, foursquareUrl + "/checkins/add", params, null);
	}
		
	/**
	 * Shout.
	 * 
	 * @param shout A String of a shout.
	 * @param broadcast A String list telling foursquare who to tell about return this checkin.  private|public|public,facebook
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response shout(String shout, boolean broadcast, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("shout", shout);
		params.putBoolean("broadcast", broadcast);
		return this.executeRequest(Verb.POST, foursquareUrl + "/checkins/add", params, null);
	}
	
	/**
	 * Get recent checkins from friends.
	 * 
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/recent.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRecentCheckins(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + "/checkins/recent", params, null);
	}
	
	/**
	 * Comment on a check-in.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param text A String comment.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response commentOnCheckin(String checkinId, String text) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("text", text);
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/checkins/%s/addcomment", URLEncoder.encode(checkinId)), params, null);
	}
	
	/**
	 * Remove a comment from a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param commentId A String id of a comment.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response deleteComment(String checkinId, String commentId) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("commentId", commentId);
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/checkins/%s/deletecomment", URLEncoder.encode(checkinId)), params, null);
	}
	
	// Tips endpoints
	
	/**
	 * Retrieve a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getTip(String tipId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/tips/%s", URLEncoder.encode(tipId)), null, null);
	}
	
	/**
	 * Add a tip to a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param text A String of the tip text.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response addTip(String venueId, String text, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venueId", venueId);
		params.putString("text", text);
		return this.executeRequest(Verb.POST, foursquareUrl + "/tips/add", params, null);
	}
		
	/**
	 * Retrieves a list of tips near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/search.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response searchTips(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(Verb.GET, foursquareUrl + "/tips/search", params, null);
	}
	
	/**
	 * Mark a tip as to-do.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response markTipToDo(String tipId) throws IOException {
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/marktodo", URLEncoder.encode(tipId)), null, null);
	}
	
	/**
	 * Mark a tip as done.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response markTipDone(String tipId) throws IOException {
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/markdone", URLEncoder.encode(tipId)), null, null);
	}
		
	/**
	 * Unmark a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unmarkTip(String tipId) throws IOException {
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/unmark", URLEncoder.encode(tipId)), null, null);
	}
	
	// Photos endpoints
	
	/**
	 * Retrieve a photo.
	 * 
	 * @param photoId A String id of the photo.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getPhoto(String photoId) throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/photos/%s", URLEncoder.encode(photoId)), null, null);
	}
	
	/**
	 * Add a photo to a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param photo A Bitmap of the photo.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response addPhotoToCheckin(String checkinId, Bitmap photo, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("checkinId", checkinId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		return this.executeRequest(Verb.POST, foursquareUrl + "/photos/add", params, null);
	}
		
	/**
	 * Add a photo to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param photo A Bitmap of the photo.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response addPhotoToVenue(String venueId, Bitmap photo, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("venueId", venueId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		return this.executeRequest(Verb.POST, foursquareUrl + "/photos/add", params, null);
	}
		
	/**
	 * Add a photo to a tip.
	 * 
	 * @param tipId A String id of a tip.
	 * @param photo A Bitmap of the photo.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response addPhotoToTip(String tipId, Bitmap photo, Bundle params) throws IOException {
		params= Util.initBundle(params, 1);
		params.putString("tipId", tipId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		return this.executeRequest(Verb.POST, foursquareUrl + "/photos/add", params, null);
	}
	
	// Settings endpoints
	
	/**
	 * Retrieves the value for the desired setting.
	 * 
	 * @param setting A String of the name of the desired setting.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSetting(String setting) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("setting_id", setting);
		return this.executeRequest(Verb.GET, foursquareUrl + "/settings/all", params, null);
	}
	
	/**
	 * Convenience method for grabbing all settings.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getAllSettings() throws IOException {
		return this.executeRequest(Verb.GET, foursquareUrl + "/settings/all", null, null);
	}
	
	/**
	 * 
	 * @param setting A string name of the desired setting.
	 * @param value A string value to set the setting to.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response setSetting(String setting, String value) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("value", value);
		return this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/settings/%s/set", URLEncoder.encode(setting)), params, null);
	}
	
	// Specials endpoints
	
	/**
	 * Retrieve a single special.
	 * 
	 * @param specialId A string of the id of the special.
	 * @param venueId A string of the id of the venue.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSpecial(String specialId, String venueId) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("venueId", venueId);
		return this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/specials/%s", URLEncoder.encode(specialId)), params, null);
	}
	
	/**
	 * Retrieves a list of specials near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/specials/specials.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response searchSpecials(String latLon, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		return this.executeRequest(Verb.GET, foursquareUrl + "/specials/search", params, null);
	}
	
}
