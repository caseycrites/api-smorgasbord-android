package com.simplegeo.android.clients;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

import org.scribe.builder.api.TwitterApi;
import org.scribe.model.Token;
import org.scribe.model.Verb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.simplegeo.android.types.OAuthCredentials;
import com.simplegeo.android.types.TwitterList;
import com.simplegeo.android.types.User;
import com.simplegeo.android.types.UserCollection;
import com.simplegeo.android.util.SGListener;
import com.simplegeo.android.util.Util;

public class Twitter extends AbstractClient {
	public static final String TAG = Twitter.class.getSimpleName();
	
	private static final String twitterUrl = "http://api.twitter.com/1";
	private String authorizationUrl = "https://api.twitter.com/oauth/authorize?oauth_token=%s&response=code";

	public Twitter(OAuthCredentials credentials, String redirectUrl, Context context) {
		super(credentials, TwitterApi.class, redirectUrl, context);
	}
	
	/**
	 * Verify the user's credentials.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/account/verify_credentials">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException
	 */
	public void verifyCredentials(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/account/verify_credentials.json", params, null, listener);
	}
	
	/**
	 * Retrieve the users rate limit status.
	 * 
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void rateLimitStatus(SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/account/rate_limit_status.json", null, null, listener);
	}
		
	/**
	 * Retrieve the users totals for friends, followers, updates and favorites.
	 * 
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void totals(SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/account/totals.json", null, null, listener);
	}
	
	/**
	 * Retrieve the users account settings.
	 * 
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSettings(SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/account/settings.json", null, null, listener);
	}
		
	/**
	 * Sets the users account settings.  Use this to update a bunch of user settings at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/settings">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void setSettings(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/account/settings.json", params, null, listener);
	}
	
	/**
	 * Set the trend location.
	 * 
	 * @param trendLocation A String of a @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth ID</a> to use as the user's default trending location.
	 * @param listener {@link SGListener}
	 * @throws IOException
	 */
	public void setTrendLocation(String trendLocation, SGListener listener) throws IOException {
		Bundle trendBundle = new Bundle(1);
		trendBundle.putString("trend_location_woeid", trendLocation);
		setSettings(trendBundle, listener);
	}
	
	/**
	 * Enable sleep time and set the start and end sleep time.
	 * 
	 * @param startSleepTime An int in the range, 0-23.
	 * @param endSleepTime An int in the range, 0-23.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void enableSleepTime(int startSleepTime, int endSleepTime, SGListener listener) throws IOException {
		Bundle sleepBundle = new Bundle(3);
		sleepBundle.putBoolean("sleep_time_enabled", true);
		sleepBundle.putString("start_sleep_time", String.valueOf(startSleepTime));
		sleepBundle.putString("end_sleep_time", String.valueOf(endSleepTime));
		setSettings(sleepBundle, listener);
	}
	
	/**
	 * Disable sleep time.
	 * 
	 * @param listener {@link SGListener}
	 * @throws IOException
	 */
	public void disableSleepTime(SGListener listener) throws IOException {
		Bundle sleepBundle = new Bundle(1);
		sleepBundle.putBoolean("sleep_time_enabled", false);
		setSettings(sleepBundle, listener);
	}
	
	/**
	 * Set time zone.
	 * 
	 * @param timeZone A String of one of the @see <a href="http://api.rubyonrails.org/classes/ActiveSupport/TimeZone.html">Rails Time Zone's</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException
	 */
	public void setTimeZone(String timeZone, SGListener listener) throws IOException {
		Bundle timeZoneBundle = new Bundle(1);
		timeZoneBundle.putString("time_zone", timeZone);
		setSettings(timeZoneBundle, listener);
	}
		
