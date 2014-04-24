package org.sky.x;

public class Singleton {
	
	public static Singleton singleton = new Singleton();
	public static int a;
	public static int b = 0;

	private Singleton() {
		super();
		a++;
		b++;
	}

	public static Singleton GetInstence() {
		return singleton;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Singleton mysingleton = Singleton.GetInstence();
		System.out.println(mysingleton.a);
//		System.out.println(mysingleton.b);
	}

}
