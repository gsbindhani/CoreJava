package com.coreJava.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number");

		int number = sc.nextInt();

		for (int i = 0; i < number; i++) {

			if (i % 5 == 0)
				System.out.println("Buzz");
			else if (i % 3 == 0)
				System.out.println("Fizz");
			else if (i % 3 == 0 && i % 5 == 0)
				System.out.println("fizzbuzz");
			else
				System.out.println(i);

		}

	}
}