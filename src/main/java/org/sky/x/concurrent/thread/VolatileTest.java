package org.sky.x.concurrent.thread;

public class VolatileTest {
	
	public static final int THREAD_COUNT = 20;
	
	public static volatile int race = 0;
	public static volatile int race1 = 0;
	
	public static void increace(){
		race++;
	}
	
	public static void main(String[] args){
		Thread[] threads = new Thread[THREAD_COUNT];
		for(int i=0; i < THREAD_COUNT; i++){
			threads[i] = new Thread(new Runnable(){
				public void run(){
					for(int i = 0; i < 10000; i++){
						increace();
					}
				}
			});
			threads[i].start();
		}
		while(Thread.activeCount() > 1){
			Thread.yield();
		}
		System.out.println("result:" + race);
	}
}