	/**
	 * Set language.
	 * 
	 * @param lang A String of one of the @see <a href="https://dev.twitter.com/docs/api/1/get/help/languages">Twitter Supported Languages.</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void setLanguage(String lang, SGListener listener) throws IOException {
		Bundle langBundle = new Bundle(1);
		langBundle.putString("lang", lang);
		setSettings(langBundle, listener);
	}
	
	/**
	 * Update whether a user receives SMS alerts or not.
	 * 
	 * @param device A String of either sms or none.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_delivery_device">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateDeliveryDevice(String device, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("device", device);
		this.executeRequest(Verb.POST, twitterUrl + "/account/update_delivery_device.json", params, null, listener);
	}
	
	/**
	 * Update the user's profile.  Use this method to update a bunch of profile settings at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException
	 */
	public void updateProfile(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/account/update_profile.json", params, null, listener);
	}
	
	/**
	 * Update the user's full name.
	 * 
	 * @param name A String of the user's full name. Must be 20 characters or less.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateName(String name, SGListener listener) throws IOException {
		Bundle nameBundle = new Bundle(1);
		nameBundle.putString("name", name);
		updateProfile(nameBundle, listener);
	}
		
	/**
	 * Update the user's url.
	 * 
	 * @param url A String of the user's url.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateUrl(String url, SGListener listener) throws IOException {
		Bundle urlBundle = new Bundle(1);
		urlBundle.putString("url", url);
		updateProfile(urlBundle, listener);
	}
	
	/**
	 * Update the user's location.
	 * 
	 * @param location A String of the user's location. Must be 30 characters or less.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateLocation(String location, SGListener listener) throws IOException {
		Bundle locationBundle = new Bundle(1);
		locationBundle.putString("location", location);
		updateProfile(locationBundle, listener);
	}
		
	/**
	 * Update the user's description.
	 * 
	 * @param description A String of the user's description. Must be 160 characters or less.
	 * @param listener {@link SGListener}
	 * @throws IOException
	 */
	public void updateDescription(String description, SGListener listener) throws IOException {
		Bundle descriptionBundle = new Bundle(1);
		descriptionBundle.putString("description", description);
		updateProfile(descriptionBundle, listener);
	}
	
