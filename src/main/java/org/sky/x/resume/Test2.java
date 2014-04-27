package org.sky.x.resume;

class RootTest{
	
}
public class Test2 extends RootTest {
	public static void main(String[] args){
		Test2 t = new Test2();
		System.out.println("main,i="+t.test1());
	}
	
	public static int test1(){
		int i = 2;
		try{			
			System.out.println("try,i="+i);
			return i;
		}finally{
			i++;
			System.out.println("finally,i="+i);
//			return i;
		}
	}
	public void test(){
		System.out.println(this.getClass().getName());
		System.out.println(getClass().getSuperclass().getName());
		
		String a="Hello";
		String b="Hello";
		String c=new String("Hello");
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a=="Hello");
		System.out.println(a.equals(c));
		System.out.println(a.equals("Hello"));
		
	}
}
