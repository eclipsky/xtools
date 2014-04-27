package org.sky.x.tij.c04;

class Bowl{
	Bowl(int i){
		System.out.println("Bowl("+i+")");
	}
	void f(int i){
		System.out.println("f("+i+")");
	}
}

class Table{
	Bowl b1 = new Bowl(1);
	Table(){
		System.out.println("Table()");
		b2.f(1);
	}
	void f2(int i){
		System.out.println("f2("+i+")");
	}
	static Bowl b2 = new Bowl(2);
}

class Cupboard{
	Bowl b3 = new Bowl(3);
	static Bowl b4 = new Bowl(4);
	Cupboard(){
		System.out.println("Cupboard()");
		b4.f(2);
	}
	void f3(int i){
		System.out.println("f3("+i+")");
	}
	static Bowl b5 = new Bowl(5);
}

public class StaticInitialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		t2.f2(1);
		t3.f3(1);
	}
	static Table t2 = new Table();
	static Cupboard t3 = new Cupboard();
}

