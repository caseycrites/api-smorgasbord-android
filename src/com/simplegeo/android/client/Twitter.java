package com.simplegeo.android.client;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.callback.SmorgasbordCallback;

public class Twitter extends AbstractClient {

	private static final String HTTP_URL = "http://api.twitter.com/1/";
	private static String responseFormat = "json";
	public Bundle apiEndpoints;
	
	public Twitter(String format) {
		apiEndpoints.putString("verifyCredentials", "account/verify_credentials."+responseFormat);
		apiEndpoints.putString("rateLimitStatus", "account/rate_limit_status."+responseFormat);
		apiEndpoints.putString("totals", "account/totals."+responseFormat);
		apiEndpoints.putString("settings", "account/settings."+responseFormat);
		apiEndpoints.putString("updateDeliveryDevice", "account/update_delivery_device."+responseFormat);
		apiEndpoints.putString("updateProfile", "account/update_profile."+responseFormat);
		apiEndpoints.putString("updateProfileBackgroundImage", "account/update_profile_background_image."+responseFormat);
		apiEndpoints.putString("updateProfileColors", "account/update_profile_colors."+responseFormat);
		apiEndpoints.putString("updateProfileImage", "account/update_profile_image."+responseFormat);
		apiEndpoints.putString("getBlockedUsers", "blocks/blocking."+responseFormat);
		apiEndpoints.putString("getBlockedUsersIds", "blocks/blocking/ids."+responseFormat);
		apiEndpoints.putString("doesBlockExist", "blocks/exists."+responseFormat);
		apiEndpoints.putString("createBlock", "blocks/create."+responseFormat);
		apiEndpoints.putString("destroyBlock", "blocks/destroy."+responseFormat);
		apiEndpoints.putString("getDirectMessages", "direct_messages."+responseFormat);
		apiEndpoints.putString("getSentDirectMessages", "direct_messages/sent."+responseFormat);
		apiEndpoints.putString("destroyDirectMessage", "direct_messages/delete/%s."+responseFormat);
		apiEndpoints.putString("sendDirectMessage", "direct_messages/new."+responseFormat);
		apiEndpoints.putString("getDirectMessage", "direct_messages/%s."+responseFormat);
		apiEndpoints.putString("getFavorites", "favorites."+responseFormat);
		apiEndpoints.putString("getUserFavorites", "favorites/%s."+responseFormat);
		apiEndpoints.putString("favorite", "favorites/create/%s."+responseFormat);
		apiEndpoints.putString("unfavorite", "favorites/destroy/%s."+responseFormat);
	}
			
	// Account endpoints
	
