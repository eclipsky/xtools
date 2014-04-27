package org.sky.x.tij.c04;

public class Flower {

	private int size=0;
	
	private String color="null";
	
	
	Flower(int s){
		size = s;
		System.out.println("Flower(int):"+size);
	}
	
	Flower(String c){
		color = c;
		System.out.println("Flower(String):"+color);
	}
	
	Flower(int s,String c){
		this(s);
//		this("yellow");
	}
	
	void printInfo(){
//		this(1);//普通方法内部无法调用构造方法
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flower f = new Flower(3);
		
	}

}
