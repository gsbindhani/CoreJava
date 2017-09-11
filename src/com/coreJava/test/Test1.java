package com.coreJava.test;

public class Test1{
	public static void main(String[] args) {
		A a = new A();
		A c = new C();
		a.callA();
		c.callC();
		c.callB();
	}
}
class A{
	private final void callA(){
		System.out.println("Method A");
	}
	public void callB(){
		System.out.println("Method AB");
	}
	public void callC(){
		System.out.println("Method AC");
	}
}
class B extends A{
	private void callA(){
		System.out.println("Method BA");
	}
	public void callB(){
		System.out.println("Method B");
	}
	public void callC(){
		System.out.println("Method BC");
	}
}
class C extends B{
	public void callA(){
		System.out.println("Method CA");
	}
	public void callB(){
		System.out.println("Method CB");
	}
	public void callC(){
		System.out.println("Method C");
	}
	
}






