package com.simplegeo.android.client;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

import org.scribe.builder.api.TwitterApi;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.type.OAuthCredentials;
import com.simplegeo.android.type.TwitterList;
import com.simplegeo.android.type.User;
import com.simplegeo.android.type.UserCollection;
import com.simplegeo.android.util.Util;

public class Twitter extends AbstractClient {
	public static final String TAG = "Twitter";
	
	private static final String twitterUrl = "http://api.twitter.com/1";

	public Twitter(OAuthCredentials credentials, String redirectUrl) {
		super(credentials, TwitterApi.class, redirectUrl);
	}
	
	/**
	 * Verify the user's credentials.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/account/verify_credentials">here</a>.
	 * @return {@link Response}
	 * @throws IOException
	 */
	public Response verifyCredentials(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/account/verify_credentials.json", params, null);
	}
	
	/**
	 * Retrieve the users rate limit status.
	 * 
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response rateLimitStatus() throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/account/rate_limit_status.json", null, null);
	}
		
	/**
	 * Retrieve the users totals for friends, followers, updates and favorites.
	 * 
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response totals() throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/account/totals.json", null, null);
	}
	
	/**
	 * Retrieve the users account settings.
	 * 
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSettings() throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/account/settings.json", null, null);
	}
		
	/**
	 * Sets the users account settings.  Use return this to update a bunch of user settings at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/settings">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response setSettings(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/account/settings.json", params, null);
	}
	
	/**
	 * Set the trend location.
	 * 
	 * @param trendLocation A String of a @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth ID</a> to use as the user's default trending location.
	 * @return {@link Response}
	 * @throws IOException
	 */
	public Response setTrendLocation(String trendLocation) throws IOException {
		Bundle trendBundle = new Bundle(1);
		trendBundle.putString("trend_location_woeid", trendLocation);
		return setSettings(trendBundle);
	}
	
	/**
	 * Enable sleep time and set the start and end sleep time.
	 * 
	 * @param startSleepTime An int in the range, 0-23.
	 * @param endSleepTime An int in the range, 0-23.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response enableSleepTime(int startSleepTime, int endSleepTime) throws IOException {
		Bundle sleepBundle = new Bundle(3);
		sleepBundle.putBoolean("sleep_time_enabled", true);
		sleepBundle.putString("start_sleep_time", String.valueOf(startSleepTime));
		sleepBundle.putString("end_sleep_time", String.valueOf(endSleepTime));
		return setSettings(sleepBundle);
	}
	
	/**
	 * Disable sleep time.
	 * 
	 * @return {@link Response}
	 * @throws IOException
	 */
	public Response disableSleepTime() throws IOException {
		Bundle sleepBundle = new Bundle(1);
		sleepBundle.putBoolean("sleep_time_enabled", false);
		return setSettings(sleepBundle);
	}
	
	/**
	 * Set time zone.
	 * 
	 * @param timeZone A String of one of the @see <a href="http://api.rubyonrails.org/classes/ActiveSupport/TimeZone.html">Rails Time Zone's</a>.
	 * @return {@link Response}
	 * @throws IOException
	 */
	public Response setTimeZone(String timeZone) throws IOException {
		Bundle timeZoneBundle = new Bundle(1);
		timeZoneBundle.putString("time_zone", timeZone);
		return setSettings(timeZoneBundle);
	}
		
	/**
	 * Set language.
	 * 
	 * @param lang A String of one of the @see <a href="https://dev.twitter.com/docs/api/1/get/help/languages">Twitter Supported Languages.</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response setLanguage(String lang) throws IOException {
		Bundle langBundle = new Bundle(1);
		langBundle.putString("lang", lang);
		return setSettings(langBundle);
	}
	
	/**
	 * Update whether a user receives SMS alerts or not.
	 * 
	 * @param device A String of either sms or none.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_delivery_device">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateDeliveryDevice(String device, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("device", device);
		return this.executeRequest(Verb.POST, twitterUrl + "/account/update_delivery_device.json", params, null);
	}
	
	/**
	 * Update the user's profile.  Use return this method to update a bunch of profile settings at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile">here</a>.
	 * @return {@link Response}
	 * @throws IOException
	 */
	public Response updateProfile(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/account/update_profile.json", params, null);
	}
	
