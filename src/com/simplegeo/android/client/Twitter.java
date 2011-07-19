package com.simplegeo.android.client;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.callback.SGCallback;
import com.simplegeo.android.http.SGHttpMethod;
import com.simplegeo.android.type.OAuthConfig;
import com.simplegeo.android.type.TwitterList;
import com.simplegeo.android.type.User;
import com.simplegeo.android.type.UserCollection;
import com.simplegeo.android.util.Util;

public class Twitter extends AbstractClient {

	private static final String twitterUrl = "https://api.twitter.com/1";

	public Twitter(String accessToken) {
		super(new OAuthConfig(accessToken, null, null, null));
	}
	
	public Twitter(String key, String secret) {
		super(new OAuthConfig(null, null, key, secret));
	}

	/**
	 * Verify the user's credentials.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/account/verify_credentials">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException
	 */
	public void verifyCredentials(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/account/verify_credentials.json", params, callback);
	}
	
	/**
	 * Retrieve the users rate limit status.
	 * 
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void rateLimitStatus(SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/account/rate_limit_status.json", null, callback);
	}
		
	/**
	 * Retrieve the users totals for friends, followers, updates and favorites.
	 * 
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void totals(SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/account/totals.json", null, callback);
	}
	
	/**
	 * Retrieve the users account settings.
	 * 
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getSettings(SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/account/settings.json", null, callback);
	}
		
	/**
	 * Sets the users account settings.  Use this to update a bunch of user settings at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/settings">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void setSettings(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/account/settings.json", params, callback);
	}
	
	/**
	 * Set the trend location.
	 * 
	 * @param trendLocation A String of a @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth ID</a> to use as the user's default trending location.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException
	 */
	public void setTrendLocation(String trendLocation, SGCallback callback) throws IOException {
		Bundle trendBundle = new Bundle(1);
		trendBundle.putString("trend_location_woeid", trendLocation);
		setSettings(trendBundle, callback);
	}
	
	/**
	 * Enable sleep time and set the start and end sleep time.
	 * 
	 * @param startSleepTime An int in the range, 0-23.
	 * @param endSleepTime An int in the range, 0-23.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void enableSleepTime(int startSleepTime, int endSleepTime, SGCallback callback) throws IOException {
		Bundle sleepBundle = new Bundle(3);
		sleepBundle.putBoolean("sleep_time_enabled", true);
		sleepBundle.putString("start_sleep_time", String.valueOf(startSleepTime));
		sleepBundle.putString("end_sleep_time", String.valueOf(endSleepTime));
		setSettings(sleepBundle, callback);
	}
	
	/**
	 * Disable sleep time.
	 * 
	 * @param callback A {@link SGCallback}.
	 * @throws IOException
	 */
	public void disableSleepTime(SGCallback callback) throws IOException {
		Bundle sleepBundle = new Bundle(1);
		sleepBundle.putBoolean("sleep_time_enabled", false);
		setSettings(sleepBundle, callback);
	}
	
	/**
	 * Set time zone.
	 * 
	 * @param timeZone A String of one of the @see <a href="http://api.rubyonrails.org/classes/ActiveSupport/TimeZone.html">Rails Time Zone's</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException
	 */
	public void setTimeZone(String timeZone, SGCallback callback) throws IOException {
		Bundle timeZoneBundle = new Bundle(1);
		timeZoneBundle.putString("time_zone", timeZone);
		setSettings(timeZoneBundle, callback);
	}
		
	/**
	 * Set language.
	 * 
	 * @param lang A String of one of the @see <a href="https://dev.twitter.com/docs/api/1/get/help/languages">Twitter Supported Languages.</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void setLanguage(String lang, SGCallback callback) throws IOException {
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
	 * @throws IOException 
	 */
	public void updateDeliveryDevice(String device, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("device", device);
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/account/update_delivery_device.json", params, callback);
	}
	
	/**
	 * Update the user's profile.  Use this method to update a bunch of profile settings at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException
	 */
	public void updateProfile(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/account/update_profile.json", params, callback);
	}
	
