package org.sky.x.tij.c14;

public class SimpleThread extends Thread{
	
	private int countDown = 5;
	
	private int threadNumber;
	
	private static int threadCount = 0;
	
	public SimpleThread(){
		threadNumber = ++threadCount;
		System.out.println("Making "+threadNumber);
	}
	
	public void run(){
		while(true){
			System.out.println("Thread "+threadNumber+"("+countDown+")");
			if(--countDown==0)
				return;
		}
	}
	
	public static void main(String[] args){
		System.out.println("Thread Start");
		for(int i=0;i<3;i++){
			new SimpleThread().start();
		}
		System.out.println("Thread End");
	}
}
