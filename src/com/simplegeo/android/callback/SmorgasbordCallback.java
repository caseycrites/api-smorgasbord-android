package com.simplegeo.android.callback;

public interface SmorgasbordCallback<E> {
	
	public void onSuccess(E e);
		
	public void onError(String errorMessage);
	
}