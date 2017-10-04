package com.coreJava.thread;
/**
 * 
 * @author Milu
 * 
 * This will create a DeadLock Scenario using the main thread only.
 *
 */
public class DeadLock {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread started");
		System.out.println("Going to join the main thread with itself");
		Thread.sleep(2000);
		Thread.currentThread().join();// The main thread will wait for the main thread to finish which will cause the main thread to lock i.e. dead lock
		
		System.out.println("This line will never execute");
		
	}

}
