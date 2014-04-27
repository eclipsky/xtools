package org.sky.x.tij.c07;

public class InnerClass01{
	class From{
		From(String str){
			System.out.println("From:"+str);
		}
	}
	class To{
		To(String str){
			System.out.println("To:"+str);
		}
	}
	public static void main(String[] args){
		InnerClass01 c1 = new InnerClass01();
	}
}
 