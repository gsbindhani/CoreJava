package com.coreJava.thread;

public class YieldEx {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" Started with priority-"+Thread.currentThread().getPriority());
		
		Thread childThread = new Thread(new ChildThread(),"Child Thread");
		childThread.setPriority(10);
		childThread.start();
		
		for(int i = 0; i < 5 ; i++){
			
			System.out.println("Pass the control to child thread"); 
			Thread.yield();
			
			System.out.println(Thread.currentThread().getName()+" in Control"); 
		}
		
			
	}
}


class ChildThread implements Runnable{
	
	public void run(){
		for(int i = 0; i < 5 ; i++)
			System.out.println(Thread.currentThread().getName() +" Started with priority-"+Thread.currentThread().getPriority());
	}
}
