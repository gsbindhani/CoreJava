package com.coreJava.dataStructure;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args){
		int[] arr = {8,6,2,4,1,9,10};
		bubbleSort(arr);
	}
	
	public static void bubbleSort(int[] arr){
		for(int i=0; i< arr.length;i++){
			System.out.println(arr[i]);
			for(int j=0;j < arr.length ; j++){
				if(arr[i] < arr[j]){ // Ascending order  <   and Descending order >
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}


