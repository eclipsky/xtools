package org.sky.x.oop;

import java.util.ArrayList;


class Duoli implements Cloneable{
	public int age;
	public String name;
	public ArrayList boys;
	
	public Duoli(int age, String name){
		this.age = age;
		this.name = name;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

	
	
/**
 * @author xieming  2013-10-21 ионГ03:37:24
 */
public class CloneObject {
	public static void main(String[] args) throws CloneNotSupportedException{
		System.out.println();
		Duoli d1 = new Duoli(1,"d1");
		Duoli d2 = (Duoli) d1.clone();
		System.out.println(d2.age+"-"+d2.name);
	}
}
