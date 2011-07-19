package com.simplegeo.android.callback;

public interface SGCallback<E> {
	
	public void onSuccess(E e);
		
	public void onError(E e);
	
}