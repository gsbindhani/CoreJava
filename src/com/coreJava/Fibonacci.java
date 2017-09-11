package com.coreJava;
import java.util.Map;
import java.util.HashMap;
public class Fibonacci {

	static Map<Long,Long> memoization = new HashMap<Long,Long>();
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (long i = 0; i <45 ;i++) {
//			System.out.print(recursiveWithMemoizationfib(i)+",");
			//System.out.print(recursiveWithoutMemoizationfib(i)+",");
		}
		fibonacciNumber();
		System.out.println("");
		System.out.println("Total time taken - "+(System.currentTimeMillis() - startTime));
	}
	
	public static long recursiveWithMemoizationfib(long i){
		if(i == 0)
			return 0;
		if(i == 1)
			return 1;
		
		if(memoization.containsKey(i))
			return memoization.get(i);
		else{
			long temp = recursiveWithMemoizationfib(i-1)+recursiveWithMemoizationfib(i-2);
			memoization.put(i, temp);
			return temp;
		}
	}
	
	public static long recursiveWithoutMemoizationfib(long i){
		if(i == 0)
			return 0;
		if(i == 1)
			return 1;
		
		return recursiveWithoutMemoizationfib(i-1)+recursiveWithoutMemoizationfib(i-2);
	}
	
	public static void fibonacciNumber(){
		int n1 = 0, n2 = 1,n3;
		System.out.print(n1+","+n2+",");//
		for(int i = 2;i<= 10;i++){
			n3 = n1+n2;
			System.out.print(n3+",");
			n1 = n2;
			n2 = n3;
		}
			
	}
}
