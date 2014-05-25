package org.sky.x.concurrent.thread;


public class Daemon {
	public static void main(String[] args){
//		Thread.currentThread().setDaemon(true);
		for(int i = 0 ;i < 10; i++){
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				for(int i = 0 ;i < 10; i++){
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}		
			}
		});
		t1.setDaemon(true);
		t1.start();
		System.out.println("main method over");
	}
}
