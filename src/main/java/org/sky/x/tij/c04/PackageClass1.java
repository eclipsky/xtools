package org.sky.x.tij.c04;

public class PackageClass1 {
	
	public int a;
	
	protected int b;
	
	int c;
	
	private int d;
	
	public PackageClass1(){
		System.out.println("I waw born");
	}
	
	PackageClass1(String str){
		System.out.println("I waw born at :"+str);
	}
	
	public void publicMethod(){
		System.out.println("publicMethod()");
	}
	
	protected void protectedMethod(){
		System.out.println("protectedMethod()");
	}
	
	void friendMethod(){
		System.out.println("friendMethod()");
	}
	
	private void privateMethod(){
		System.out.println("privateMethod()");
	}
}
