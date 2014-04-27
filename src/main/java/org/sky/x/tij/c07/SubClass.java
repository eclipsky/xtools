package org.sky.x.tij.c07;



abstract class AbstractStatic {
	abstract void play();
	static void say(String words){
		System.out.println("What Father Say is :"+words);
		
	}
//	abstract static void eat();
	
	public static void main(String args[]){
		System.out.println("AbstractStatic");
		say("What a Fucking Day Today");
//		AbstractStatic as = new AbstractStatic();
	}
}

public class SubClass extends AbstractStatic{
	static void say(String words){
		System.out.println("What Son Say is :"+words);
	}
	public static void main(String[] args){
		say("SubClass");
	}

	@Override
	void play() {
		// TODO Auto-generated method stub
		
	}
	
}
