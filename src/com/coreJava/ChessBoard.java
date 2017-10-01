package com.coreJava;

import java.util.Arrays;

public class ChessBoard {
	public static void main(String[] args) {
		String[][] arr = new String[10][10];
		
		Arrays.fill(arr,"White");
		prepareChessBoard(arr);	
		printrArray("Chess Board", arr);
	}

	private static void prepareChessBoard(String[][] arr){
		String deafultColor = "White";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(j % 2 != 0){
					arr[i][j] = deafultColor;
				}else if(deafultColor.equals("White")){
					arr[i][j] = "Black";
				}
			}
			deafultColor = deafultColor.equals("White")? "Black" :"White";
		}
	}
	private static void printrArray(String arrayName ,String[][] arr){
		System.out.println(arrayName+" Array:");
		for (int row = 0; row < arr.length; row++) {
			for (int  column= 0; column < arr[row].length; column++) {
				System.out.print(arr[row][column]+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
