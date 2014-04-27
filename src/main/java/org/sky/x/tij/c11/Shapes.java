package org.sky.x.tij.c11;

import java.util.Iterator;
import java.util.Vector;

interface Shape{
	void draw();
}

class Circle implements Shape{
	public void draw(){
		System.out.println("Circle.draw()");
	}
}

class Triangle implements Shape{
	public void draw(){
		System.out.println("Triangle.draw()");
	}
}

class Square implements Shape{
	public void draw(){
		System.out.println("Square.draw()");
	}
}

public class Shapes {
	public static void main(String[] args){
		Vector v = new Vector();
		v.addElement(new Circle());
		v.addElement(new Triangle());
		v.addElement(new Square());
		Iterator it = v.iterator();
		while(it.hasNext()){
			((Shape)it.next()).draw();
		}
		if(v instanceof Vector){
			System.out.println("instanceof done");
		}
		
		if(Vector.class.isInstance(v)){
			System.out.println("isInstance done");
		}
	}
}