	/**
	 * Update the user's profile background image.
	 * 
	 * @param image A Bitmap of the desired background image.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_background_image">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateProfileBackgroundImage(Bitmap image, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putByteArray("image", Util.bitmapToByteArray(image));
		this.executeRequest(Verb.POST, twitterUrl + "/account/update_profile_background_image.json", params, null, listener);
	}
	
	/**
	 * Update the users's profile colors.  Use this method to update a bunch of profile colors at once.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_colors">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateProfileColors(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/account/update_profile_colors.json", params, null, listener);
	}

	/**
	 * Update the user's profile background color.
	 * 
	 * @param backgroundColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateProfileBackgroundColor(String backgroundColor, SGListener listener) throws IOException {
		Bundle bgBundle = new Bundle(1);
		bgBundle.putString("profile_background_color", backgroundColor);
		updateProfile(bgBundle, listener);
	}
	
	/**
	 * Update the user's profile link color.
	 * 
	 * @param linkColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateProfileLinkColor(String linkColor, SGListener listener) throws IOException {
		Bundle linkBundle = new Bundle(1);
		linkBundle.putString("profile_link_color", linkColor);
		updateProfile(linkBundle, listener);
	}
	
	/**
	 * Update the user's profile sidebar border color.
	 * 
	 * @param borderColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateProfileSidebarBorderColor(String borderColor, SGListener listener) throws IOException {
		Bundle borderBundle = new Bundle(1);
		borderBundle.putString("profile_sidebar_border_color", borderColor);
		updateProfile(borderBundle, listener);
	}
	
	/**
	 * Update the user's profile sidebar fill color.
	 * 
	 * @param fillColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateProfileSidebarFillColor(String fillColor, SGListener listener) throws IOException {
		Bundle fillBundle = new Bundle(1);
		fillBundle.putString("profile_sidebar_fill_color", fillColor);
		updateProfile(fillBundle, listener);
	}
	
	/**
	 * Update the user's profile text color.
	 * 
	 * @param textColor A String of length 3 or 6 in hexadecimal of the desired color.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateProfileTextColor(String textColor, SGListener listener) throws IOException {
		Bundle textBundle = new Bundle(1);
		textBundle.putString("profile_text_color", textColor);
		updateProfile(textBundle, listener);
	}
	
	/**
	 * Update the user's profile image.
	 * 
	 * @param image A Bitmap of the desired image.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/account/update_profile_image">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateProfileImage(Bitmap image, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putByteArray("image", Util.bitmapToByteArray(image));
		this.executeRequest(Verb.POST, twitterUrl + "/account/update_profile_image.json", params, null, listener);
	}
	
	// Block endpoints
	
	/**
	 * Get a list of users that this user has blocked.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/blocking">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getBlockedUsers(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/blocks/blocking.json", params, null, listener);
	}
	
	/**
	 * Get a list of users ids that this user has blocked.
	 * 
	 * @param stringifyIds A boolean that tells the API whether or not to stringify the Ids it returns.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getBlockedUsersIds(Boolean stringifyIds, SGListener listener) throws IOException {
		Bundle params = new Bundle(1);
		params.putBoolean("stringifyIds", stringifyIds);
		this.executeRequest(Verb.GET, twitterUrl + "/blocks/blocking/ids.json", params, null, listener);
	}
	
	/**
	 * Checks to see if the authenticated user blocks the target user. Returns the user if yes, else 404's.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void doesBlockExist(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/blocks/blocking/ids.json", params, null, listener);
	}
	
	/**
	 * Checks to see if the authenticated user blocks the supplied user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void doesBlockExist(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		doesBlockExist(params, listener);
	}

	/**
	 * Block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void block(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/blocks/create.json", params, null, listener);
	}
	
	/**
	 * Block the specified user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void block(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		block(params, listener);
	}

	/**
	 * Unblock the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void unblock(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/blocks/destroy.json", params, null, listener);
	}
	
	/**
	 * Unblock the specified user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void unblock(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		unblock(params, listener);
	}

	// Direct Message endpoints
	
	/**
	 * Get the user's direct messages.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getDirectMessages(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/direct_messages.json", params, null, listener);
	}
	
	/**
	 * Get user's direct messages that are newer than the supplied id.
	 * 
	 * @param sinceId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getDirectMessagesSince(String sinceId, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("since_id", sinceId);
		getDirectMessages(params, listener);
	}
	
	/**
	 * Get user's direct messages that are older than the supplied id.
	 * 
	 * @param maxId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getDirectMessagesBefore(String maxId, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("max_id", maxId);
		getDirectMessages(params, listener);
	}
		
	/**
	 * Get the user's sent direct messages.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSentDirectMessages(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/direct_messages/sent.json", params, null, listener);
	}
	
	/**
	 * Get user's sent direct messages that are newer than the supplied id.
	 * 
	 * @param sinceId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSentDirectMessagesSince(String sinceId, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("since_id", sinceId);
		getSentDirectMessages(params, listener);
	}
	
	/**
	 * Get user's sent direct messages that are older than the supplied id.
	 * 
	 * @param maxId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/direct_messages/sent">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSentDirectMessagesBefore(String maxId, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("max_id", maxId);
		getSentDirectMessages(params, listener);
	}
	
	/**
	 * Delete a direct message.
	 * 
	 * @param messageId A String direct message id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/destroy/%3Aid">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void destroyDirectMessage(String messageId, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.DELETE, twitterUrl + String.format(Locale.US, "/direct_messages/destroy/%s.json", URLEncoder.encode(messageId, "UTF-8")), params, null, listener);
	}
	
	/**
	 * Send a new direct message.
	 * 
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void sendDirectMessage(String text, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("text", text);
		this.executeRequest(Verb.POST, twitterUrl + "/direct_messages/new.json", params, null, listener);
	}
	
	/**
	 * Send a new direct message to a screen name.
	 * 
	 * @param user A {@link User}.
	 * @param text A String direct message.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/direct_messages/new">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void sendDirectMessage(User user, String text, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		sendDirectMessage(text, params, listener);
	}

	/**
	 * Get a single direct message.
	 * 
	 * @param messageId A String direct message id.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getDirectMessage(String messageId, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + String.format(Locale.US, "/direct_messages/%s.json", URLEncoder.encode(messageId, "UTF-8")), null, null, listener);
	}
	
	// Favorites endpoints
	
	/**
	 * Get the authenticated user's favorites.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @throws IOException 
	 * @param listener {@link SGListener}
	 */
	public void getFavorites(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/favorites.json", params, null, listener);
	}
	
