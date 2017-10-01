package com.coreJava.dataStructure;

public class LinearSearch {
	public static void main(String[] args) {
		int[] unsortedElements = {1,3,5,2,1,5,6,7,8,9};
		findHighestNumber(unsortedElements);
	}
	
	private static void findHighestNumber(int[] unsortedElements){
	
	if(unsortedElements == null || unsortedElements.length == 0)
		System.out.println("Empty Array");
		
	if(unsortedElements.length >1){
		int max = unsortedElements[0];
		for (int element : unsortedElements) {
			if(element > max) max = element;
			
		}
		System.out.println("HIghest numbe in the array is "+max);
	}else
		System.out.println("HIghest numbe in the array is "+unsortedElements[0]);
		
		
	}

}
