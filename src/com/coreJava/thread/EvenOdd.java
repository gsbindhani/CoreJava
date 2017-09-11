package com.coreJava.thread;


public class EvenOdd implements Runnable {
	private static int count = 10;

	public static void main(String[] args) throws InterruptedException {
		EvenOdd obj = new EvenOdd();
		Thread even = new Thread(obj, "Even");
		Thread odd = new Thread(obj, "Odd");
		even.start();
		even.join();
		odd.start();
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for (int i = 0; i <= count; i++) {
			if (name.equals("Even")) {
				if (i % 2 == 0){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(name + " - " + i);
				}
			} else {
				if (i % 2 != 0){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(name + " - " + i);
					}
			}
		}
	}
}