	/**
	 * Get a user's favorites by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">here</a>.
	 * @throws IOException 
	 */
	public void getUserFavorites(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getFavorites(params, listener);
	}
	
	/**
	 * Favorite a tweet.
	 * 
	 * @param tweetId A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/create/%3Aid">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void favorite(String tweetId, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + String.format(Locale.US, "/favorites/create/%s.json", URLEncoder.encode(tweetId, "UTF-8")), params, null, listener);
	}
	
	/**
	 * Unfavorite a tweet.
	 * 
	 * @param tweetId A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/destroy/%3Aid">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void unfavorite(String tweetId, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.DELETE, twitterUrl + String.format(Locale.US, "/favorites/destroy/%s.json", URLEncoder.encode(tweetId, "UTF-8")), params, null, listener);
	}
	
	// Friend And Follower endpoints
	
	/**
	 * Get a list of a user's followers ids.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getFollowersIds(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/followers/ids.json", params, null, listener);
	}

	/**
	 * Get a list of a user's follower ids by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getFollowersIds(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getFollowersIds(params, listener);
	}

	/**
	 * Get a list of a user's friends ids.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getFriendsIds(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/friends/ids.json", params, null, listener);
	}

	/**
	 * Get a list of a user's friend ids by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/followers/ids">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getFriendsIds(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getFollowersIds(params, listener);
	}
	
	/**
	 * Check if a friendship exists between two users.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/exists">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void doesFriendshipExist(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/friendships/exists.json", params, null, listener);
	}
		
	/**
	 * Check if a friendship exists between two users.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/exists">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void doesFriendshipExist(User userA, User userB, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 2);
		params = userA.appendToBundle(params);
		params = userB.appendToBundle(params);
		doesFriendshipExist(params, listener);
	}
	
	/**
	 * Get a list of friend requests for the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/incoming">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getIncomingFriendRequests(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/friendships/incoming.json", params, null, listener);
	}

	/**
	 * Get a list of friend requests made by the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/outgoing">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getOutgoingFriendRequests(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/friendships/outgoing.json", params, null, listener);
	}
	
	/**
	 * Get detailed information about a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/show">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void showFriendship(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/friendships/show.json", params, null, listener);
	}
	
	/**
	 * Create a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void createFriendship(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/friendships/create.json", params, null, listener);
	}
	
	/**
	 * Create a friendship by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/create">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void createFriendship(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		createFriendship(params, listener);
	}
	
	/**
	 * Destroy a friendship.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void destroyFriendship(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/friendships/destroy.json", params, null, listener);
	}
	
	/**
	 * Destroy a friendship by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void destroyFriendship(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		destroyFriendship(params, listener);
	}
	
	/**
	 * Look up the relationship between the authenticated user and the list of user ids or screen names.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void lookupFriendship(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/friendships/lookup.json", params, null, listener);
	}
	
	/**
	 * Look up the relationship between the authenticated user and the list of users.
	 * 
	 * @param users An {@link UserCollection}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/friendships/lookup">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void lookupFriendship(UserCollection users, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = users.appendToBundle(params);
		lookupFriendship(params, listener);
	}
	
	/**
	 * Update what notifications should be shown for a friend.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/friendships/update">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateFriendship(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/friendships/update.json", params, null, listener);
	}
	
	/**
	 * Returns an array of user_ids that the currently authenticated user does not want to see retweets from..
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/get-friendshipsno_retweet_ids">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getNoRetweetIds(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/friendships/no_retweet_ids.json", params, null, listener);
	}
	
	// List endpoints
	
	/**
	 * Get lists of the authenticated user or the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/all">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSubscribedLists(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/lists/all.json", params, null, listener);
	}
	
	/**
	 * Get lists of the user by user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/all">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSubscribedLists(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getSubscribedLists(params, listener);
	}
	
	/**
	 * Get statutes of the specified list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/statuses">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getListStatuses(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/lists/statuses.json", params, null, listener);
	}
	
	/**
	 * Get statuses of the specified list by id.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/statuses">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getListStatuses(TwitterList list, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		getListStatuses(params, listener);
	}

	/**
	 * Remove a member from a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void removeMemberFromList(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.DELETE, twitterUrl + "/lists/members/destroy.json", params, null, listener);
	}

	/**
	 * Remove a member from a list by list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param user A {@link User}.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void removeMemberFromList(TwitterList list, User user, SGListener listener) throws IOException {
		// TODO What's the smallest this Bundle can be and still fit everything?
		Bundle params = new Bundle();
		params = list.appendToBundle(params);
		params = user.appendToBundle(params);
		removeMemberFromList(params, listener);
	}
	
	/**
	 * Get the lists the user is a member of.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/memberships">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getUsersListMemberships(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/lists/memberships.json", params, null, listener);
	}
	
	/**
	 * Get the lists the user is a member of by id.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/memberships">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getUsersListMemberships(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUsersListMemberships(params, listener);
	}
	
	/**
	 * Get a lists subscribers.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscriptions">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getListSubscribers(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/lists/subscribers.json", params, null, listener);
	}
	
	/**
	 * Get a lists subscribers.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscriptions">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getListSubscribers(TwitterList list, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		getListSubscribers(params, listener);
	}

	/**
	 * Subscribe the authenticated user to a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void subscribeToList(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/lists/subscribers/create.json", params, null, listener);
	}
	
	/**
	 * Subscribe the authenticated user to a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void subscribeToList(TwitterList list, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		subscribeToList(params, listener);
	}

	/**
	 * Check if the specified user is a member of the list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscribers/show">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void isUserListSubscriber(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/lists/subscribers/show.json", params, null, listener);
	}
	
	/**
	 * Unsubscribe the authenticated user from a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void unsubscribeFromList(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.DELETE, twitterUrl + "/lists/subscribers/destroy.json", params, null, listener);
	}
	
	/**
	 * Unsubscribe the authenticated user from a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void unsubscribeFromList(TwitterList list, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		unsubscribeFromList(params, listener);
	}

	/**
	 * Add multiple users to a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/members/create_all">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void addUsersToList(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/lists/members/create_all.json", params, null, listener);
	}
	
	/**
	 * Add multiple users to a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param users An {@link UserCollection}.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void addUsersToList(TwitterList list, UserCollection users, SGListener listener) throws IOException {
		// TODO What's the smallest this Bundle can be?
		Bundle params = new Bundle();
		params = list.appendToBundle(params);
		params = users.appendToBundle(params);
		addUsersToList(params, listener);
	}
	
	/**
	 * Delete list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void deleteList(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.DELETE, twitterUrl + "/lists/destroy.json", params, null, listener);
	}
		
	/**
	 * Delete list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/destroy">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void deleteList(TwitterList list, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		deleteList(params, listener);
	}

	/**
	 * Update a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/update">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateList(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/lists/update.json", params, null, listener);
	}
	
	/**
	 * Update a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/update">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void updateList(TwitterList list, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 2);
		params = list.appendToBundle(params);
		updateList(params, listener);
	}
	
	/**
	 * Create a list.
	 * 
	 * @param name A String Twitter list name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/lists/create">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void createList(String name, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/lists/create.json", params, null, listener);
	}
	
	/**
	 * Get lists owned by the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getUsersLists(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/lists.json", params, null, listener);
	}
	
	/**
	 * Get lists owned by the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getUsersLists(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUsersLists(params, listener);
	}
	
	/**
	 * Get a list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/show">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getList(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/lists/show.json", params, null, listener);
	}
	
	/**
	 * Get a list.
	 * 
	 * @param list A {@link TwitterList}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/lists/show">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getList(TwitterList list, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = list.appendToBundle(params);
		getList(params, listener);
	}
		
	// Notification endpoints
	
	/**
	 * Enables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/notifications/follow">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void followNotifications(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/notifications/follow.json", params, null, listener);
	}
	
	/**
	 * Enables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param user A {@link User}.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void followNotifications(User user, SGListener listener) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		followNotifications(params, listener);
	}
		
	/**
	 * Disables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/notifications/follow">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void unfollowNotifications(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/notifications/leave.json", params, null, listener);
	}
	
	/**
	 * Disables device notifications for updates from the specified user. Returns the specified user when successful.
	 * 
	 * @param user A {@link User}.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void unfollowNotifications(User user, SGListener listener) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		unfollowNotifications(params, listener);
	}
	
	// Places & Geo endpoints
	
	/**
	 * Get all information about a place.
	 * 
	 * @param placeId A String id that can be retrieved from reverseGeocode.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getPlace(String placeId, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/geo/id/%s.json", URLEncoder.encode(placeId, "UTF-8")), null, null, listener);
	}
	
	/**
	 * Searches for up to 20 places to be used as a place_id.
	 * 
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/reverse_geocode">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void reverseGeocode(String lat, String lon, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 2);
		params.putString("lat", lat);
		params.putString("long", lon);
		this.executeRequest(Verb.GET, twitterUrl + "/geo/reverse_geocode.json", params, null, listener);
	}
	
	/**
	 * Search nearby places.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/search">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void searchNearby(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/geo/nearby_places.json", params, null, listener);
	}
	
	/**
	 * Locates places near the given coordinates which are similar in name.
	 * 
	 * @param lat A String latitude.
	 * @param lon A String longitude.
	 * @param name A String of the name of the place.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/geo/search">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void similarPlaces(String lat, String lon, String name, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 3);
		params.putString("lat", lat);
		params.putString("long", lon);
		params.putString("name", name);
		this.executeRequest(Verb.GET, twitterUrl + "/geo/similar_places.json", params, null, listener);
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
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void createPlace(String name, String containedWithin, String token, String lat, String lon, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 5);
		params.putString("lat", lat);
		params.putString("long", lon);
		params.putString("name", name);
		params.putString("token", token);
		params.putString("containedWithin", containedWithin);
		this.executeRequest(Verb.POST, twitterUrl + "/geo/place.json", params, null, listener);
	}
		
	// Saved Searches endpoints
	
	/**
	 * Returns the authenticated users saved search queries.
	 * 
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSavedSearches(SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/saved_searches.json", null, null, listener);
	}
	
	/**
	 * Retrieve the information for the saved search represented by the given id.
	 * 
	 * @param id A String id of the saved search query.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void showSavedSearch(String id, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/saved_searches/show/%s.json", URLEncoder.encode(id, "UTF-8")), null, null, listener);
	}
	
	/**
	 * Create a new saved search.
	 * 
	 * @param query A String search query.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void createSavedSearch(String query, SGListener listener) throws IOException {
		Bundle params = new Bundle(1);
		params.putString("query", query);
		this.executeRequest(Verb.POST, twitterUrl + "/saved_searches/create.json", params, null, listener);
	}
		
	/**
	 * Delete a saved search.
	 * 
	 * @param id A String id of the saved search query.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void deleteSavedSearch(String id, SGListener listener) throws IOException {
		this.executeRequest(Verb.DELETE, String.format(Locale.US, twitterUrl + "/saved_searches/destroy/%s.json", URLEncoder.encode(id, "UTF-8")), null, null, listener);
	}
	
	// Search endpoints
	
	/**
	 * Returns tweets that match a specified query.
	 * 
	 * @param q A String search query.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/search">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void search(String q, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("q", q);
		this.executeRequest(Verb.GET, twitterUrl + "/search.json", params, null, listener);
	}

	// Spam Reporting endpoints
	
	/**
	 * Report spam and block the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/report_spam">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void reportSpam(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, twitterUrl + "/report_spam.json", params, null, listener);
	}
	
	/**
	 * Report spam and block the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void reportSpam(User user, SGListener listener) throws IOException {
		Bundle params = new Bundle(1);
		params = user.appendToBundle(params);
		reportSpam(params, listener);
	}
	
	// Timeline endpoints
	
	/**
	 * Returns the most recent statuses posted by the authenticated user and the people they follow.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/home_timeline">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getTimeline(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/home_timeline.json", params, null, listener);
	}
	
	/**
	 * Get the authenticated user's most recent mentions.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/mentions">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getMentions(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/mentions.json", params, null, listener);
	}
		
	/**
	 * Returns the most recent public statuses.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/public_timeline">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getPublicStatuses(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/public_timeline.json", params, null, listener);
	}
	
	/**
	 * Returns the most recent retweets by the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_by_me">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetedByMe(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweeted_by_me.json", params, null, listener);
	}
	
	/**
	 * Returns the most recent retweets by the people the authenticated user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_me">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetedToMe(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweeted_to_me.json", params, null, listener);
	}
	
	/**
	 * Returns the most recent retweets of the authenticated user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweets_of_me">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetsOfMe(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweets_of_me.json", params, null, listener);
	}
	
	/**
	 * Returns the most recent tweets of the authenticated user or the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/user_timeline">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getUserStatuses(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/user_timeline.json", params, null, listener);
	}
		
	/**
	 * Returns the most recent tweets of the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/user_timeline">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getUserStatuses(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		getUserStatuses(params, listener);
	}
	
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_user">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetedToUser(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweeted_to_user.json", params, null, listener);
	}
		
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweeted_to_user">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetedToUser(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		getRetweetedToUser(params, listener);
	}
		
	/**
	 * Returns the most recent retweets by the people the specified user follows.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/get/statuses/retweeted_by_user">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetedByUser(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/statuses/retweeted_by_user.json", params, null, listener);
	}
		
	/**
	 * Returns the most recent retweets by the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/get/statuses/retweeted_by_user">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetedByUser(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 0);
		params = user.appendToBundle(params);
		getRetweetedByUser(params, listener);
	}
	
	// Trends & Local Trends endpoints
	
	/**
	 * Returns the top 10 trending topics for the given @see <a href="http://developer.yahoo.com/geo/geoplanet/guide/concepts.html">Yahoo! Where On Earth Id</a>.
	 * 
	 * @param whereOnEarthId A String Yahoo where on earth id.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getLocalTrends(String whereOnEarthId, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/trends/%s.json", URLEncoder.encode(whereOnEarthId, "UTF-8")), null, null, listener);
	}
	
	/**
	 * Returns the locations that Twitter has trending topic information for.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/available">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getAvailableTrendLocations(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/trends/available.json", params, null, listener);
	}
		
	/**
	 * Returns the top 10 current trending topics on Twitter.
	 * 
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getTrends(SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/trends.json", null, null, listener);
	}
	
	/**
	 * Returns the top 10 current trending topics on Twitter.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getCurrentTrends(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/trends/current.json", params, null, listener);
	}
	
	/**
	 * Returns the top 20 trending topics for each hour in a given day.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getDailyTrends(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/trends/daily.json", params, null, listener);
	}
	
	/**
	 * Returns the top 30 trending topics for each day in a given week.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/trends/current">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getWeeklyTrends(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/trends/weekly.json", params, null, listener);
	}
	
	// Tweet endpoints
	
	/**
	 * Show user objects of up to 100 members who retweeted the status.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/%3Aid/retweeted_by">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetedBy(String id, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/statuses/%s/retweeted_by.json", URLEncoder.encode(id, "UTF-8")), params, null, listener);
	}
	
	/**
	 * Show user ids of up to 100 users who retweeted the status.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/%3Aid/retweeted_by/ids">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweetedByIds(String id, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/statuses/%s/retweeted_by/ids.json", URLEncoder.encode(id, "UTF-8")), params, null, listener);
	}
	
	/**
	 * Returns up to 100 of the first retweets of a given tweet.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/retweets/%3Aid">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getRetweets(String id, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/statuses/retweets/%s.json", URLEncoder.encode(id, "UTF-8")), params, null, listener);
	}
	
	/**
	 * Returns a single status, specified by the id parameter below.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/statuses/show/%3Aid">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getTweet(String id, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/statuses/show/%s.json", URLEncoder.encode(id, "UTF-8")), params, null, listener);
	}
	
	/**
	 * Delete a tweet made by the authenticated user.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/destroy/%3Aid">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void deleteTweet(String id, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.DELETE, String.format(Locale.US, twitterUrl + "/statuses/destroy/%s.json", URLEncoder.encode(id, "UTF-8")), params, null, listener);
	}
	
	/**
	 * Retweet.
	 * 
	 * @param id A String tweet id.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/retweet/%3Aid">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void retweet(String id, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.POST, String.format(Locale.US, twitterUrl + "/statuses/retweet/%s.json", URLEncoder.encode(id, "UTF-8")), params, null, listener);
	}
		
	/**
	 * Tweet.
	 * 
	 * @param status A String status.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/post/statuses/retweet/%3Aid">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void tweet(String status, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("status", status);
		this.executeRequest(Verb.POST, twitterUrl + "/statuses/update.json", params, null, listener);
	}
	
	// User endpoints
	
	/**
	 * up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/lookup">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void lookupUsers(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/users/lookup.json", params, null, listener);
	}
	
	/**
	 * up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two.
	 * 
	 * @param users {@link UserCollection}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/lookup">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void lookupUsers(UserCollection users, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 2);
		params = users.appendToBundle(params);
		lookupUsers(params, listener);
	}
	
	/**
	 * Access the profile image in various sizes for the user with the indicated screen_name.
	 * 
	 * @param screenName A String Twitter screen name.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/profile_image/%3Ascreen_name">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getProfileImage(String screenName, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/users/profile_image/%s.json", URLEncoder.encode(screenName, "UTF-8")), params, null, listener);
	}
	
	/**
	 * Search Twitter users with the given query.
	 * 
	 * @param q A String search query.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void searchUsers(String q, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params.putString("q", q);
		this.executeRequest(Verb.GET, twitterUrl + "/users/search.json", params, null, listener);
	}
		
	/**
	 * the specified user.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getUser(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/users/show.json", params, null, listener);
	}
	
	/**
	 * the specified user.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/search">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getUser(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getUser(params, listener);
	}
	
	/**
	 * Returns an array of users that the specified user can contribute to.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributees">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getContributees(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/users/contributees.json", params, null, listener);
	}
	
	/**
	 * Returns an array of users that the specified user can contribute to.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributees">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getContributees(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getContributees(params, listener);
	}
	
	/**
	 * Returns an array of users who can contribute to the specified account.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributors">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getContributors(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/users/contributors.json", params, null, listener);
	}
	
	/**
	 * Returns an array of users who can contribute to the specified account.
	 * 
	 * @param user A {@link User}.
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/contributors">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getContributors(User user, Bundle params, SGListener listener) throws IOException {
		params = Util.initBundle(params, 1);
		params = user.appendToBundle(params);
		getContributors(params, listener);
	}
	
	/**
	 * Returns Twitter's suggested user list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSuggestedUsers(Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, twitterUrl + "/users/suggestions.json", params, null, listener);
	}
	
	/**
	 * Returns Twitter's suggested user list.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions/%3Aslug">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSuggestedUsers(String slug, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/users/suggestions/%s.json", URLEncoder.encode(slug, "UTF-8")), params, null, listener);
	}
		
	/**
	 * the users in a given category of the Twitter suggested user list and their most recent status.
	 * 
	 * @param params A {@link Bundle} containing optional keys listed @see <a href="https://dev.twitter.com/docs/api/1/get/users/suggestions/%3Aslug/members">here</a>.
	 * @param listener {@link SGListener}
	 * @throws IOException 
	 */
	public void getSuggestedUsersWithStatus(String slug, Bundle params, SGListener listener) throws IOException {
		this.executeRequest(Verb.GET, String.format(Locale.US, twitterUrl + "/users/suggestions/%s/members.json", URLEncoder.encode(slug, "UTF-8")), params, null, listener);
	}

	@Override
	public String getAuthorizationUrl(Bundle params) {
		return String.format(Locale.US, authorizationUrl, ((Token) params.getSerializable("token")).getToken());
	}
	
}
