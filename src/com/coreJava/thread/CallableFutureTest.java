package com.coreJava.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
 * There are two ways of creating threads – one by extending the Thread class and other by creating a thread with a Runnable.
 *  However, one feature lacking in  Runnable is that we cannot make a thread return result when it terminates, i.e. when run() completes.
 *  For supporting this feature, the Callable interface is present in Java.
 */
public class CallableFutureTest {
	public static void main(String[] args) {
		
		List<Future<Integer>> listOfFuturetask = new ArrayList<>();
		
		for(int i=0;i<=5;i++){
			Callable<Integer> callableExample = new CallableExample();
			listOfFuturetask.add(new FutureTask<Integer>(callableExample));
			
			Thread th = new Thread((FutureTask<Integer>)listOfFuturetask.get(i));
			th.start();
			
		}
		
		listOfFuturetask.stream().forEach(fTask -> {
			try {
				System.out.println(fTask.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}

class CallableExample implements Callable<Integer>{
	
	
	@Override
	public Integer call() throws Exception{
		return new Random().nextInt(5);
	}
	
}
