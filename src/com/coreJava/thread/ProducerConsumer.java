package com.coreJava.thread;

import java.util.LinkedList;

public class ProducerConsumer {

	static ProducerConsumerHelper producerConsumerHelper = new ProducerConsumerHelper();
	public static void main(String[] args) {
		
		//runJava7();
		runJava8();
	}
	
	public static void runJava8(){
		Thread th1 = new Thread(() -> {
			try {
				producerConsumerHelper.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread th2 = new Thread(() -> {
				try {
					producerConsumerHelper.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});
		
		th1.start();
		th2.start();
	}
	public static void runJava7(){
		
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producerConsumerHelper.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producerConsumerHelper.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		th1.start();
		th2.start();
	}
}

class ProducerConsumerHelper{
	LinkedList<String> records = new LinkedList<>();
	public void producer() throws InterruptedException{
		int count = 1;
		while(true){
			synchronized (this) {
				while(records.size() >= 5){
					this.wait();
				}
				System.out.println("Records inserted -"+count);
				records.add("rec-"+count++);
				this.notify();
				Thread.sleep(1000);
			}
			
		}
	}
	
	public void consumer() throws InterruptedException{
		while(true){
			synchronized (this) {
				while(records.isEmpty()){
					this.wait();
				}
				System.out.println("Records removed -"+records.getFirst());
				records.removeFirst();
				this.notify();
				Thread.sleep(1000);
			}
		}
	}
}