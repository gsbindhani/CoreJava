package com.coreJava;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		swapNumbers();
	}
	

	public static void swapNumbers(){
		int a = 1;
		int b = 2;
		System.out.println("Before swaping a ="+a+ " b ="+b);
		//With 3rd variable
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println("After swaping a ="+a+ " b ="+b);
		
		//Without third variable
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("After swaping a ="+a+ " b ="+b);
		
	}

}
