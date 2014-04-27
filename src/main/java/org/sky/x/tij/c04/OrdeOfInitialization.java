package org.sky.x.tij.c04;

class Tag{
	Tag(int a){
		System.out.println("Tag("+a+")");
	}
}

class Mark{
	Tag t2 = new Tag(2);
	
	Mark(){
		System.out.println("Mark()");
		t3 = new Tag(33);
	}
	Tag t1 = new Tag(1);
	void f(){
		System.out.println("f()");
	}
	Tag t3 = new Tag(3);
}

public class OrdeOfInitialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mark m = new Mark();
		m.f();
	}

}
