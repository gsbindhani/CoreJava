package com.coreJava;

public class PrintTriangle {

	public static void main(String[] args) {
		//printRightAngle(50);
		//swapNumbers();
	}
	
	public static void printRightAngle(int numberOfLines){
		
		for (int i = 1; i < numberOfLines; i++) {
			for(int j = 1; j<=i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

}
