package org.sky.x.io;

import java.io.Serializable;

/**
 * @author xieming  2013-10-13 ÏÂÎç01:37:24
 */
public class Boy implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int age;
	
	private String name;
	
	private transient String hobby;
	
	public Boy(int age,String name,String hobby){
		this.age = age;
		this.name= name;
		this.hobby = hobby;
	}
	
	public void info(){
		System.out.println("age:"+age+"\t"+"name:"+name+"\t"+"hobby:"+hobby);
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setHobby(String hobby){
		this.hobby = hobby;
	}
}
