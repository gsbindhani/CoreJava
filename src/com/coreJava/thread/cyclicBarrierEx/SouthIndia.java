package com.coreJava.thread.cyclicBarrierEx;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SouthIndia implements Runnable {

	private CyclicBarrier barrier;
	public SouthIndia(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
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
