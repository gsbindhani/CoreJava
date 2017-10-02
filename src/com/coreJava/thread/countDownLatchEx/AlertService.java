package com.coreJava.thread.countDownLatchEx;

import java.util.concurrent.CountDownLatch;

public class AlertService implements Runnable {

	CountDownLatch countDownLatch;
	public AlertService(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " -Completion of work, Thread inprogress-  "+countDownLatch.getCount());
		countDownLatch.countDown();
	}

}
