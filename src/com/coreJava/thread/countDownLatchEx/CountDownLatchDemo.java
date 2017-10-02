package com.coreJava.thread.countDownLatchEx;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author Milu
 * 
 * Use CountDownLatch when one of Thread like main thread, require to wait for one or more thread to complete, 
 * before its start doing processing. Classical example of using CountDownLatch in Java  is any server side core Java application which uses services architecture,
 * where multiple services is provided by multiple threads and application can not start processing  until all services have started successfully as shown.
 *
 */
public class CountDownLatchDemo {

	public static void main(String[] args) {
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		Thread cacheService = new Thread(new CacheService(countDownLatch),"CacheService");
		Thread alertService = new Thread(new AlertService(countDownLatch),"AlertService");
		Thread validationService = new Thread(new ValidationService(countDownLatch),"ValidationService");

		cacheService.start();
		alertService.start();
		validationService.start();
		
		try {
			System.out.println("Registered services "+countDownLatch.getCount());
			countDownLatch.await();
			
			System.out.println("All services are up, Application is starting now");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
