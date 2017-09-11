package com.coreJava;

import java.util.ArrayList;
import java.util.List;

public class Java8 {

	public static void main(String[] args) {

		
		List<String> li = new ArrayList<String>();
		li.add("a");
		li.add("b");
		li.add("c");
		
		li.forEach(System.out::println);
		li.forEach(i -> System.out.println(i));
		li.forEach((String i) -> System.out.println(i));
	}
}

interface i{
	public abstract void b();
	public default void b(int i){
		
	}
}
