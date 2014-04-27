package org.sky.x.tij.c01;

/**
 * @author Administrator
 *
 */
public class Hello {
	public int i=0;
	static void staticMethod(){
		System.out.println("staticMethod");
	}
	void memberMethod(){
		staticMethod();
		System.out.println("memberMethod");
	}
	
	Hello obj(){
		return this;
	}
	
	public static void main(String[] args) throws InterruptedException{
		int i=1;
		long start = System.currentTimeMillis();
		System.out.println(start);
		System.out.println("inner:"+i);
		System.out.println("Hello World");
		staticMethod();
		System.out.println("-----------");
		new Hello().memberMethod();
		Thread.currentThread().sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println(start-end);
		
	}
// 	System.out.println("outer:"+i);//此处会导致多重定义
}
