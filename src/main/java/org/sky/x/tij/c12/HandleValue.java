package org.sky.x.tij.c12;

class A{
	int i;
	void f(int j){
		i = j;
		j++;
	}
}

public class HandleValue {
	public static void main(String[] args){
		int param = 10;
		A a = new A();
		a.f(param);
		System.out.println(a.i);
		System.out.println(param);
	}
}