	/**
	 * Verify a users supplied credentials.
	 * 
	 * @param params A {@link Bundle} containing optional keys include_entities, skip_status.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
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
	 * @param trendLocation A String of A @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth ID</a> to use as the user's default trending location.
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
	 * Checks to see if the authenticated user blocks a user with the supplied screen name.  Returns the user if yes, else 404's.
	 * 
	 * @param username A String of the desired screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void doesBlockExistByScreenName(String screenName, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		doesBlockExist(params, callback);
	}
		
	/**
	 * Checks to see if the authenticated user blocks a user with the supplied user id.  Returns the user if yes, else 404's.
	 * 
	 * @param userId A String of the desired user id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void doesBlockExistByUserId(String userId, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
		doesBlockExist(params, callback);
	}
	
	/**
	 * Block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void createBlock(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Block the specified user by screen name.
	 * 
	 * @param username A String of the desired screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void createBlockByScreenName(String screenName, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		doesBlockExist(params, callback);
	}
		
	/**
	 * Block the specified user by user id.
	 * 
	 * @param userId A String of the desired user id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void createBlockByUserId(String userId, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
		doesBlockExist(params, callback);
	}
	
	/**
	 * Unblock the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void destroyBlock(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Unblock the specified user by screen name.
	 * 
	 * @param username A String of the desired screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void destroyBlockByScreenName(String screenName, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		doesBlockExist(params, callback);
	}
		
	/**
	 * Unblock the specified user by user id.
	 * 
	 * @param userId A String of the desired user id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 */
	public void destroyBlockByUserId(String userId, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
		doesBlockExist(params, callback);
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
	 * @param screenName A String Twitter screen name.
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void sendDirectMessageByScreenName(String screenName, String text, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		sendDirectMessage(text, params, callback);
	}
	
	/**
	 * Send a new direct message to a user id.
	 * 
	 * @param screenName A String Twitter user id.
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void sendDirectMessageByUserId(String userId, String text, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
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
	 * Get a user's favorites by screen name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @param callback A {@link Bundle}.
	 */
	public void getUserFavoritesByScreenName(String screenName, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		getUserFavorites(params, callback);
	}
		
	/**
	 * Get a user's favorites by user id.
	 * 
	 * @param userId A String Twitter user id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @param callback A {@link Bundle}.
	 */
	public void getUserFavoritesByUserId(String userId, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
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
	 * Get a list of a user's follower ids by screen name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFollowersIdsByScreenName(String screenName, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		getFollowersIds(params, callback);
	}
	
	/**
	 * Get a list of a user's follower ids by user id.
	 * 
	 * @param userId A String Twitter user id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFollowersIdsByUserId(String userId, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
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
	 * Get a list of a user's friend ids by screen name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFriendsIdsByScreenName(String screenName, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		getFollowersIds(params, callback);
	}
	
	/**
	 * Get a list of a user's friend ids by user id.
	 * 
	 * @param userId A String Twitter user id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getFriendsIdsByUserId(String userId, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
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
	 * Create a friendship by screen name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void createFriendshipByScreenName(String screenName, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		createFriendship(params, callback);
	}

	/**
	 * Create a friendship by user id.
	 * 
	 * @param userId A String Twitter user id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void createFriendshipByUserId(String userId, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
		createFriendship(params, callback);
	}
	
	/**
	 * Destroy a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void destroyFriendship(Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Destroy a friendship by screen name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void destroyFriendshipByScreenName(String screenName, Bundle params, SmorgasbordCallback callback) {
		params.putString("screen_name", screenName);
		destroyFriendship(params, callback);
	}

	/**
	 * Destroy a friendship by user id.
	 * 
	 * @param userId A String Twitter user id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void destroyFriendshipByUserId(String userId, Bundle params, SmorgasbordCallback callback) {
		params.putString("user_id", userId);
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
	 * Look up the relationship between the authenticated user and the list of screen names.
	 * 
	 * @param screenNames An ArrayList<String> of Twitter screen names.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void lookupFriendshipByScreenNames(ArrayList<String> screenNames, Bundle params, SmorgasbordCallback callback) {
		params.putStringArrayList("screen_name", screenNames);
		lookupFriendship(params, callback);
	}

	/**
	 * Look up the relationship between the authenticated user and the list of user ids.
	 * 
	 * @param userIds An ArrayList<String> of Twitter user ids.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void lookupFriendshipByUserIds(ArrayList<String> userIds, Bundle params, SmorgasbordCallback callback) {
		params.putStringArrayList("user_id", userIds);
		lookupFriendship(params, callback);
	}
	
	/**
	 * Update what notifications should be shown for a friend.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/update">here</a>.
	 * @param callback
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
	public void getLists(Bundle params, SmorgasbordCallback callback) {
		// HttpGet
	}
		
	/**
	 * Get lists of the user by screen name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getListsByScreenName(String screenName, SmorgasbordCallback callback) {
		Bundle screenNameBundle = new Bundle(1);
		screenNameBundle.putString("screen_name", screenName);
		getLists(screenNameBundle, callback);
	}

	/**
	 * Get lists of the user by user id.
	 * 
	 * @param userId A String Twitter user id.
	 * @param callback A {@link SmorgasbordCallback}.
	 */
	public void getListsByUserId(String userId, SmorgasbordCallback callback) {
		Bundle userIdBundle = new Bundle(1);
		userIdBundle.putString("user_id", userId);
		lookupFriendship(userIdBundle, callback);
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
	
	// Timeline endpoints
	
	// Tweet endpoints
	
	// User endpoints
	
	// Trends endpoints
	
	// Local Trends endpoints
	
	// List Member endpoints
	
	// List Subscriber endpoints
	
	// Notification endpoints
	
	// Spam Reporting endpoints
	
	// Saved Searches endpoints
	
	// OAuth endpoints
	
	// Geo endpoints

	// Search endpoints

}
