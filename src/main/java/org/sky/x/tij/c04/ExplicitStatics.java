package org.sky.x.tij.c04;

class Cup{
	Cup(int i){
		System.out.println("Cup("+i+")");
	}
	void f(int i){
		System.out.println("f("+i+")");
	}
}

class Cups{
	static Cup c1;
	static{
		c1 = new Cup(1);
		c2 = new Cup(2);
	}
	static Cup c2;
	Cups(){
		System.out.println("Cups()");
	}
}

public class ExplicitStatics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside Main()");
		Cups.c1.f(99);
	}
	static Cups x = new Cups();
	static Cups y = new Cups();
}