	/**
	 * Update the user's full name.
	 * 
	 * @param name A String of the user's full name. Must be 20 characters or less.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateName(String name) throws IOException {
		Bundle nameBundle = new Bundle(1);
		nameBundle.putString("name", name);
		return updateProfile(nameBundle);
	}
		
	/**
	 * Update the user's url.
	 * 
	 * @param url A String of the user's url.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateUrl(String url) throws IOException {
		Bundle urlBundle = new Bundle(1);
		urlBundle.putString("url", url);
		return updateProfile(urlBundle);
	}
	
	/**
	 * Update the user's location.
	 * 
	 * @param location A String of the user's location. Must be 30 characters or less.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateLocation(String location) throws IOException {
		Bundle locationBundle = new Bundle(1);
		locationBundle.putString("location", location);
		return updateProfile(locationBundle);
	}
		
	/**
	 * Update the user's description.
	 * 
	 * @param description A String of the user's description. Must be 160 characters or less.
	 * @return {@link Response}
	 * @throws IOException
	 */
	public Response updateDescription(String description) throws IOException {
		Bundle descriptionBundle = new Bundle(1);
		descriptionBundle.putString("description", description);
		return updateProfile(descriptionBundle);
	}
	
	/**
	 * Update the user's profile background image.
	 * 
	 * @param image A Bitmap of the desired background image.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_background_image">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateProfileBackgroundImage(Bitmap image, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putByteArray("image", Util.bitmapToByteArray(image));
		return this.executeRequest(Verb.POST, twitterUrl + "/account/update_profile_background_image.json", params, null);
	}
	
	/**
	 * Update the users's profile colors.  Use return this method to update a bunch of profile colors at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_colors">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateProfileColors(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/account/update_profile_colors.json", params, null);
	}

	/**
	 * Update the user's profile background color.
	 * 
	 * @param backgroundColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateProfileBackgroundColor(String backgroundColor) throws IOException {
		Bundle bgBundle = new Bundle(1);
		bgBundle.putString("profile_background_color", backgroundColor);
		return updateProfile(bgBundle);
	}
	
	/**
	 * Update the user's profile link color.
	 * 
	 * @param linkColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateProfileLinkColor(String linkColor) throws IOException {
		Bundle linkBundle = new Bundle(1);
		linkBundle.putString("profile_link_color", linkColor);
		return updateProfile(linkBundle);
	}
	
	/**
	 * Update the user's profile sidebar border color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateProfileSidebarBorderColor(String borderColor) throws IOException {
		Bundle borderBundle = new Bundle(1);
		borderBundle.putString("profile_sidebar_border_color", borderColor);
		return updateProfile(borderBundle);
	}
	
	/**
	 * Update the user's profile sidebar fill color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateProfileSidebarFillColor(String fillColor) throws IOException {
		Bundle fillBundle = new Bundle(1);
		fillBundle.putString("profile_sidebar_fill_color", fillColor);
		return updateProfile(fillBundle);
	}
	
	/**
	 * Update the user's profile text color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateProfileTextColor(String textColor) throws IOException {
		Bundle textBundle = new Bundle(1);
		textBundle.putString("profile_text_color", textColor);
		return updateProfile(textBundle);
	}
	
	/**
	 * Update the user's profile image.
	 * 
	 * @param image A Bitmap of the desired image.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_image">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateProfileImage(Bitmap image, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putByteArray("image", Util.bitmapToByteArray(image));
		return this.executeRequest(Verb.POST, twitterUrl + "/account/update_profile_image.json", params, null);
	}
	
	// Block endpoints
	
	/**
	 * Get a list of users that return this user has blocked.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/blocking">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getBlockedUsers(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/blocks/blocking.json", params, null);
	}
	
	/**
	 * Get a list of users ids that return this user has blocked.
	 * 
	 * @param stringifyIds A boolean that tells the API whether or not to stringify the Ids it returns.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getBlockedUsersIds(Boolean stringifyIds) throws IOException {
		Bundle params = new Bundle(1);
		params.putBoolean("stringifyIds", stringifyIds);
		return this.executeRequest(Verb.GET, twitterUrl + "/blocks/blocking/ids.json", params, null);
	}
	
	/**
	 * Checks to see if the authenticated user blocks the target user. Returns the user if yes, else 404's.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response doesBlockExist(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/blocks/blocking/ids.json", params, null);
	}
	
	/**
	 * Checks to see if the authenticated user blocks the supplied user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response doesBlockExist(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return doesBlockExist(params);
	}

	/**
	 * Block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response block(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/blocks/create.json", params, null);
	}
	
	/**
	 * Block the specified user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response block(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return block(params);
	}

	/**
	 * Unblock the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unblock(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/blocks/destroy.json", params, null);
	}
	
	/**
	 * Unblock the specified user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unblock(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return unblock(params);
	}

	// Direct Message endpoints
	
	/**
	 * Get the user's direct messages.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getDirectMessages(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/direct_messages.json", params, null);
	}
	
	/**
	 * Get user's direct messages that are newer than the supplied id.
	 * 
	 * @param sinceId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getDirectMessagesSince(String sinceId, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("since_id", sinceId);
		return getDirectMessages(params);
	}
	
	/**
	 * Get user's direct messages that are older than the supplied id.
	 * 
	 * @param maxId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getDirectMessagesBefore(String maxId, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("max_id", maxId);
		return getDirectMessages(params);
	}
		
	/**
	 * Get the user's sent direct messages.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSentDirectMessages(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/direct_messages/sent.json", params, null);
	}
	
	/**
	 * Get user's sent direct messages that are newer than the supplied id.
	 * 
	 * @param sinceId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSentDirectMessagesSince(String sinceId, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("since_id", sinceId);
		return getSentDirectMessages(params);
	}
	
	/**
	 * Get user's sent direct messages that are older than the supplied id.
	 * 
	 * @param maxId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSentDirectMessagesBefore(String maxId, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("max_id", maxId);
		return getSentDirectMessages(params);
	}
	
	/**
	 * Delete a direct message.
	 * 
	 * @param messageId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/destroy/%3Aid">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response destroyDirectMessage(String messageId, Bundle params) throws IOException {
		return this.executeRequest(Verb.DELETE, twitterUrl + String.format(Locale.US, "/direct_messages/destroy/%s.json", URLEncoder.encode(messageId)), params, null);
	}
	
	/**
	 * Send a new direct message.
	 * 
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response sendDirectMessage(String text, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("text", text);
		return this.executeRequest(Verb.POST, twitterUrl + "/direct_messages/new.json", params, null);
	}
	
	/**
	 * Send a new direct message to a screen name.
	 * 
	 * @param user A {@link User}.
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response sendDirectMessage(User user, String text, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return sendDirectMessage(text, params);
	}

	/**
	 * Get a single direct message.
	 * 
	 * @param messageId A String direct message id.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getDirectMessage(String messageId) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + String.format(Locale.US, "/direct_messages/%s.json", URLEncoder.encode(messageId)), null, null);
	}
	
	// Favorites endpoints
	
	/**
	 * Get the authenticated user's favorites.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @throws IOException 
	 * @return {@link Response}
	 */
	public Response getFavorites(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/favorites.json", params, null);
	}
	
