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
//		this();//���ڹ������ĵ��ñ����ǹ������еĵ� ���������һ����䣬���Բ����ܶ�����������ò���
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
