package org.sky.x.tij.c06;

//: Beetle.java
//The full process of initialization.
class Insect {
	int i = 9;
	int j;
	int m = prt("Insect.k initialized");
	Insect() {
		prt("i = " + i + ", j = " + j);
		j = 39;
	}
	static{
		System.out.println("Insect static block 1");
	}

	static int x1 = prt("static Insect.x1 initialized");
	static{
		System.out.println("Insect static block 2");
	}
	{
		System.out.println("Insect blank block");
	}
	static int prt(String s) {
		System.out.println(s);
		return 47;
	}
}

public class Beetle extends Insect {
	int k = prt("Beetle.k initialized");

	Beetle() {
		prt("k = " + k);
		prt("j = " + j);
	}

	static int x2 = prt("static Beetle.x2 initialized");
	static{
		System.out.println("Beetle static block");
	}
	{
		System.out.println("Beetle blank block");
	}
	static int prt(String s) {
		System.out.println(s);
		return 63;
	}

	public static void main(String[] args) {
		prt("Beetle constructor");
		Beetle b = new Beetle();
	}
} // /:~