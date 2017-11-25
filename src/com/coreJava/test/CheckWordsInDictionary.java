package com.coreJava.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class GFG {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = Integer.parseInt(scanner.next()); //Number of test cases
            for (int t = 0; t < testCases; t++) {
            	
            	//Every test cases has 3 line
                Set<String> dict = new HashSet<>();
                int n = Integer.parseInt(scanner.next()); //1st line - Number of words in the dictionary
                for (int i = 0; i < n; i++)
                    dict.add(scanner.next()); //2nd line words of dictionary
                
                String s = scanner.next(); //String to check in the dictionary
                int[] dp = new int[s.length() + 1];
                dp[0] = 1;
                for (int i = 1; i <= s.length(); i++) {
                    if (dp[i - 1] == 1) {
                        for (int j = i; j <= s.length(); j++) {
                            if (dict.contains(s.substring(i - 1, j))) {
                                dp[j] = 1;
                            }
                        }
                    }
                }
                System.out.println(dp[s.length()]);
            }
        }
    }
}