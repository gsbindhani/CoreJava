package com.coreJava.algorithm;

import com.coreJava.utils.ArrayUtils;

/*
  	1  
	1 1 
	1 2 1 
	1 3 3 1 
	1 4 6 4 1 
	1 5 10 10 5 1 
*/

public class PascalsTriangel {
	public static void main(String[] args) {
		ArrayUtils.print2dArray("PascalsArr",preparePascalsTriangel(5),true);
	}

	private static int[][] preparePascalsTriangel(int n){
		
		if(n == 0)
			return null;
		
		int[][] arr = new int[n][n];
		
		for (int lineNo = 0; lineNo < n; lineNo++) {
			for (int i = 0; i <= lineNo; i++) {
				if(lineNo == i || i == 0)
					arr[lineNo][i] = 1;
				else
					arr[lineNo][i] = arr[lineNo-1][i-1] + arr[lineNo-1][i];
			}
		}
		return arr;
		
	}
}
