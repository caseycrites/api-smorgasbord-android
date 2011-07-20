package com.simplegeo.android.test;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import junit.framework.TestCase;
import android.test.AndroidTestCase;

import com.simplegeo.android.callback.SGCallback;
import com.simplegeo.android.client.Twitter;

public class TwitterTest extends AndroidTestCase {

	Twitter twitter;
	
	public void setUp() {
		this.setUpClient();
	}
	
	private void setUpClient() {
		twitter = new Twitter("bCfHdQQJaWImuvvugs4Bmw", "M4dC9rQWZvsfbWxNZ5zsvqrCPtqhl54BVtgkOQJ8");
		twitter.config.setAccessSecret("vkA6d0BTp1Qb7QJFMYtOgWMYXoU86AUOPVBd3JXQ");
		twitter.config.setAccessToken("334357581-QBwndjRc57LvaGvuhybwkdhHMoKUaYMgb3jL2CHk");
	}
	
	public void testTweet() {
		final CyclicBarrier barrier = new CyclicBarrier(2);	
		try {
			twitter.tweet("Oh heyyyyyyy.", null, new SGCallback() {

				@Override
				public void onSuccess(Object e) {
					System.out.println("Heyyyyy");
					barrierAwait(barrier);
				}

				@Override
				public void onError(Object e) {
					TestCase.fail("Boooo");
				}
				
			});
			barrierAwait(barrier);
		} catch (IOException e) {
			TestCase.fail(e.getMessage());
		}
	}
	
	final private void barrierAwait(CyclicBarrier barrier) {
		try {
			barrier.await();
		} catch (InterruptedException e) {
			TestCase.fail(e.getMessage());
		} catch (BrokenBarrierException e) {
			TestCase.fail(e.getMessage());
		}
	}
	
 }
