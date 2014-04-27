package org.sky.x.tij.c12;

import java.util.Iterator;
import java.util.Vector;

class Int{
	private int i;
	public Int(int ii){
		i = ii;
	}
	public void increment(){
		i++;
	}
	public String toString(){
		return Integer.toString(i);
	}
}

public class Cloning {
	public static void main(String[] args){
		Vector v = new Vector();
		for(int i = 0;i<10;i++){
			v.addElement(new Int(i));
		}
		System.out.println("v:"+v);
//		Vector v2 = (Vector)v.clone();
//		for(Iterator e = v2.iterator();e.hasNext();){
//			((Int)e.next()).increment();
//		}
//		System.out.println("v:"+v);
		Vector v3 = v;
		for(Iterator e = v3.iterator();e.hasNext();){
			((Int)e.next()).increment();
		}
		System.out.println("v:"+v);
	}
}
