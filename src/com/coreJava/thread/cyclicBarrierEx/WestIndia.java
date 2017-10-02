package com.coreJava.thread.cyclicBarrierEx;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WestIndia implements Runnable{

	private CyclicBarrier barrier;
	public WestIndia(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(4000);
			System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
