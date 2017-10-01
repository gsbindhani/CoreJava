package com.coreJava.utils;

import java.util.Arrays;

public class ArrayUtils {

	/**
	 * 
	 * @param arrayName
	 * @param 2DArray
	 * @param skipZeros
	 */
	public static void print2dArray(String arrayName ,int[][] arr,boolean skipZeros){
		System.out.println(arrayName+" Array:");
		for (int row = 0; row < arr.length; row++) {
			for (int  column= 0; column < arr[row].length; column++) {
				if(skipZeros && arr[row][column] == 0)
					continue;
				System.out.print(arr[row][column]+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @param arrayName
	 * @param arr
	 * @param skipZeros
	 * @param removeElements
	 */
	public static void removeAndPrintResult(String arrayName ,int[] arr,boolean skipZeros,int[] removeElements){
		
		System.out.println(arrayName+" Array:"+Arrays.toString(removeElements));
		for (int row = arr.length-1; row > 0;  row--) {
			if(removeElements != null && removeElements.length > 0 ){
				for (int index = 0; index < removeElements.length; index++) {
					if(index == row)
						arr[row] = -1;
				}
			}
			if((skipZeros && arr[row] == 0) || arr[row] == -1)
				continue;
			System.out.print(arr[row]);
		}
		System.out.println();
	}
}