	/**
	 * Update the user's full name.
	 * 
	 * @param name A String of the user's full name. Must be 20 characters or less.
	 * @param callback {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateName(String name, SGCallback callback) throws IOException {
		Bundle nameBundle = new Bundle(1);
		nameBundle.putString("name", name);
		updateProfile(nameBundle, callback);
	}
		
	/**
	 * Update the user's url.
	 * 
	 * @param url A String of the user's url.
	 * @param callback {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateUrl(String url, SGCallback callback) throws IOException {
		Bundle urlBundle = new Bundle(1);
		urlBundle.putString("url", url);
		updateProfile(urlBundle, callback);
	}
	
	/**
	 * Update the user's location.
	 * 
	 * @param location A String of the user's location. Must be 30 characters or less.
	 * @param callback {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateLocation(String location, SGCallback callback) throws IOException {
		Bundle locationBundle = new Bundle(1);
		locationBundle.putString("location", location);
		updateProfile(locationBundle, callback);
	}
		
	/**
	 * Update the user's description.
	 * 
	 * @param description A String of the user's description. Must be 160 characters or less.
	 * @param callback {@link SGCallback}.
	 * @throws IOException
	 */
	public void updateDescription(String description, SGCallback callback) throws IOException {
		Bundle descriptionBundle = new Bundle(1);
		descriptionBundle.putString("description", description);
		updateProfile(descriptionBundle, callback);
	}
	
	/**
	 * Update the user's profile background image.
	 * 
	 * @param image A Bitmap of the desired background image.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_background_image">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateProfileBackgroundImage(Bitmap image, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putByteArray("image", Util.bitmapToByteArray(image));
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/account/update_profile_background_image.json", params, callback);
	}
	
	/**
	 * Update the users's profile colors.  Use this method to update a bunch of profile colors at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_colors">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateProfileColors(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/account/update_profile_colors.json", params, callback);
	}

	/**
	 * Update the user's profile background color.
	 * 
	 * @param backgroundColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateProfileBackgroundColor(String backgroundColor, SGCallback callback) throws IOException {
		Bundle bgBundle = new Bundle(1);
		bgBundle.putString("profile_background_color", backgroundColor);
		updateProfile(bgBundle, callback);
	}
	
	/**
	 * Update the user's profile link color.
	 * 
	 * @param linkColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateProfileLinkColor(String linkColor, SGCallback callback) throws IOException {
		Bundle linkBundle = new Bundle(1);
		linkBundle.putString("profile_link_color", linkColor);
		updateProfile(linkBundle, callback);
	}
	
	/**
	 * Update the user's profile sidebar border color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateProfileSidebarBorderColor(String borderColor, SGCallback callback) throws IOException {
		Bundle borderBundle = new Bundle(1);
		borderBundle.putString("profile_sidebar_border_color", borderColor);
		updateProfile(borderBundle, callback);
	}
	
	/**
	 * Update the user's profile sidebar fill color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateProfileSidebarFillColor(String fillColor, SGCallback callback) throws IOException {
		Bundle fillBundle = new Bundle(1);
		fillBundle.putString("profile_sidebar_fill_color", fillColor);
		updateProfile(fillBundle, callback);
	}
	
	/**
	 * Update the user's profile text color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateProfileTextColor(String textColor, SGCallback callback) throws IOException {
		Bundle textBundle = new Bundle(1);
		textBundle.putString("profile_text_color", textColor);
		updateProfile(textBundle, callback);
	}
	
	/**
	 * Update the user's profile image.
	 * 
	 * @param image A Bitmap of the desired image.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_image">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateProfileImage(Bitmap image, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putByteArray("image", Util.bitmapToByteArray(image));
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/account/update_profile_image.json", params, callback);
	}
	
	// Block endpoints
	
	/**
	 * Get a list of users that this user has blocked.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/blocking">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getBlockedUsers(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/blocks/blocking.json", params, callback);
	}
	
	/**
	 * Get a list of users ids that this user has blocked.
	 * 
	 * @param stringifyIds A boolean that tells the API whether or not to stringify the Ids it returns.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void getBlockedUsersIds(Boolean stringifyIds, SGCallback callback) throws IOException {
		Bundle params = new Bundle(1);
		params.putBoolean("stringifyIds", stringifyIds);
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/blocks/blocking/ids.json", params, callback);
	}
	
	/**
	 * Checks to see if the authenticated user blocks the target user. Returns the user if yes, else 404's.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void doesBlockExist(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/blocks/blocking/ids.json", params, callback);
	}
	
	/**
	 * Checks to see if the authenticated user blocks the supplied user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void doesBlockExist(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		doesBlockExist(params, callback);
	}

	/**
	 * Block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void block(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/blocks/create.json", params, callback);
	}
	
	/**
	 * Block the specified user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void block(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		block(params, callback);
	}

	/**
	 * Unblock the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void unblock(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/blocks/destroy.json", params, callback);
	}
	
	/**
	 * Unblock the specified user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void unblock(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		unblock(params, callback);
	}

	// Direct Message endpoints
	
	/**
	 * Get the user's direct messages.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void getDirectMessages(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/direct_messages.json", params, callback);
	}
	
	/**
	 * Get user's direct messages that are newer than the supplied id.
	 * 
	 * @param sinceId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void getDirectMessagesSince(String sinceId, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("since_id", sinceId);
		getDirectMessages(params, callback);
	}
	
	/**
	 * Get user's direct messages that are older than the supplied id.
	 * 
	 * @param maxId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void getDirectMessagesBefore(String maxId, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("max_id", maxId);
		getDirectMessages(params, callback);
	}
		
	/**
	 * Get the user's sent direct messages.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void getSentDirectMessages(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/direct_messages/sent.json", params, callback);
	}
	
	/**
	 * Get user's sent direct messages that are newer than the supplied id.
	 * 
	 * @param sinceId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void getSentDirectMessagesSince(String sinceId, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("since_id", sinceId);
		getSentDirectMessages(params, callback);
	}
	
	/**
	 * Get user's sent direct messages that are older than the supplied id.
	 * 
	 * @param maxId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param callback A {@SmorgasbordCallback}.
	 * @throws IOException 
	 */
	public void getSentDirectMessagesBefore(String maxId, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("max_id", maxId);
		getSentDirectMessages(params, callback);
	}
	
