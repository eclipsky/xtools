package org.sky.x.reflect;

import java.util.ArrayList;

/**
 * @author xieming  2013-11-11 ÏÂÎç05:01:38
 */
public class ReflectionDemo {
	public static void main(String[] args)throws Exception{
//		test();
		MyInterface myin = (MyInterface)new MyInterfaceImpl();
		myin.print();
	}
	
	@SuppressWarnings("rawtypes")
	public static void test() throws Exception{
		Class c = Integer.TYPE;
		Class cl = int.class;
		Class c2 = Integer.class;
		Class c3 = Class.forName("java.lang.Integers");
		Class c33 = Class.forName("dd");
		Integer i = 10;
		Class c4 = i.getClass();
		Object o = String.class.newInstance();
		String ii = (String)o;
		c4.isInstance(1);
		System.out.println(ii);
		if(i instanceof Integer){
			
		}
		if(c.equals(cl)){
			System.out.println("Integer.TYPE equals int.class");
		}
		if(c.equals(c2)){
			System.out.println("Integer.TYPE equals Integer.class");
		}
		if(c2.equals(c3)){
			System.out.println("Integer.class equals Class.forName(\"java.lang.Integer\")");
		}
		if(c2.equals(c4)){
			System.out.println("Integer.class equals i.getClass()");
		}

	}
}

interface MyInterface{
	void print();
}

class MyInterfaceImpl implements MyInterface{
	public void print(){
		System.out.println("0000000000");
	}
}