package org.sky.x.collection;

/**
 * @author xieming  2013-10-16 ����05:00:27
 */
public class Student{
	
	private String name;
	
	private int age;
	
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public void setString(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
}
