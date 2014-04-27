package org.sky.x.tij.c04;

class Mug{
	Mug(int i){
		System.out.println("Mug("+i+")");
	}
	void f(int i){
		System.out.println("f("+i+")");
	}
}
public class Mugs {
	Mug m1;
	Mug m2;
	{
		m1 = new Mug(1);
		m2 = new Mug(2);
		System.out.println("m1 & m2 initialized !");
	}
	
	Mugs(){
		System.out.println("Mugs()");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside Main()");
		Mugs x = new Mugs();
	}

}
