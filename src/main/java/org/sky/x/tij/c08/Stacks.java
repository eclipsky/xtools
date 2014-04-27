package org.sky.x.tij.c08;

import java.util.Stack;

public class Stacks {
	static String[] months={"January","February","March","April",
		"May","June","July","August",
		"September","October","November","December"};
	
	public static void main(String[] args){
		Stack s = new Stack();
		for(int i = 0;i<months.length;i++){
			s.push(months[i]+" ");
		}
		System.out.println("s="+s);
		s.addElement("The last line");
		System.out.println("element 5:"+s.elementAt(5));
		while(!s.empty()){
			System.out.println(s.pop());
		}
	}
}
