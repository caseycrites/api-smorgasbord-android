package com.simplegeo.android.clients;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

import org.scribe.builder.api.Foursquare2Api;
import org.scribe.model.Verb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;

import com.simplegeo.android.types.OAuthCredentials;
import com.simplegeo.android.util.Util;

public class Foursquare extends AbstractClient {
	public static final String TAG = "Foursquare";
	
	private static final String foursquareUrl = "https://api.foursquare.com/v2";
	private String authorizationUrl = "https://foursquare.com/oauth2/authenticate?client_id=%s&response_type=code&redirect_uri=%s";

	public Foursquare(OAuthCredentials credentials, String redirectUrl, Context context) {
		super(credentials, Foursquare2Api.class, redirectUrl, context);
	}

	// Users endpoints
	
	/**
	 * Get a user.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getUser(String userId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s", URLEncoder.encode(userId)), null, null, handler);
	}
	
	/**
	 * Get the users leaderboard.
	 * 
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/leaderboard.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getLeaderboard(Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, "/users/leaderboard", params, null, handler);
	}
		
	/**
	 * Get the users friend requests.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getFriendRequests(Handler handler) throws IOException {
		this.executeRequest(Verb.GET, "/users/requests", null, null, handler);
	}
		
	/**
	 * Get the users badges.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getUsersBadges(String userId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/badges", URLEncoder.encode(userId)), null, null, handler);
	}
	
	/**
	 * Get the users checkins.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getUsersCheckins(String userId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/checkins", URLEncoder.encode(userId)), null, null, handler);
	}
	
	/**
	 * Get the users friends.
	 * 
	 * @param userId A String id of a user.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/friends.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getUsersFriends(String userId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/friends", URLEncoder.encode(userId)), params, null, handler);
	}	
	
	/**
	 * Get the users mayorships.
	 * 
	 * @param userId A String id of a user.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getUsersMayorships(String userId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/mayorships", URLEncoder.encode(userId)), null, null, handler);
	}
	
	/**
	 * Get the users tips.
	 * 
	 * @param userId A String id of a user.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/tips.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getUsersTips(String userId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/tips", URLEncoder.encode(userId)), params, null, handler);
	}
	
	/**
	 * Get the users to-dos.
	 * 
	 * @param userId A String id of a user.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/todos.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getUsersToDos(String userId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/todos", URLEncoder.encode(userId)), params, null, handler);
	}
	
	/**
	 * Get the users venue history.
	 * 
	 * @param userId A String id of a user.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/users/venuehistory.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getUsersVenueHistory(String userId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/venuehistory", URLEncoder.encode(userId)), params, null, handler);
	}
	
	/**
	 * Send a friend request.
	 * 
	 * @param userId A String id of a user whose friendship to request.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void sendFriendRequest(String userId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/request", URLEncoder.encode(userId)), null, null, handler);
	}
	
	/**
	 * Unfriend a user.
	 * 
	 * @param userId A String id of a user to unfriend.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void unfriendUser(String userId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/unfriend", URLEncoder.encode(userId)), null, null, handler);
	}
	
	/**
	 * Approve a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be approved.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void approveFriendRequest(String userId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/approve", URLEncoder.encode(userId)), null, null, handler);
	}
	
	/**
	 * Deny a friend request.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void denyFriendRequest(String userId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/deny", URLEncoder.encode(userId)), null, null, handler);
	}
	
	/**
	 * Turn pings on or off.
	 * 
	 * @param userId A String id of a user whose friend request should be denied.
	 * @param value A Boolean.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void setPings(String userId, boolean value, Handler handler) throws IOException {
		Bundle params = new Bundle(1);
		params.putBoolean("value", value);
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/users/%s/setpings", URLEncoder.encode(userId)), params, null, handler);
	}
	
	// Venues endpoints
	
	/**
	 * Get venue details.
	 * 
	 * @param venueId A String id of a venue.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getVenue(String venueId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s", URLEncoder.encode(venueId)), null, null, handler);
	}
	
	/**
	 * Add a new venue.
	 * 
	 * @param name A String name of the venue.
	 * @param latLon A String of the form lat,lon.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void addVenue(String name, String latLon, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("name", name);
		params.putString("ll", latLon);
		this.executeRequest(Verb.POST, "/venues/add", params, null, handler);
	}
	
	/**
	 * Get a list of venue categories.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getCategories(Handler handler) throws IOException {
		this.executeRequest(Verb.GET, "/venues/categories", null, null, handler);
	}
	
	/**
	 * Explore nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/explore.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void exploreVenues(String latLon, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(Verb.GET, "/venues/explore", params, null, handler);
	}
	
	/**
	 * Search nearby venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/search.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void searchVenues(String latLon, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(Verb.GET, "/venues/explore", params, null, handler);
	}
		
	/**
	 * trending venues.
	 * 
	 * @param latLon A String of the form lat,lon.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/trending.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void trendingVenues(String latLon, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(Verb.GET, "/venues/trending", params, null, handler);
	}
	
	/**
	 * Retrieve who's at this venue now.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/herenow.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void hereNow(String venueId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/herenow", URLEncoder.encode(venueId)), params, null, handler);
	}
	
	/**
	 * tips for a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/tips.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void venueTips(String venueId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/tips", URLEncoder.encode(venueId)), params, null, handler);
	}
	
	/**
	 * Retrieve photos of this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/photos.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void venuePhotos(String venueId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/photos", URLEncoder.encode(venueId)), params, null, handler);
	}
	
	/**
	 * Retrieve links of this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void venueLinks(String venueId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/venues/%s/links", URLEncoder.encode(venueId)), null, null, handler);
	}
	
	/**
	 * Mark this venue as a to-do and optionally set a tip.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/marktodo.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void markVenueToDo(String venueId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/marktodo", URLEncoder.encode(venueId)), params, null, handler);
	}
		
	/**
	 * Flag this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param problem A String problem that's one of mislocated, closed or duplicate.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void flagVenue(String venueId, String problem, Handler handler) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("problem", problem);
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/flag", URLEncoder.encode(venueId)), params, null, handler);
	}
	
	/**
	 * Edit this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/edit.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void editVenue(String venueId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/edit", URLEncoder.encode(venueId)), params, null, handler);
	}
		
	/**
	 * Propose an edit this venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/venues/proposeedit.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void proposeEditVenue(String venueId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/venues/%s/proposeedit", URLEncoder.encode(venueId)), params, null, handler);
	}
	
	// Checkins endpoints
	
	/**
	 * Get checkin details.
	 * 
	 * @param checkinId A string id of the checkin.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/checkins.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getCheckin(String checkinId, Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/checkins/%s", URLEncoder.encode(checkinId)), params, null, handler);
	}
	
	/**
	 * Check in to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void checkin(String venueId, boolean broadcast, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venueId", venueId);
		params.putBoolean("broadcast", broadcast);
		this.executeRequest(Verb.POST, foursquareUrl + "/checkins/add", params, null, handler);
	}
		
	/**
	 * Check in to a venue without an id.
	 * 
	 * @param venueName A String name of a venue.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void checkinToVenueWithoutId(String venueName, boolean broadcast, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venue", venueName);
		params.putBoolean("broadcast", broadcast);
		this.executeRequest(Verb.POST, foursquareUrl + "/checkins/add", params, null, handler);
	}
		
	/**
	 * Shout.
	 * 
	 * @param shout A String of a shout.
	 * @param broadcast A String list telling foursquare who to tell about this checkin.  private|public|public,facebook
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void shout(String shout, boolean broadcast, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("shout", shout);
		params.putBoolean("broadcast", broadcast);
		this.executeRequest(Verb.POST, foursquareUrl + "/checkins/add", params, null, handler);
	}
	
	/**
	 * Get recent checkins from friends.
	 * 
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/checkins/recent.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getRecentCheckins(Bundle params, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + "/checkins/recent", params, null, handler);
	}
	
	/**
	 * Comment on a check-in.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param text A String comment.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void commentOnCheckin(String checkinId, String text, Handler handler) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("text", text);
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/checkins/%s/addcomment", URLEncoder.encode(checkinId)), params, null, handler);
	}
	
	/**
	 * Remove a comment from a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param commentId A String id of a comment.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void deleteComment(String checkinId, String commentId, Handler handler) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("commentId", commentId);
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/checkins/%s/deletecomment", URLEncoder.encode(checkinId)), params, null, handler);
	}
	
	// Tips endpoints
	
	/**
	 * Retrieve a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getTip(String tipId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/tips/%s", URLEncoder.encode(tipId)), null, null, handler);
	}
	
	/**
	 * Add a tip to a venue.
	 * 
	 * @param venueId A String id of the venue.
	 * @param text A String of the tip text.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void addTip(String venueId, String text, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("venueId", venueId);
		params.putString("text", text);
		this.executeRequest(Verb.POST, foursquareUrl + "/tips/add", params, null, handler);
	}
		
	/**
	 * Retrieves a list of tips near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/tips/search.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void searchTips(String latLon, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(Verb.GET, foursquareUrl + "/tips/search", params, null, handler);
	}
	
	/**
	 * Mark a tip as to-do.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void markTipToDo(String tipId, Handler handler) throws IOException {
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/marktodo", URLEncoder.encode(tipId)), null, null, handler);
	}
	
	/**
	 * Mark a tip as done.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void markTipDone(String tipId, Handler handler) throws IOException {
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/markdone", URLEncoder.encode(tipId)), null, null, handler);
	}
		
	/**
	 * Unmark a tip.
	 * 
	 * @param tipId A String id of the tip.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void unmarkTip(String tipId, Handler handler) throws IOException {
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/tips/%s/unmark", URLEncoder.encode(tipId)), null, null, handler);
	}
	
	// Photos endpoints
	
	/**
	 * Retrieve a photo.
	 * 
	 * @param photoId A String id of the photo.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getPhoto(String photoId, Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/photos/%s", URLEncoder.encode(photoId)), null, null, handler);
	}
	
	/**
	 * Add a photo to a checkin.
	 * 
	 * @param checkinId A String id of a checkin.
	 * @param photo A Bitmap of the photo.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void addPhotoToCheckin(String checkinId, Bitmap photo, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("checkinId", checkinId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		this.executeRequest(Verb.POST, foursquareUrl + "/photos/add", params, null, handler);
	}
		
	/**
	 * Add a photo to a venue.
	 * 
	 * @param venueId A String id of a venue.
	 * @param photo A Bitmap of the photo.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void addPhotoToVenue(String venueId, Bitmap photo, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("venueId", venueId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		this.executeRequest(Verb.POST, foursquareUrl + "/photos/add", params, null, handler);
	}
		
	/**
	 * Add a photo to a tip.
	 * 
	 * @param tipId A String id of a tip.
	 * @param photo A Bitmap of the photo.
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/photos/add.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void addPhotoToTip(String tipId, Bitmap photo, Bundle params, Handler handler) throws IOException {
		params= Util.initBundle(params, 1);
		params.putString("tipId", tipId);
		params.putByteArray("image", Util.bitmapToByteArray(photo));
		this.executeRequest(Verb.POST, foursquareUrl + "/photos/add", params, null, handler);
	}
	
	// Settings endpoints
	
	/**
	 * Retrieves the value for the desired setting.
	 * 
	 * @param setting A String of the name of the desired setting.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getSetting(String setting, Handler handler) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("setting_id", setting);
		this.executeRequest(Verb.GET, foursquareUrl + "/settings/all", params, null, handler);
	}
	
	/**
	 * Convenience method for grabbing all settings.
	 * 
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getAllSettings(Handler handler) throws IOException {
		this.executeRequest(Verb.GET, foursquareUrl + "/settings/all", null, null, handler);
	}
	
	/**
	 * 
	 * @param setting A string name of the desired setting.
	 * @param value A string value to set the setting to.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void setSetting(String setting, String value, Handler handler) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("value", value);
		this.executeRequest(Verb.POST, foursquareUrl + String.format(Locale.US, "/settings/%s/set", URLEncoder.encode(setting)), params, null, handler);
	}
	
	// Specials endpoints
	
	/**
	 * Retrieve a single special.
	 * 
	 * @param specialId A string of the id of the special.
	 * @param venueId A string of the id of the venue.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void getSpecial(String specialId, String venueId, Handler handler) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("venueId", venueId);
		this.executeRequest(Verb.GET, foursquareUrl + String.format(Locale.US, "/specials/%s", URLEncoder.encode(specialId)), params, null, handler);
	}
	
	/**
	 * Retrieves a list of specials near the specified location.
	 * 
	 * @param latLon A String of the form lat,lon
	 * @param params, null A {@link Bundle} containing optional keys listed @see <a href="https://developer.foursquare.com/docs/specials/specials.html">here</a>.
	 * @param callback A {@link SGDelegate}.
	 * @{@link void}
	 * @throws IOException 
	 */
	public void searchSpecials(String latLon, Bundle params, Handler handler) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("ll", latLon);
		this.executeRequest(Verb.GET, foursquareUrl + "/specials/search", params, null, handler);
	}

	@Override
	public String getAuthorizationUrl(Bundle params) {
		return String.format(Locale.US, authorizationUrl, params.getString("clientId"), params.getString("redirectUri"));
	}
	
}
