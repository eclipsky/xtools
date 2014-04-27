package org.sky.x.tij.c03;

class Letter{
	char c;
}

public class PassObject {
	static void f(Letter f){
		f.c = 'z';
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Letter m = new Letter();
		m.c = 'a';
		System.out.println(m.c);
		f(m);
		System.out.println(m.c);
	}

}
