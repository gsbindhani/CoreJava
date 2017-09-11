package com.coreJava.dataStructure;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		System.out.println("Number present in "+binarySearch(arr, 6)+" postion");
		System.out.println("Number present in "+binarySearch(arr, 0, arr.length-1, 6)+" postion");
	}
	
	private static int binarySearch(int[] arr,int number){
		
		int left = 0, right = arr.length -1;
		
		while(left <= right){
			int mid = (left+right)/2;
			
			if(arr[mid] == number)
				return mid;
			
			if(number > arr[mid])
				left = mid +1;
			else
				right = mid -1;
		}
		return -1;
	}
	
	private static int binarySearch(int[] arr,int left, int right, int number){
		
		if (right>= left)
        {
            int mid = left + (right - left)/2;
 
            // If the element is present at the middle itself
            if (arr[mid] == number)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > number)
               return binarySearch(arr, left, mid-1, number);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, right, number);
        }

		return -1;
	}
	
}
