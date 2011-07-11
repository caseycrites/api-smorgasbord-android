package com.simplegeo.android.client;

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
	 * Sets the users account settings.
	 * 
	 * @param params A {@link Bundle} containing optional keys trend_location_woeid, sleep_time_enabled, start_sleep_time, end_sleep_time, time_zone, lang.
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
	 * @param params A {@link Bundle} containing optional key include_entities.
	 * @param callback
	 */
	public void updateDeliveryDevice(String device, Bundle params, SmorgasbordCallback callback) {
		// HttpPost
	}
	
	/**
	 * Update the user's profile.
	 * 
	 * @param params A {@link Bundle} containing optional keys name, url, location, description, include_entities, skip_status.
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
	 * Enable tweet entities, which will include a node called entities with each tweet that involves metadata about the tweet.
	 * 
	 * @param callback {@link SmorgasbordCallback}.
	 */
	public void enableTweetEntities(SmorgasbordCallback callback) {
		Bundle tweetEntitiesBundle = new Bundle(1);
		tweetEntitiesBundle.putBoolean("include_entities", true);
		updateProfile(tweetEntitiesBundle, callback);
	}
		
	/**
	 * Disable tweet entities.
	 * 
	 * @param callback {@link SmorgasbordCallback}.
	 */
	public void disableTweetEntities(SmorgasbordCallback callback) {
		Bundle tweetEntitiesBundle = new Bundle(1);
		tweetEntitiesBundle.putBoolean("include_entities", false);
		updateProfile(tweetEntitiesBundle, callback);
	}
		
	/**
	 * Enable skip status, which will remove statuses from returned user objects.
	 * 
	 * @param callback {@link SmorgasbordCallback}.
	 */
	public void enableSkipStatus(SmorgasbordCallback callback) {
		Bundle statusBundle = new Bundle(1);
		statusBundle.putBoolean("skip_status", true);
		updateProfile(statusBundle, callback);
	}
		
	/**
	 * Disable skip status.
	 * 
	 * @param callback {@link SmorgasbordCallback}.
	 */
	public void disableSkipStatus(SmorgasbordCallback callback) {
		Bundle statusBundle = new Bundle(1);
		statusBundle.putBoolean("skip_status", false);
		updateProfile(statusBundle, callback);
	}
	
	// Block endpoints
	
	// Timeline endpoints
	
	// Tweet endpoints
	
	// User endpoints
	
	// Trends endpoints
	
	// Local Trends endpoints
	
	// List endpoints
	
	// List Member endpoints
	
	// List Subscriber endpoints
	
	// Direct Message endpoints
	
	// Friendship endpoints
	
	// Friend And Follower endpoints
	
	// Favorites endpoints
	
	// Notification endpoints
	
	// Spam Reporting endpoints
	
	// Saved Searches endpoints
	
	// OAuth endpoints
	
	// Geo endpoints
	
	// Legal endpoints
	
	// Help endpoints
	
	// Search endpoints

}
