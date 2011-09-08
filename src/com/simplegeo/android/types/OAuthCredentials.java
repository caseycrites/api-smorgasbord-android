package com.simplegeo.android.types;

import android.os.Parcel;
import android.os.Parcelable;


public class OAuthCredentials implements Parcelable {
	public static final String TAG = "OAuthConfig";

	private String accessToken;
	private String accessSecret;
	private String consumerKey;
	private String consumerSecret;

	public OAuthCredentials(String accessToken) {
		this(accessToken, null, null, null);
	}
	
	public OAuthCredentials(String consumerKey, String consumerSecret) {
		this(null, null, consumerKey, consumerSecret);
	}
	
	public OAuthCredentials(String accessToken, String accessSecret, String consumerKey, String consumerSecret) {
		this.accessToken = accessToken;
		this.accessSecret = accessSecret;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}

	private OAuthCredentials(Parcel in) {
		readFromParcel(in);
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessSecret() {
		return accessSecret;
	}

	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}
	
	// Parcelable interface

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(accessToken);
		dest.writeString(accessSecret);
		dest.writeString(consumerKey);
		dest.writeString(consumerSecret);
	}
	
	private void readFromParcel(Parcel in) {
		accessToken = in.readString();
		accessSecret = in.readString();
		consumerKey = in.readString();
		consumerSecret = in.readString();
	}
	
	public static final Parcelable.Creator<OAuthCredentials> CREATOR = new Parcelable.Creator<OAuthCredentials>() {
		public OAuthCredentials createFromParcel(Parcel in) {
			return new OAuthCredentials(in);
		}
		
		public OAuthCredentials[] newArray(int size) {
			throw new UnsupportedOperationException();
		}
	};

}
