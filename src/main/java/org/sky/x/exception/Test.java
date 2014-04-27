package org.sky.x.exception;

abstract class Parent{
	
	public abstract void read(int i);
	
	static void getName(){
		System.out.println("I'm OK");
	}
}

public class Test{
	static final int i = 1 ;
	
	public static void main(String[] args){
//		Parent.getName();
		Test t = new Test();
		System.out.println(t.i);
		System.out.println(Test.i);
		double i = Math.pow(10, 3);
		print(i);
	}
	
	public static void print(Object o){
		System.out.println(o);
	}
}

