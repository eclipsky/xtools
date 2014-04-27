package org.sky.x.tij.c14;

public class Test01 {
	
	public static void main(String[] args){
		final NameList nl = new NameList();
		nl.add("name1");
		
		class NameDropper extends Thread{
			public void run(){
				String name = nl.removeFirst();
				System.out.println(name);
			} 
		}
		
		Thread t1 = new NameDropper();
		Thread t2 = new NameDropper();
		t1.start();
		t2.start();
	}
}
