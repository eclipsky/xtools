package org.sky.x;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		String a = "abc";
		int m = 6;
		System.out.println(15&m);
	}
	
	public static void bubbleSort(String a){
		System.out.println("a："+a.hashCode()+"："+a);
		String b = a;
		System.out.println("b："+b.hashCode()+"："+b);
		b = "def";
		System.out.println("b："+b.hashCode()+"："+b);
	}

}
