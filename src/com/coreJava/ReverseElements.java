package com.coreJava;

public class ReverseElements {

	public static void main(String[] args) {
//		reverseString("0123456789");
		reverseNumber(12345);
	}
	
	private static void reverseNumber(int i){
		int finalResult = 0;
		while(i > 0){
			finalResult = finalResult*10 + i%10;
			i = i/10;
		}
		System.out.println("finalResult - "+finalResult);
	}
	
	@SuppressWarnings("unused")
	private static void reverseString(String str){
		
		System.out.println("Normal string -"+str);
		char[] ch = str.toCharArray();
		System.out.print("Reversed string -");		
		
		for(int i = ch.length-1; i >= 0 ;i--)	{
			System.out.print(ch[i]);
		}
	}

}
