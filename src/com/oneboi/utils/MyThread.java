package com.oneboi.utils;

public class MyThread  extends ThreadTest{

	public MyThread(){
//		super();
		System.out.println(" i am children");
	}
	
	public void hello(){
		
		super.run();
		ThreadTest.say();
	}
	
	public static void main(String[] args) {
		
		new MyThread().hello();
	
	}
	
}
