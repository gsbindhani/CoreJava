package com.coreJava;

import com.coreJava.utils.ArrayUtils;

public class ArrayMultiplication {
	//First array of Row length must be equal to second array of Column length
	/*
	 * [3][2] X [2][3]	  = [3][3]	
	 * 
	 * 00 01     00 01 02   [00*00 + 01*10] [00*01 + 01*11] [00*02 + 01*11]
	 * 10 11  X  10 11 03 = [10*00 + 11*10] [10*01 + 11*11] [10*02 + 11*11]
	 * 20 21     			[20*00 + 21*10] [20*01 + 21*11] [20*02 + 21*11]
	 * 
	 * */
	public static void main(String[] args) {
		int[][]  firstArr = {{1,2},{3,4},{5,6}}; // 
		int[][]  secondArr = {{1,2,3},{4,5,6}};
		
		int[][] finalArr = new int[firstArr.length][secondArr[0].length];
		
		ArrayUtils.print2dArray("First", firstArr,false);
		ArrayUtils.print2dArray("Second", secondArr,false);
		multiplyArray(firstArr, secondArr, finalArr);
		ArrayUtils.print2dArray("Final", finalArr,false);
		
	}
	
	
	
	private static void multiplyArray(int[][] firstArr, int[][] secondArr, int[][] finalArr){
		for (int r1= 0; r1 < firstArr.length; r1++) {
			for(int c1 = 0 ; c1 < firstArr[r1].length ; c1++){
				for (int c2 = 0; c2 < secondArr[c1].length; c2++) {
					finalArr[r1][c2] += firstArr[r1][c1] * secondArr[c1][c2];
				}
			}
		}
	}
}
