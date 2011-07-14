package com.simplegeo.android.client;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;
import com.simplegeo.android.type.TwitterList;
import com.simplegeo.android.type.User;
import com.simplegeo.android.type.UserCollection;

public class Twitter extends AbstractClient {

	private static final String HTTP_URL = "http://api.twitter.com/1/";
	
	public Twitter(String format) {
		
	}
	
	public void verifyCredentials(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve the users rate limit status.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void rateLimitStatus(SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Retrieve the users totals for friends, followers, updates and favorites.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void totals(SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve the users account settings.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSettings(SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Sets the users account settings.  Use this to update a bunch of user settings at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/settings">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void setSettings(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Set the trend location.
	 * 
	 * @param trendLocation A String of a @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth ID</a> to use as the user's default trending location.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void setTrendLocation(String trendLocation, SmorgasbordCallback callback) {
		Bundle trendBundle = new Bundle(1);
		trendBundle.putString("trend_location_woeid", trendLocation);
		setSettings(trendBundle, callback);
	}
	
	/**
	 * Enable sleep time and set the start and end sleep time.
	 * 
	 * @param startSleepTime An int in the range, 0-23.
	 * @param endSleepTime An int in the range, 0-23.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void enableSleepTime(int startSleepTime, int endSleepTime, SmorgasbordCallback callback) {
		Bundle sleepBundle = new Bundle(3);
		sleepBundle.putBoolean("sleep_time_enabled", true);
		sleepBundle.putString("start_sleep_time", String.valueOf(startSleepTime));
		sleepBundle.putString("end_sleep_time", String.valueOf(endSleepTime));
		setSettings(sleepBundle, callback);
	}
	
	/**
	 * Disable sleep time.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void disableSleepTime(SmorgasbordCallback callback) {
		Bundle sleepBundle = new Bundle(1);
		sleepBundle.putBoolean("sleep_time_enabled", false);
		setSettings(sleepBundle, callback);
	}
	
	/**
	 * Set time zone.
	 * 
	 * @param timeZone A String of one of the @see <a href="http://api.rubyonrails.org/classes/ActiveSupport/TimeZone.html">Rails Time Zone's</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void setTimeZone(String timeZone, SmorgasbordCallback callback) {
		Bundle timeZoneBundle = new Bundle(1);
		timeZoneBundle.putString("time_zone", timeZone);
		setSettings(timeZoneBundle, callback);
	}
		
	/**
	 * Set language.
	 * 
	 * @param lang A String of one of the @see <a href="https://dev.twitter.com/docs/api/1/get/help/languages">Twitter Supported Languages.</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void setLanguage(String lang, SmorgasbordCallback callback) {
		Bundle langBundle = new Bundle(1);
		langBundle.putString("lang", lang);
		setSettings(langBundle, callback);
	}
	
	/**
	 * Update whether a user receives SMS alerts or not.
	 * 
	 * @param device A String of either sms or none.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_delivery_device">here</a>.
	 * @param callback
	 */
	public void updateDeliveryDevice(String device, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Update the user's profile.  Use this method to update a bunch of profile settings at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfile(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Update the user's full name.
	 * 
	 * @param name A String of the user's full name. Must be 20 characters or less.
	 * @param callback {@link SmorgasbordCallback}.
	 */
	public void updateName(String name, SmorgasbordCallback callback) {
		Bundle nameBundle = new Bundle(1);
		nameBundle.putString("name", name);
		updateProfile(nameBundle, callback);
	}
		
	/**
	 * Update the user's url.
	 * 
	 * @param url A String of the user's url.
	 * @param callback {@link SmorgasbordCallback}.
	 */
	public void updateUrl(String url, SmorgasbordCallback callback) {
		Bundle urlBundle = new Bundle(1);
		urlBundle.putString("url", url);
		updateProfile(urlBundle, callback);
	}
	
	/**
	 * Update the user's location.
	 * 
	 * @param location A String of the user's location. Must be 30 characters or less.
	 * @param callback {@link SmorgasbordCallback}.
	 */
	public void updateLocation(String location, SmorgasbordCallback callback) {
		Bundle locationBundle = new Bundle(1);
		locationBundle.putString("location", location);
		updateProfile(locationBundle, callback);
	}
		
	/**
	 * Update the user's description.
	 * 
	 * @param description A String of the user's description. Must be 160 characters or less.
	 * @param callback {@link SmorgasbordCallback}.
	 */
	public void updateDescription(String description, SmorgasbordCallback callback) {
		Bundle descriptionBundle = new Bundle(1);
		descriptionBundle.putString("description", description);
		updateProfile(descriptionBundle, callback);
	}
	
	/**
	 * Update the user's profile background image.
	 * 
	 * @param image A Bitmap of the desired background image.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_background_image">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfileBackgroundImage(Bitmap image, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Update the users's profile colors.  Use this method to update a bunch of profile colors at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_colors">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfileColors(Bundle params, SmorgasbordCallback callback) {
		
	}

	/**
	 * Update the user's profile background color.
	 * 
	 * @param backgroundColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfileBackgroundColor(String backgroundColor, SmorgasbordCallback callback) {
		Bundle bgBundle = new Bundle(1);
		bgBundle.putString("profile_background_color", backgroundColor);
		updateProfile(bgBundle, callback);
	}
	
	/**
	 * Update the user's profile link color.
	 * 
	 * @param linkColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfileLinkColor(String linkColor, SmorgasbordCallback callback) {
		Bundle linkBundle = new Bundle(1);
		linkBundle.putString("profile_link_color", linkColor);
		updateProfile(linkBundle, callback);
	}
	
	/**
	 * Update the user's profile sidebar border color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfileSidebarBorderColor(String borderColor, SmorgasbordCallback callback) {
		Bundle borderBundle = new Bundle(1);
		borderBundle.putString("profile_sidebar_border_color", borderColor);
		updateProfile(borderBundle, callback);
	}
	
	/**
	 * Update the user's profile sidebar fill color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfileSidebarFillColor(String fillColor, SmorgasbordCallback callback) {
		Bundle fillBundle = new Bundle(1);
		fillBundle.putString("profile_sidebar_fill_color", fillColor);
		updateProfile(fillBundle, callback);
	}
	
	/**
	 * Update the user's profile text color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfileTextColor(String textColor, SmorgasbordCallback callback) {
		Bundle textBundle = new Bundle(1);
		textBundle.putString("profile_text_color", textColor);
		updateProfile(textBundle, callback);
	}
	
	/**
	 * Update the user's profile image.
	 * 
	 * @param image A Bitmap of the desired image.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_image">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateProfileImage(Bitmap image, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// Block endpoints
	
	/**
	 * Get a list of users that this user has blocked.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/blocking">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getBlockedUsers(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get a list of users ids that this user has blocked.
	 * 
	 * @param stringifyIds A boolean that tells the API whether or not to stringify the Ids it returns.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void getBlockedUsersIds(Boolean stringifyIds, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Checks to see if the authenticated user blocks the target user. Returns the user if yes, else 404's.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void doesBlockExist(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Checks to see if the authenticated user blocks the supplied user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void doesBlockExist(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		doesBlockExist(params, callback);
	}

	/**
	 * Block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void block(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Block the specified user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void block(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		block(params, callback);
	}

	/**
	 * Unblock the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unblock(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Unblock the specified user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void unblock(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		unblock(params, callback);
	}

	// Direct Message endpoints
	
	/**
	 * Get the user's direct messages.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void getDirectMessages(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get user's direct messages that are newer than the supplied id.
	 * 
	 * @param sinceId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void getDirectMessagesSince(String sinceId, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params.putString("since_id", sinceId);
		getDirectMessages(params, callback);
	}
	
	/**
	 * Get user's direct messages that are older than the supplied id.
	 * 
	 * @param maxId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void getDirectMessagesBefore(String maxId, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params.putString("max_id", maxId);
		getDirectMessages(params, callback);
	}
		
	/**
	 * Get the user's sent direct messages.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void getSentDirectMessages(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get user's sent direct messages that are newer than the supplied id.
	 * 
	 * @param sinceId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void getSentDirectMessagesSince(String sinceId, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params.putString("since_id", sinceId);
		getSentDirectMessages(params, callback);
	}
	
	/**
	 * Get user's sent direct messages that are older than the supplied id.
	 * 
	 * @param maxId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void getSentDirectMessagesBefore(String maxId, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params.putString("max_id", maxId);
		getSentDirectMessages(params, callback);
	}
	
	/**
	 * Delete a direct message.
	 * 
	 * @param messageId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/destroy/%3Aid">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void destroyDirectMessage(String messageId, Bundle params, SmorgasbordCallback callback) {
		// HttpDelete
	}
	
	/**
	 * Send a new direct message.
	 * 
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void sendDirectMessage(String text, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Send a new direct message to a screen name.
	 * 
	 * @param user A {@link User}.
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void sendDirectMessage(User user, String text, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		sendDirectMessage(text, params, callback);
	}

	/**
	 * Get a single direct message.
	 * 
	 * @param messageId A String direct message id.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getDirectMessage(String messageId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	// Favorites endpoints
	
	/**
	 * Get the authenticated user's favorites.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFavorites(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get a specified user's favorites.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUserFavorites(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}

	/**
	 * Get a user's favorites by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @param callback A {@link Bundle}.
	 */
	public void getUserFavorites(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUserFavorites(params, callback);
	}
	
	/**
	 * Favorite a tweet.
	 * 
	 * @param tweetId A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/create/%3Aid">here</a>.
	 * @param callback A {@link SmorgasbordCallback callback}.
	 */
	public void favorite(String tweetId, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Unfavorite a tweet.
	 * 
	 * @param tweetId A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/destroy/%3Aid">here</a>.
	 * @param callback A {@link SmorgasbordCallback callback}.
	 */
	public void unfavorite(String tweetId, Bundle params, SmorgasbordCallback callback) {
		// HttpDelete
	}
	
	// Friend And Follower endpoints
	
	/**
	 * Get a list of a user's followers ids.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFollowersIds(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}

	/**
	 * Get a list of a user's follower ids by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFollowersIds(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getFollowersIds(params, callback);
	}

	/**
	 * Get a list of a user's friends ids.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFriendsIds(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}

	/**
	 * Get a list of a user's friend ids by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFriendsIds(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getFollowersIds(params, callback);
	}
	
	/**
	 * Check if a friendship exists between two users.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/exists">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void doesFriendshipExist(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Check if a friendship exists between two users.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/exists">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void doesFriendshipExist(User userA, User userB, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 2);
		params = userA.appendToBundle(params);
		params = userB.appendToBundle(params);
		doesFriendshipExist(params, callback);
	}
	
	/**
	 * Get a list of friend requests for the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/incoming">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getIncomingFriendRequests(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}

	/**
	 * Get a list of friend requests made by the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/outgoing">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getOutgoingFriendRequests(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get detailed information about a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/show">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void showFriendship(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Create a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void createFriendship(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Create a friendship by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void createFriendship(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		createFriendship(params, callback);
	}
	
	/**
	 * Destroy a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void destroyFriendship(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Destroy a friendship by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void destroyFriendship(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		destroyFriendship(params, callback);
	}
	
	/**
	 * Look up the relationship between the authenticated user and the list of user ids or screen names.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void lookupFriendship(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Look up the relationship between the authenticated user and the list of users.
	 * 
	 * @param users An {@link UserCollection}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void lookupFriendship(UserCollection users, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = users.appendToBundle(params);
		lookupFriendship(params, callback);
	}
	
	/**
	 * Update what notifications should be shown for a friend.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/update">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateFriendship(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// List endpoints
	
	/**
	 * Get lists of the authenticated user or the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/all">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSubscribedLists(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get lists of the user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/all">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSubscribedLists(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getSubscribedLists(params, callback);
	}
	
	/**
	 * Get statutes of the specified list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/statuses">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getListStatuses(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get statuses of the specified list by id.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/statuses">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getListStatuses(TwitterList list, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = list.appendToBundle(params);
		getListStatuses(params, callback);
	}

	/**
	 * Remove a member from a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void removeMemberFromList(Bundle params, SmorgasbordCallback callback) {
		// HttpDelete
	}

	/**
	 * Remove a member from a list by list.
	 * 
	 * @param list A {@TwitterList}.
	 * @param user A {@User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void removeMemberFromList(TwitterList list, User user, SmorgasbordCallback callback) {
		// TODO What's the smallest this Bundle can be and still fit everything?
		Bundle params = new Bundle();
		params = list.appendToBundle(params);
		params = user.appendToBundle(params);
		removeMemberFromList(params, callback);
	}
	
	/**
	 * Get the lists the user is a member of.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/memberships">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersListMemberships(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get the lists the user is a member of by id.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/memberships">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersListMemberships(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUsersListMemberships(params, callback);
	}
	
	/**
	 * Get a lists subscribers.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscriptions">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getListSubscribers(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get a lists subscribers.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscriptions">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getListSubscribers(TwitterList list, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = list.appendToBundle(params);
		getListSubscribers(params, callback);
	}

	/**
	 * Subscribe the authenticated user to a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void subscribeToList(Bundle params, SmorgasbordCallback callback) {
		
	}
	
	/**
	 * Subscribe the authenticated user to a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void subscribeToList(TwitterList list, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = list.appendToBundle(params);
		subscribeToList(params, callback);
	}

	/**
	 * Check if the specified user is a member of the list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscribers/show">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void isUserListSubscriber(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Unsubscribe the authenticated user from a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unsubscribeFromList(Bundle params, SmorgasbordCallback callback) {
		// HttpDelete
	}
	
	/**
	 * Unsubscribe the authenticated user from a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unsubscribeFromList(TwitterList list, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = list.appendToBundle(params);
		unsubscribeFromList(params, callback);
	}

	/**
	 * Add multiple users to a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/create_all">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addUsersToList(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Add multiple users to a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param users An {@link UserCollection}.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void addUsersToList(TwitterList list, UserCollection users, SmorgasbordCallback callback) {
		// TODO What's the smallest this Bundle can be?
		Bundle params = new Bundle();
		params = list.appendToBundle(params);
		params = users.appendToBundle(params);
		addUsersToList(params, callback);
	}
	
	/**
	 * Delete list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void deleteList(Bundle params, SmorgasbordCallback callback) {
		// HttpDelete
	}
		
	/**
	 * Delete list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void deleteList(TwitterList list, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = list.appendToBundle(params);
		deleteList(params, callback);
	}

	/**
	 * Update a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/update">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateList(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Update a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/update">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void updateList(TwitterList list, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 2);
		params = list.appendToBundle(params);
		updateList(params, callback);
	}
	
	/**
	 * Create a list.
	 * 
	 * @param name A String Twitter list name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void createList(String name, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Get lists owned by the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersLists(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get lists owned by the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUsersLists(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUsersLists(params, callback);
	}
	
	/**
	 * Get a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/show">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getList(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/show">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getList(TwitterList list, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = list.appendToBundle(params);
		getList(params, callback);
	}
		
	// Notification endpoints
	
	/**
	 * Enables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/notifications/follow">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void followNotifications(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Enables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param user A {@link User}.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void followNotifications(User user, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		followNotifications(params, callback);
	}
		
	/**
	 * Disables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/notifications/follow">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unfollowNotifications(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Disables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param user A {@link User}.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void unfollowNotifications(User user, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		unfollowNotifications(params, callback);
	}
	
	// Places & Geo endpoints
	
	/**
	 * Get all information about a place.
	 * 
	 * @param placeId A String id that can be retrieved from reverseGeocode.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getPlace(String placeId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Searches for up to 20 places to be used as a place_id.
	 * 
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/reverse_geocode">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void reverseGeocode(String lat, String lon, Bundle params, SmorgasbordCallback callback) {
		// TODO Need to remember lon should be sent as long
		// HttpGet
	}
	
	/**
	 * Search nearby places.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/search">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchNearby(Bundle params, SmorgasbordCallback callback) {
		// TODO Need to remember lon should be sent as long
		// TODO Do we need to create a Geo pojo? lat, long, ip, query
		// HttpGet
	}
	
	/**
	 * Locates places near the given coordinates which are similar in name.
	 * 
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param name A String of the name of the place.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/search">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void similarPlaces(String lat, String lon, String name, Bundle params, SmorgasbordCallback callback) {
		// TODO Need to remember lon should be sent as long
		// HttpGet
	}
	
	/**
	 * Creates a new place object at the given latitude and longitude.
	 * 
	 * @param name A String of the name of the place.
	 * @param containedWithin A String of the place_id that this place is within.
	 * @param token A String token found in the response from similarPlaces.
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/geo/place">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void createPlace(String name, String containedWithin, String token, String lat, String lon, Bundle params, SmorgasbordCallback callback) {
		// TODO Need to remember lon should be sent as long
		// HttpPost
	}
		
	// Saved Searches endpoints
	
	/**
	 * Returns the authenticated users saved search queries.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSavedSearches(SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Retrieve the information for the saved search represented by the given id.
	 * 
	 * @param id A String id of the saved search query.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void showSavedSearch(String id, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Create a new saved search.
	 * 
	 * @param query A String search query.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void createSavedSearch(String query, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Delete a saved search.
	 * 
	 * @param id A String id of the saved search query.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void deleteSavedSearch(String id, SmorgasbordCallback callback) {
		// HttpDelete
	}
	
	// Search endpoints
	
	/**
	 * Returns tweets that match a specified query.
	 * 
	 * @param q A String search query.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/search">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void search(String q, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}

	// Spam Reporting endpoints
	
	/**
	 * Report spam and block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/report_spam">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void reportSpam(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Report spam and block the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void reportSpam(User user, SmorgasbordCallback callback) {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		reportSpam(params, callback);
	}
	
	// Timeline endpoints
	
	/**
	 * Returns the most recent statuses posted by the authenticated user and the people they follow.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/home_timeline">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getTimeline(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Get the authenticated user's most recent mentions.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/mentions">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getMentions(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Returns the most recent public statuses.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/public_timeline">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getPublicStatuses(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns the most recent retweets by the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_by_me">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetedByMe(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns the most recent retweets by the people the authenticated user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_me">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetedToMe(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns the most recent retweets of the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweets_of_me">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetsOfMe(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns the most recent tweets of the authenticated user or the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/user_timeline">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUserStatuses(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Returns the most recent tweets of the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/user_timeline">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUserStatuses(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 0);
		params = user.appendToBundle(params);
		getUserStatuses(params, callback);
	}
	
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_user">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetedToUser(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_user">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetedToUser(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 0);
		params = user.appendToBundle(params);
		getRetweetedToUser(params, callback);
	}
		
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/get/statuses/retweeted_by_user">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetedByUser(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Returns the most recent retweets by the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/get/statuses/retweeted_by_user">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetedByUser(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 0);
		params = user.appendToBundle(params);
		getRetweetedByUser(params, callback);
	}
	
	// Trends & Local Trends endpoints
	
	/**
	 * Returns the top 10 trending topics for the given @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth Id</a>.
	 * 
	 * @param whereOnEarthId A String Yahoo where on earth id.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getLocalTrends(String whereOnEarthId, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns the locations that Twitter has trending topic information for.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/available">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getAvailableTrendLocations(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Returns the top 10 current trending topics on Twitter.
	 * 
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getTrends(SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns the top 10 current trending topics on Twitter.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getCurrentTrends(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns the top 20 trending topics for each hour in a given day.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getDailyTrends(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns the top 30 trending topics for each day in a given week.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getWeeklyTrends(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	// Tweet endpoints
	
	/**
	 * Show user objects of up to 100 members who retweeted the status.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/%3Aid/retweeted_by">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetedBy(String id, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Show user ids of up to 100 users who retweeted the status.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/%3Aid/retweeted_by/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweetedByIds(String id, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns up to 100 of the first retweets of a given tweet.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweets/%3Aid">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getRetweets(String id, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns a single status, specified by the id parameter below.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/show/%3Aid">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getTweet(String id, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Delete a tweet made by the authenticated user.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/destroy/%3Aid">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void deleteTweet(String id, Bundle params, SmorgasbordCallback callback) {
		// HttpDelete
	}
	
	/**
	 * Retweet.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/retweet/%3Aid">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void retweet(String id, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
		
	/**
	 * Tweet.
	 * 
	 * @param text A String status.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/retweet/%3Aid">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void tweet(String text, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	// User endpoints
	
	/**
	 * Return up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/lookup">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void lookupUsers(Bundle params, SmorgasbordCallback callback) {
		// TODO Make sure we can use both
		
	}
	
	/**
	 * Return up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two.
	 * 
	 * @param users {@link UserCollection}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/lookup">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void lookupUsers(UserCollection users, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 2);
		params = users.appendToBundle(params);
		lookupUsers(params, callback);
	}
	
	/**
	 * Access the profile image in various sizes for the user with the indicated screen_name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/profile_image/%3Ascreen_name">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getProfileImage(String screenName, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Search Twitter users with the given query.
	 * 
	 * @param q A String search query.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void searchUsers(String q, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Return the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUser(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Return the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getUser(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUser(params, callback);
	}
	
	/**
	 * Returns an array of users that the specified user can contribute to.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributees">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getContributees(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns an array of users that the specified user can contribute to.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributees">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getContributees(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getContributees(params, callback);
	}
	
	/**
	 * Returns an array of users who can contribute to the specified account.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributors">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getContributors(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns an array of users who can contribute to the specified account.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributors">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getContributors(User user, Bundle params, SmorgasbordCallback callback) {
		params = AbstractClient.initBundle(params, 1);
		params = user.appendToBundle(params);
		getContributors(params, callback);
	}
	
	/**
	 * Returns Twitter's suggested user list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSuggestedUsers(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
	/**
	 * Returns Twitter's suggested user list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions/%3Aslug">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSuggestedUsers(String slug, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Return the users in a given category of the Twitter suggested user list and return their most recent status.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions/%3Aslug/members">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getSuggestedUsersWithStatus(String slug, Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
	
}
