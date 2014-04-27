package org.sky.x.tij.c06;

class Art{
	Art(){
		System.out.println("1:Art constructor");
	}
}

class Drawing extends Art{

//	Drawing(){
//		System.out.println("2:Drawing constructor");
//	}
	Drawing(int i){
		System.out.println("2:Drawing constructor:"+i);
	}
}

public class Cartoon extends Drawing{
	
	Cartoon(){
		super(1);
		System.out.println("3:Cartoon constructor");
	}
	Cartoon(int i){
//		this();//由于构造器的调用必须是构造器中的第 多个构造器一个语句，所以不可能多个构造器调用并行
		super(i);
		System.out.println("3:Cartoon constructor;"+i);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Cartoon(); 
		new Cartoon(3);
	}

}
