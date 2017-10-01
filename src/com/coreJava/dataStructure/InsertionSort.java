package com.coreJava.dataStructure;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] numbers = new int[]{9,8,1,7,6,5,4,3,2,1};
		Arrays.fill(numbers, 1);
		System.out.println(Arrays.toString(numbers));
		sortArray(numbers);
		
		
	}
	
	private static void sortArray(int numbers[]){
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < i; j++) {
				if(numbers[j] > numbers[i]){
					int temp = numbers[j];
					numbers[j]=numbers[i];
					numbers[i]= temp;
				}
			}
			
		}
		
		System.out.println(Arrays.toString(numbers));
		
	}

}