	/**
	 * Delete a direct message.
	 * 
	 * @param messageId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/destroy/%3Aid">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void destroyDirectMessage(String messageId, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.DELETE, twitterUrl + String.format(Locale.US, "/direct_messages/destroy/%s.json", URLEncoder.encode(messageId)), params, callback);
	}
	
	/**
	 * Send a new direct message.
	 * 
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void sendDirectMessage(String text, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("text", text);
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/direct_messages/new.json", params, callback);
	}
	
	/**
	 * Send a new direct message to a screen name.
	 * 
	 * @param user A {@link User}.
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void sendDirectMessage(User user, String text, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		sendDirectMessage(text, params, callback);
	}

	/**
	 * Get a single direct message.
	 * 
	 * @param messageId A String direct message id.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getDirectMessage(String messageId, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + String.format(Locale.US, "/direct_messages/%s.json", URLEncoder.encode(messageId)), null, callback);
	}
	
	// Favorites endpoints
	
	/**
	 * Get the authenticated user's favorites.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getFavorites(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/favorites.json", params, callback);
	}
	
	/**
	 * Get a user's favorites by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @param callback A {@link Bundle}.
	 * @throws IOException 
	 */
	public void getUserFavorites(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getFavorites(params, callback);
	}
	
	/**
	 * Favorite a tweet.
	 * 
	 * @param tweetId A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/create/%3Aid">here</a>.
	 * @param callback A {@link SGCallback callback}.
	 * @throws IOException 
	 */
	public void favorite(String tweetId, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + String.format(Locale.US, "/favorites/create/%s.json", URLEncoder.encode(tweetId)), params, callback);
	}
	
	/**
	 * Unfavorite a tweet.
	 * 
	 * @param tweetId A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/destroy/%3Aid">here</a>.
	 * @param callback A {@link SGCallback callback}.
	 * @throws IOException 
	 */
	public void unfavorite(String tweetId, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.DELETE, twitterUrl + String.format(Locale.US, "/favorites/destroy/%s.json", URLEncoder.encode(tweetId)), params, callback);
	}
	
	// Friend And Follower endpoints
	
	/**
	 * Get a list of a user's followers ids.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getFollowersIds(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/followers/ids.json", params, callback);
	}

	/**
	 * Get a list of a user's follower ids by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getFollowersIds(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getFollowersIds(params, callback);
	}

	/**
	 * Get a list of a user's friends ids.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getFriendsIds(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/friends/ids.json", params, callback);
	}

	/**
	 * Get a list of a user's friend ids by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getFriendsIds(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getFollowersIds(params, callback);
	}
	
	/**
	 * Check if a friendship exists between two users.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/exists">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void doesFriendshipExist(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/friendships/exists.json", params, callback);
	}
		
	/**
	 * Check if a friendship exists between two users.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/exists">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void doesFriendshipExist(User userA, User userB, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 2);
		params = userA.appendToBundle(params);
		params = userB.appendToBundle(params);
		doesFriendshipExist(params, callback);
	}
	
	/**
	 * Get a list of friend requests for the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/incoming">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getIncomingFriendRequests(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/friendships/incoming.json", params, callback);
	}

	/**
	 * Get a list of friend requests made by the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/outgoing">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getOutgoingFriendRequests(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/friendships/outgoing.json", params, callback);
	}
	
	/**
	 * Get detailed information about a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/show">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void showFriendship(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/friendships/show.json", params, callback);
	}
	
	/**
	 * Create a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void createFriendship(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/friendships/create.json", params, callback);
	}
	
	/**
	 * Create a friendship by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void createFriendship(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		createFriendship(params, callback);
	}
	
	/**
	 * Destroy a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/destroy">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void destroyFriendship(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/friendships/destroy.json", params, callback);
	}
	
	/**
	 * Destroy a friendship by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/destroy">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void destroyFriendship(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		destroyFriendship(params, callback);
	}
	
	/**
	 * Look up the relationship between the authenticated user and the list of user ids or screen names.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void lookupFriendship(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/friendships/lookup.json", params, callback);
	}
	
	/**
	 * Look up the relationship between the authenticated user and the list of users.
	 * 
	 * @param users An {@link UserCollection}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void lookupFriendship(UserCollection users, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = users.appendToBundle(params);
		lookupFriendship(params, callback);
	}
	
	/**
	 * Update what notifications should be shown for a friend.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/update">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateFriendship(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/friendships/update.json", params, callback);
	}
	
	/**
	 * Returns an array of user_ids that the currently authenticated user does not want to see retweets from..
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/get-friendshipsno_retweet_ids">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getNoRetweetIds(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/friendships/no_retweet_ids.json", params, callback);
	}
	
	// List endpoints
	
	/**
	 * Get lists of the authenticated user or the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/all">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getSubscribedLists(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/lists/all.json", params, callback);
	}
	
	/**
	 * Get lists of the user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/all">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getSubscribedLists(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getSubscribedLists(params, callback);
	}
	
	/**
	 * Get statutes of the specified list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/statuses">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getListStatuses(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/lists/statuses.json", params, callback);
	}
	
	/**
	 * Get statuses of the specified list by id.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/statuses">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getListStatuses(TwitterList list, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		getListStatuses(params, callback);
	}

	/**
	 * Remove a member from a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/destroy">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void removeMemberFromList(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.DELETE, twitterUrl + "/lists/members/destroy.json", params, callback);
	}

	/**
	 * Remove a member from a list by list.
	 * 
	 * @param list A {@TwitterList}.
	 * @param user A {@User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/destroy">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void removeMemberFromList(TwitterList list, User user, SGCallback callback) throws IOException {
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
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getUsersListMemberships(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/lists/memberships.json", params, callback);
	}
	
	/**
	 * Get the lists the user is a member of by id.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/memberships">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getUsersListMemberships(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUsersListMemberships(params, callback);
	}
	
	/**
	 * Get a lists subscribers.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscriptions">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getListSubscribers(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/lists/subscribers.json", params, callback);
	}
	
	/**
	 * Get a lists subscribers.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscriptions">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getListSubscribers(TwitterList list, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		getListSubscribers(params, callback);
	}

	/**
	 * Subscribe the authenticated user to a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void subscribeToList(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/lists/subscribers/create.json", params, callback);
	}
	
	/**
	 * Subscribe the authenticated user to a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void subscribeToList(TwitterList list, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		subscribeToList(params, callback);
	}

	/**
	 * Check if the specified user is a member of the list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscribers/show">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void isUserListSubscriber(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/lists/subscribers/show.json", params, callback);
	}
	
	/**
	 * Unsubscribe the authenticated user from a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void unsubscribeFromList(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.DELETE, twitterUrl + "/lists/subscribers/destroy.json", params, callback);
	}
	
	/**
	 * Unsubscribe the authenticated user from a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void unsubscribeFromList(TwitterList list, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		unsubscribeFromList(params, callback);
	}

	/**
	 * Add multiple users to a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/create_all">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void addUsersToList(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/lists/members/create_all.json", params, callback);
	}
	
	/**
	 * Add multiple users to a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param users An {@link UserCollection}.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void addUsersToList(TwitterList list, UserCollection users, SGCallback callback) throws IOException {
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
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void deleteList(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.DELETE, twitterUrl + "/lists/destroy.json", params, callback);
	}
		
	/**
	 * Delete list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/destroy">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void deleteList(TwitterList list, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		deleteList(params, callback);
	}

	/**
	 * Update a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/update">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateList(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/lists/update.json", params, callback);
	}
	
	/**
	 * Update a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/update">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void updateList(TwitterList list, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 2);
		params = list.appendToBundle(params);
		updateList(params, callback);
	}
	
	/**
	 * Create a list.
	 * 
	 * @param name A String Twitter list name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/create">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void createList(String name, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/lists/create.json", params, callback);
	}
	
	/**
	 * Get lists owned by the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getUsersLists(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/lists.json", params, callback);
	}
	
	/**
	 * Get lists owned by the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getUsersLists(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUsersLists(params, callback);
	}
	
	/**
	 * Get a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/show">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getList(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, twitterUrl + "/lists/show.json", params, callback);
	}
	
	/**
	 * Get a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/show">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getList(TwitterList list, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		getList(params, callback);
	}
		
	// Notification endpoints
	
	/**
	 * Enables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/notifications/follow">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void followNotifications(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/notifications/follow.json", params, callback);
	}
	
	/**
	 * Enables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param user A {@link User}.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void followNotifications(User user, SGCallback callback) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		followNotifications(params, callback);
	}
		
	/**
	 * Disables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/notifications/follow">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void unfollowNotifications(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, twitterUrl + "/notifications/leave.json", params, callback);
	}
	
	/**
	 * Disables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param user A {@link User}.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void unfollowNotifications(User user, SGCallback callback) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		unfollowNotifications(params, callback);
	}
	
	// Places & Geo endpoints
	
	/**
	 * Get all information about a place.
	 * 
	 * @param placeId A String id that can be retrieved from reverseGeocode.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getPlace(String placeId, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, twitterUrl + "/geo/id/%s.json", URLEncoder.encode(placeId)), null, callback);
	}
	
	/**
	 * Searches for up to 20 places to be used as a place_id.
	 * 
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/reverse_geocode">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void reverseGeocode(String lat, String lon, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("lat", lat);
		params.putString("long", lon);
		this.executeRequest(SGHttpMethod.GET, "/geo/reverse_geocode.json", params, callback);
	}
	
	/**
	 * Search nearby places.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/search">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void searchNearby(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/geo/nearby_places.json", params, callback);
	}
	
	/**
	 * Locates places near the given coordinates which are similar in name.
	 * 
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param name A String of the name of the place.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/search">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void similarPlaces(String lat, String lon, String name, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 3);
		params.putString("lat", lat);
		params.putString("long", lon);
		params.putString("name", name);
		this.executeRequest(SGHttpMethod.GET, "/geo/similar_places.json", params, callback);
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
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void createPlace(String name, String containedWithin, String token, String lat, String lon, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 5);
		params.putString("lat", lat);
		params.putString("long", lon);
		params.putString("name", name);
		params.putString("token", token);
		params.putString("containedWithin", containedWithin);
		this.executeRequest(SGHttpMethod.POST, "/geo/place.json", params, callback);
	}
		
	// Saved Searches endpoints
	
	/**
	 * Returns the authenticated users saved search queries.
	 * 
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getSavedSearches(SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/saved_searches.json", null, callback);
	}
	
	/**
	 * Retrieve the information for the saved search represented by the given id.
	 * 
	 * @param id A String id of the saved search query.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void showSavedSearch(String id, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/saved_searches/show/%s.json", URLEncoder.encode(id)), null, callback);
	}
	
	/**
	 * Create a new saved search.
	 * 
	 * @param query A String search query.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void createSavedSearch(String query, SGCallback callback) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("query", query);
		this.executeRequest(SGHttpMethod.POST, "/saved_searches/create.json", params, callback);
	}
		
	/**
	 * Delete a saved search.
	 * 
	 * @param id A String id of the saved search query.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void deleteSavedSearch(String id, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.DELETE, String.format(Locale.US, "/saved_searches/destroy/%s.json", URLEncoder.encode(id)), null, callback);
	}
	
	// Search endpoints
	
	/**
	 * Returns tweets that match a specified query.
	 * 
	 * @param q A String search query.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/search">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void search(String q, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("q", q);
		this.executeRequest(SGHttpMethod.GET, "/search.json", params, callback);
	}

	// Spam Reporting endpoints
	
	/**
	 * Report spam and block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/report_spam">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void reportSpam(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, "/report_spam.json", params, callback);
	}
	
	/**
	 * Report spam and block the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void reportSpam(User user, SGCallback callback) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		reportSpam(params, callback);
	}
	
	// Timeline endpoints
	
	/**
	 * Returns the most recent statuses posted by the authenticated user and the people they follow.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/home_timeline">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getTimeline(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/home_timeline.json", params, callback);
	}
	
	/**
	 * Get the authenticated user's most recent mentions.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/mentions">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getMentions(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/mentions.json", params, callback);
	}
		
	/**
	 * Returns the most recent public statuses.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/public_timeline">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getPublicStatuses(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/public_timeline.json", params, callback);
	}
	
	/**
	 * Returns the most recent retweets by the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_by_me">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetedByMe(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/retweeted_by_me.json", params, callback);
	}
	
	/**
	 * Returns the most recent retweets by the people the authenticated user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_me">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetedToMe(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/retweeted_to_me.json", params, callback);
	}
	
	/**
	 * Returns the most recent retweets of the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweets_of_me">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetsOfMe(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/retweets_of_me.json", params, callback);
	}
	
	/**
	 * Returns the most recent tweets of the authenticated user or the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/user_timeline">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getUserStatuses(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/user_timeline.json", params, callback);
	}
		
	/**
	 * Returns the most recent tweets of the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/user_timeline">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getUserStatuses(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		getUserStatuses(params, callback);
	}
	
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_user">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetedToUser(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/retweeted_to_user.json", params, callback);
	}
		
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_user">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetedToUser(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		getRetweetedToUser(params, callback);
	}
		
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/get/statuses/retweeted_by_user">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetedByUser(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/statuses/retweeted_by_user.json", params, callback);
	}
		
	/**
	 * Returns the most recent retweets by the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/get/statuses/retweeted_by_user">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetedByUser(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		getRetweetedByUser(params, callback);
	}
	
	// Trends & Local Trends endpoints
	
	/**
	 * Returns the top 10 trending topics for the given @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth Id</a>.
	 * 
	 * @param whereOnEarthId A String Yahoo where on earth id.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getLocalTrends(String whereOnEarthId, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/trends/%s.json", URLEncoder.encode(whereOnEarthId)), null, callback);
	}
	
	/**
	 * Returns the locations that Twitter has trending topic information for.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/available">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getAvailableTrendLocations(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/trends/available.json", params, callback);
	}
		
	/**
	 * Returns the top 10 current trending topics on Twitter.
	 * 
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getTrends(SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/trends.json", null, callback);
	}
	
	/**
	 * Returns the top 10 current trending topics on Twitter.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getCurrentTrends(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/trends/current.json", params, callback);
	}
	
	/**
	 * Returns the top 20 trending topics for each hour in a given day.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getDailyTrends(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/trends/daily.json", params, callback);
	}
	
	/**
	 * Returns the top 30 trending topics for each day in a given week.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getWeeklyTrends(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/trends/weekly.json", params, callback);
	}
	
	// Tweet endpoints
	
	/**
	 * Show user objects of up to 100 members who retweeted the status.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/%3Aid/retweeted_by">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetedBy(String id, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/statuses/%s/retweeted_by.json", URLEncoder.encode(id)), params, callback);
	}
	
	/**
	 * Show user ids of up to 100 users who retweeted the status.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/%3Aid/retweeted_by/ids">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweetedByIds(String id, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/statuses/%s/retweeted_by/ids.json", URLEncoder.encode(id)), params, callback);
	}
	
	/**
	 * Returns up to 100 of the first retweets of a given tweet.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweets/%3Aid">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getRetweets(String id, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/statuses/retweets/%s.json", URLEncoder.encode(id)), params, callback);
	}
	
	/**
	 * Returns a single status, specified by the id parameter below.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/show/%3Aid">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getTweet(String id, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/statuses/show/%s.json", URLEncoder.encode(id)), params, callback);
	}
	
	/**
	 * Delete a tweet made by the authenticated user.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/destroy/%3Aid">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void deleteTweet(String id, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.DELETE, String.format(Locale.US, "/statuses/destroy/%s.json", URLEncoder.encode(id)), params, callback);
	}
	
	/**
	 * Retweet.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/retweet/%3Aid">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void retweet(String id, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.POST, String.format(Locale.US, "/statuses/retweet/%s.json", URLEncoder.encode(id)), params, callback);
	}
		
	/**
	 * Tweet.
	 * 
	 * @param text A String status.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/retweet/%3Aid">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void tweet(String text, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("text", text);
		this.executeRequest(SGHttpMethod.POST, "/statuses/update.json", params, callback);
	}
	
	// User endpoints
	
	/**
	 * Return up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/lookup">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void lookupUsers(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/users/lookup.json", params, callback);
	}
	
	/**
	 * Return up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two.
	 * 
	 * @param users {@link UserCollection}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/lookup">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void lookupUsers(UserCollection users, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 2);
		params = users.appendToBundle(params);
		lookupUsers(params, callback);
	}
	
	/**
	 * Access the profile image in various sizes for the user with the indicated screen_name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/profile_image/%3Ascreen_name">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getProfileImage(String screenName, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/users/profile_image/%s.json", URLEncoder.encode(screenName)), params, callback);
	}
	
	/**
	 * Search Twitter users with the given query.
	 * 
	 * @param q A String search query.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void searchUsers(String q, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("q", q);
		this.executeRequest(SGHttpMethod.GET, "/users/search.json", params, callback);
	}
		
	/**
	 * Return the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getUser(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/users/show.json", params, callback);
	}
	
	/**
	 * Return the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getUser(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUser(params, callback);
	}
	
	/**
	 * Returns an array of users that the specified user can contribute to.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributees">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getContributees(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/users/contributees.json", params, callback);
	}
	
	/**
	 * Returns an array of users that the specified user can contribute to.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributees">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getContributees(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getContributees(params, callback);
	}
	
	/**
	 * Returns an array of users who can contribute to the specified account.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributors">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getContributors(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/users/contributors.json", params, callback);
	}
	
	/**
	 * Returns an array of users who can contribute to the specified account.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributors">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getContributors(User user, Bundle params, SGCallback callback) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getContributors(params, callback);
	}
	
	/**
	 * Returns Twitter's suggested user list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getSuggestedUsers(Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, "/users/suggestions.json", params, callback);
	}
	
	/**
	 * Returns Twitter's suggested user list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions/%3Aslug">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getSuggestedUsers(String slug, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/users/suggestions/%s.json", URLEncoder.encode(slug)), params, callback);
	}
		
	/**
	 * Return the users in a given category of the Twitter suggested user list and return their most recent status.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions/%3Aslug/members">here</a>.
	 * @param callback A {@link SGCallback}.
	 * @throws IOException 
	 */
	public void getSuggestedUsersWithStatus(String slug, Bundle params, SGCallback callback) throws IOException {
		this.executeRequest(SGHttpMethod.GET, String.format(Locale.US, "/users/suggestions/%s/members.json", URLEncoder.encode(slug)), params, callback);
	}
	
}
