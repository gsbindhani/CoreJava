package com.coreJava.thread.countDownLatchEx;

import java.util.concurrent.CountDownLatch;

public class CacheService implements Runnable {

	CountDownLatch countDownLatch;
	public CacheService(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " -Completion of work, Thread inprogress- "+countDownLatch.getCount());
		countDownLatch.countDown();
	}

}
