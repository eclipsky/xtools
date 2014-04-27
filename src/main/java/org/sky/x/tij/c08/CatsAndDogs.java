package org.sky.x.tij.c08;

import java.util.Vector;

class Cat{
	private int catNumber;
	Cat(int i){
		catNumber = i;
	}
	void print(){
		System.out.println("Cat #"+catNumber);
	}
}

class Dog{
	private int dogNumber;
	Dog(int i){
		dogNumber = i;
	}
	void print(){
		System.out.println("Cat #"+dogNumber);
	}
}

public class CatsAndDogs {
	public static void main(String[] args){
		Vector cats = new Vector();
		for(int i=0;i<10;i++){
			cats.addElement(new Cat(i));
		}
		cats.addElement(new Dog(10));
		for(int i = 0;i<cats.size();i++){
			((Cat)cats.elementAt(i)).print();//到dog会出现异常，运行时异常
		}
	}
}
