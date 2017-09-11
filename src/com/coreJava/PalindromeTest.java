package com.coreJava;

public class PalindromeTest {

	public static void main(String[] args) {
		String str = "13331";
		System.out.println("Is palindrome - "+isPalindrome(str));
	}
	
	public static boolean isPalindrome(String str){
		
		int mid = str.length()/2;
		int length = str.length();
		
		for(int i = 0; i <= mid ; i++){
			if(str.charAt(i) != str.charAt(length - i - 1))
				return false;
		}
		return true;
		
	}

}