	/**
	 * Get a user's favorites by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @throws IOException 
	 */
	public Response getUserFavorites(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getFavorites(params);
	}
	
	/**
	 * Favorite a tweet.
	 * 
	 * @param tweetId A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/create/%3Aid">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response favorite(String tweetId, Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + String.format(Locale.US, "/favorites/create/%s.json", URLEncoder.encode(tweetId)), params, null);
	}
	
	/**
	 * Unfavorite a tweet.
	 * 
	 * @param tweetId A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/destroy/%3Aid">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unfavorite(String tweetId, Bundle params) throws IOException {
		return this.executeRequest(Verb.DELETE, twitterUrl + String.format(Locale.US, "/favorites/destroy/%s.json", URLEncoder.encode(tweetId)), params, null);
	}
	
	// Friend And Follower endpoints
	
	/**
	 * Get a list of a user's followers ids.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getFollowersIds(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/followers/ids.json", params, null);
	}

	/**
	 * Get a list of a user's follower ids by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getFollowersIds(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getFollowersIds(params);
	}

	/**
	 * Get a list of a user's friends ids.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getFriendsIds(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/friends/ids.json", params, null);
	}

	/**
	 * Get a list of a user's friend ids by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getFriendsIds(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getFollowersIds(params);
	}
	
	/**
	 * Check if a friendship exists between two users.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/exists">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response doesFriendshipExist(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/friendships/exists.json", params, null);
	}
		
	/**
	 * Check if a friendship exists between two users.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/exists">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response doesFriendshipExist(User userA, User userB, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params = userA.appendToBundle(params);
		params = userB.appendToBundle(params);
		return doesFriendshipExist(params);
	}
	
	/**
	 * Get a list of friend requests for the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/incoming">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getIncomingFriendRequests(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/friendships/incoming.json", params, null);
	}

	/**
	 * Get a list of friend requests made by the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/outgoing">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getOutgoingFriendRequests(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/friendships/outgoing.json", params, null);
	}
	
	/**
	 * Get detailed information about a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/show">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response showFriendship(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/friendships/show.json", params, null);
	}
	
	/**
	 * Create a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response createFriendship(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/friendships/create.json", params, null);
	}
	
	/**
	 * Create a friendship by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response createFriendship(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return createFriendship(params);
	}
	
	/**
	 * Destroy a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response destroyFriendship(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/friendships/destroy.json", params, null);
	}
	
	/**
	 * Destroy a friendship by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response destroyFriendship(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return destroyFriendship(params);
	}
	
	/**
	 * Look up the relationship between the authenticated user and the list of user ids or screen names.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response lookupFriendship(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/friendships/lookup.json", params, null);
	}
	
	/**
	 * Look up the relationship between the authenticated user and the list of users.
	 * 
	 * @param users An {@link UserCollection}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response lookupFriendship(UserCollection users, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = users.appendToBundle(params);
		return lookupFriendship(params);
	}
	
	/**
	 * Update what notifications should be shown for a friend.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/update">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateFriendship(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/friendships/update.json", params, null);
	}
	
	/**
	 * Returns an array of user_ids that the currently authenticated user does not want to see retweets from..
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/get-friendshipsno_retweet_ids">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getNoRetweetIds(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/friendships/no_retweet_ids.json", params, null);
	}
	
	// List endpoints
	
	/**
	 * Get lists of the authenticated user or the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/all">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSubscribedLists(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/lists/all.json", params, null);
	}
	
	/**
	 * Get lists of the user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/all">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSubscribedLists(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getSubscribedLists(params);
	}
	
	/**
	 * Get statutes of the specified list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/statuses">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getListStatuses(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/lists/statuses.json", params, null);
	}
	
	/**
	 * Get statuses of the specified list by id.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/statuses">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getListStatuses(TwitterList list, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		return getListStatuses(params);
	}

	/**
	 * Remove a member from a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response removeMemberFromList(Bundle params) throws IOException {
		return this.executeRequest(Verb.DELETE, twitterUrl + "/lists/members/destroy.json", params, null);
	}

	/**
	 * Remove a member from a list by list.
	 * 
	 * @param list A {@TwitterList}.
	 * @param user A {@User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response removeMemberFromList(TwitterList list, User user) throws IOException {
		// TODO What's the smallest return this Bundle can be and still fit everything?
		Bundle params = new Bundle();
		params = list.appendToBundle(params);
		params = user.appendToBundle(params);
		return removeMemberFromList(params);
	}
	
	/**
	 * Get the lists the user is a member of.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/memberships">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersListMemberships(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/lists/memberships.json", params, null);
	}
	
	/**
	 * Get the lists the user is a member of by id.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/memberships">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersListMemberships(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getUsersListMemberships(params);
	}
	
	/**
	 * Get a lists subscribers.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscriptions">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getListSubscribers(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/lists/subscribers.json", params, null);
	}
	
	/**
	 * Get a lists subscribers.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscriptions">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getListSubscribers(TwitterList list, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		return getListSubscribers(params);
	}

	/**
	 * Subscribe the authenticated user to a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response subscribeToList(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/lists/subscribers/create.json", params, null);
	}
	
	/**
	 * Subscribe the authenticated user to a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response subscribeToList(TwitterList list, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		return subscribeToList(params);
	}

	/**
	 * Check if the specified user is a member of the list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscribers/show">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response isUserListSubscriber(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/lists/subscribers/show.json", params, null);
	}
	
	/**
	 * Unsubscribe the authenticated user from a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unsubscribeFromList(Bundle params) throws IOException {
		return this.executeRequest(Verb.DELETE, twitterUrl + "/lists/subscribers/destroy.json", params, null);
	}
	
	/**
	 * Unsubscribe the authenticated user from a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unsubscribeFromList(TwitterList list, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		return unsubscribeFromList(params);
	}

	/**
	 * Add multiple users to a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/create_all">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response addUsersToList(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/lists/members/create_all.json", params, null);
	}
	
	/**
	 * Add multiple users to a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param users An {@link UserCollection}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response addUsersToList(TwitterList list, UserCollection users) throws IOException {
		// TODO What's the smallest return this Bundle can be?
		Bundle params = new Bundle();
		params = list.appendToBundle(params);
		params = users.appendToBundle(params);
		return addUsersToList(params);
	}
	
	/**
	 * Delete list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response deleteList(Bundle params) throws IOException {
		return this.executeRequest(Verb.DELETE, twitterUrl + "/lists/destroy.json", params, null);
	}
		
	/**
	 * Delete list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/destroy">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response deleteList(TwitterList list, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		return deleteList(params);
	}

	/**
	 * Update a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/update">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateList(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/lists/update.json", params, null);
	}
	
	/**
	 * Update a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/update">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response updateList(TwitterList list, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params = list.appendToBundle(params);
		return updateList(params);
	}
	
	/**
	 * Create a list.
	 * 
	 * @param name A String Twitter list name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/create">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response createList(String name, Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/lists/create.json", params, null);
	}
	
	/**
	 * Get lists owned by the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersLists(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/lists.json", params, null);
	}
	
	/**
	 * Get lists owned by the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUsersLists(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getUsersLists(params);
	}
	
	/**
	 * Get a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/show">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getList(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/lists/show.json", params, null);
	}
	
	/**
	 * Get a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/show">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getList(TwitterList list, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		return getList(params);
	}
		
	// Notification endpoints
	
	/**
	 * Enables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/notifications/follow">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response followNotifications(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/notifications/follow.json", params, null);
	}
	
	/**
	 * Enables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param user A {@link User}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response followNotifications(User user) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		return followNotifications(params);
	}
		
	/**
	 * Disables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/notifications/follow">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unfollowNotifications(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/notifications/leave.json", params, null);
	}
	
	/**
	 * Disables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param user A {@link User}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response unfollowNotifications(User user) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		return unfollowNotifications(params);
	}
	
	// Places & Geo endpoints
	
	/**
	 * Get all information about a place.
	 * 
	 * @param placeId A String id that can be retrieved from reverseGeocode.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getPlace(String placeId) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/geo/id/%s.json", URLEncoder.encode(placeId)), null, null);
	}
	
	/**
	 * Searches for up to 20 places to be used as a place_id.
	 * 
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/reverse_geocode">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response reverseGeocode(String lat, String lon, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("lat", lat);
		params.putString("long", lon);
		return this.executeRequest(Verb.GET, twitterUrl + "/geo/reverse_geocode.json", params, null);
	}
	
	/**
	 * Search nearby places.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/search">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response searchNearby(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/geo/nearby_places.json", params, null);
	}
	
	/**
	 * Locates places near the given coordinates which are similar in name.
	 * 
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param name A String of the name of the place.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/search">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response similarPlaces(String lat, String lon, String name, Bundle params) throws IOException {
		params = Util.initBundle(params, 3);
		params.putString("lat", lat);
		params.putString("long", lon);
		params.putString("name", name);
		return this.executeRequest(Verb.GET, twitterUrl + "/geo/similar_places.json", params, null);
	}
	
	/**
	 * Creates a new place object at the given latitude and longitude.
	 * 
	 * @param name A String of the name of the place.
	 * @param containedWithin A String of the place_id that return this place is within.
	 * @param token A String token found in the response from similarPlaces.
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/geo/place">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response createPlace(String name, String containedWithin, String token, String lat, String lon, Bundle params) throws IOException {
		params = Util.initBundle(params, 5);
		params.putString("lat", lat);
		params.putString("long", lon);
		params.putString("name", name);
		params.putString("token", token);
		params.putString("containedWithin", containedWithin);
		return this.executeRequest(Verb.POST, twitterUrl + "/geo/place.json", params, null);
	}
		
	// Saved Searches endpoints
	
	/**
	 * Returns the authenticated users saved search queries.
	 * 
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSavedSearches() throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/saved_searches.json", null, null);
	}
	
	/**
	 * Retrieve the information for the saved search represented by the given id.
	 * 
	 * @param id A String id of the saved search query.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response showSavedSearch(String id) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/saved_searches/show/%s.json", URLEncoder.encode(id)), null, null);
	}
	
	/**
	 * Create a new saved search.
	 * 
	 * @param query A String search query.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response createSavedSearch(String query) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("query", query);
		return this.executeRequest(Verb.POST, twitterUrl + "/saved_searches/create.json", params, null);
	}
		
	/**
	 * Delete a saved search.
	 * 
	 * @param id A String id of the saved search query.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response deleteSavedSearch(String id) throws IOException {
		return this.executeRequest(Verb.DELETE, String.format(Locale.US, twitterUrl + "/saved_searches/destroy/%s.json", URLEncoder.encode(id)), null, null);
	}
	
	// Search endpoints
	
	/**
	 * Returns tweets that match a specified query.
	 * 
	 * @param q A String search query.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/search">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response search(String q, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("q", q);
		return this.executeRequest(Verb.GET, twitterUrl + "/search.json", params, null);
	}

	// Spam Reporting endpoints
	
	/**
	 * Report spam and block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/report_spam">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response reportSpam(Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, twitterUrl + "/report_spam.json", params, null);
	}
	
	/**
	 * Report spam and block the specified user.
	 * 
	 * @param user A {@link User}.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response reportSpam(User user) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		return reportSpam(params);
	}
	
	// Timeline endpoints
	
	/**
	 * Returns the most recent statuses posted by the authenticated user and the people they follow.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/home_timeline">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getTimeline(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/home_timeline.json", params, null);
	}
	
	/**
	 * Get the authenticated user's most recent mentions.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/mentions">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getMentions(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/mentions.json", params, null);
	}
		
	/**
	 * Returns the most recent public statuses.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/public_timeline">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getPublicStatuses(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/public_timeline.json", params, null);
	}
	
	/**
	 * Returns the most recent retweets by the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_by_me">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetedByMe(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweeted_by_me.json", params, null);
	}
	
	/**
	 * Returns the most recent retweets by the people the authenticated user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_me">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetedToMe(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweeted_to_me.json", params, null);
	}
	
	/**
	 * Returns the most recent retweets of the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweets_of_me">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetsOfMe(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweets_of_me.json", params, null);
	}
	
	/**
	 * Returns the most recent tweets of the authenticated user or the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/user_timeline">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUserStatuses(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/user_timeline.json", params, null);
	}
		
	/**
	 * Returns the most recent tweets of the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/user_timeline">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUserStatuses(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		return getUserStatuses(params);
	}
	
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_user">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetedToUser(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweeted_to_user.json", params, null);
	}
		
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_user">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetedToUser(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		return getRetweetedToUser(params);
	}
		
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/get/statuses/retweeted_by_user">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetedByUser(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweeted_by_user.json", params, null);
	}
		
	/**
	 * Returns the most recent retweets by the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/get/statuses/retweeted_by_user">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetedByUser(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		return getRetweetedByUser(params);
	}
	
	// Trends & Local Trends endpoints
	
	/**
	 * Returns the top 10 trending topics for the given @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth Id</a>.
	 * 
	 * @param whereOnEarthId A String Yahoo where on earth id.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getLocalTrends(String whereOnEarthId) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/trends/%s.json", URLEncoder.encode(whereOnEarthId)), null, null);
	}
	
	/**
	 * Returns the locations that Twitter has trending topic information for.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/available">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getAvailableTrendLocations(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/trends/available.json", params, null);
	}
		
	/**
	 * Returns the top 10 current trending topics on Twitter.
	 * 
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getTrends() throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/trends.json", null, null);
	}
	
	/**
	 * Returns the top 10 current trending topics on Twitter.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getCurrentTrends(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/trends/current.json", params, null);
	}
	
	/**
	 * Returns the top 20 trending topics for each hour in a given day.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getDailyTrends(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/trends/daily.json", params, null);
	}
	
	/**
	 * Returns the top 30 trending topics for each day in a given week.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getWeeklyTrends(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/trends/weekly.json", params, null);
	}
	
	// Tweet endpoints
	
	/**
	 * Show user objects of up to 100 members who retweeted the status.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/%3Aid/retweeted_by">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetedBy(String id, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/statuses/%s/retweeted_by.json", URLEncoder.encode(id)), params, null);
	}
	
	/**
	 * Show user ids of up to 100 users who retweeted the status.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/%3Aid/retweeted_by/ids">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweetedByIds(String id, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/statuses/%s/retweeted_by/ids.json", URLEncoder.encode(id)), params, null);
	}
	
	/**
	 * Returns up to 100 of the first retweets of a given tweet.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweets/%3Aid">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getRetweets(String id, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/statuses/retweets/%s.json", URLEncoder.encode(id)), params, null);
	}
	
	/**
	 * Returns a single status, specified by the id parameter below.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/show/%3Aid">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getTweet(String id, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/statuses/show/%s.json", URLEncoder.encode(id)), params, null);
	}
	
	/**
	 * Delete a tweet made by the authenticated user.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/destroy/%3Aid">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response deleteTweet(String id, Bundle params) throws IOException {
		return this.executeRequest(Verb.DELETE, String.format(Locale.US, twitterUrl + "/statuses/destroy/%s.json", URLEncoder.encode(id)), params, null);
	}
	
	/**
	 * Retweet.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/retweet/%3Aid">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response retweet(String id, Bundle params) throws IOException {
		return this.executeRequest(Verb.POST, String.format(Locale.US, twitterUrl + "/statuses/retweet/%s.json", URLEncoder.encode(id)), params, null);
	}
		
	/**
	 * Tweet.
	 * 
	 * @param text A String status.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/retweet/%3Aid">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response tweet(String text, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("text", text);
		return this.executeRequest(Verb.POST, twitterUrl + "/statuses/update.json", params, null);
	}
	
	// User endpoints
	
	/**
	 * Return up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/lookup">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response lookupUsers(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/users/lookup.json", params, null);
	}
	
	/**
	 * Return up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two.
	 * 
	 * @param users {@link UserCollection}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/lookup">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response lookupUsers(UserCollection users, Bundle params) throws IOException {
		params = Util.initBundle(params, 2);
		params = users.appendToBundle(params);
		return lookupUsers(params);
	}
	
	/**
	 * Access the profile image in various sizes for the user with the indicated screen_name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/profile_image/%3Ascreen_name">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getProfileImage(String screenName, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/users/profile_image/%s.json", URLEncoder.encode(screenName)), params, null);
	}
	
	/**
	 * Search Twitter users with the given query.
	 * 
	 * @param q A String search query.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response searchUsers(String q, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("q", q);
		return this.executeRequest(Verb.GET, twitterUrl + "/users/search.json", params, null);
	}
		
	/**
	 * Return the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUser(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/users/show.json", params, null);
	}
	
	/**
	 * Return the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getUser(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getUser(params);
	}
	
	/**
	 * Returns an array of users that the specified user can contribute to.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributees">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getContributees(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/users/contributees.json", params, null);
	}
	
	/**
	 * Returns an array of users that the specified user can contribute to.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributees">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getContributees(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getContributees(params);
	}
	
	/**
	 * Returns an array of users who can contribute to the specified account.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributors">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getContributors(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/users/contributors.json", params, null);
	}
	
	/**
	 * Returns an array of users who can contribute to the specified account.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributors">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getContributors(User user, Bundle params) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		return getContributors(params);
	}
	
	/**
	 * Returns Twitter's suggested user list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSuggestedUsers(Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, twitterUrl + "/users/suggestions.json", params, null);
	}
	
	/**
	 * Returns Twitter's suggested user list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions/%3Aslug">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSuggestedUsers(String slug, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/users/suggestions/%s.json", URLEncoder.encode(slug)), params, null);
	}
		
	/**
	 * Return the users in a given category of the Twitter suggested user list and return their most recent status.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions/%3Aslug/members">here</a>.
	 * @return {@link Response}
	 * @throws IOException 
	 */
	public Response getSuggestedUsersWithStatus(String slug, Bundle params) throws IOException {
		return this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/users/suggestions/%s/members.json", URLEncoder.encode(slug)), params, null);
	}
	
}
