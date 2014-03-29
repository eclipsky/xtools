package org.sky.x.thread;

class HelloThread implements Runnable {

	private int count = 10;
	
	public void run() {
		while (count >= 0) {
			System.out.println(Thread.currentThread().getName() + ":"+ count);
			count--;
		}
	}
}

public class ThreadDemo1 {

	public static void main(String[] args) {
		Thread.currentThread().setName("main-a");
		HelloThread hello = new HelloThread();
		new Thread(hello, "a").start();
		new Thread(hello, "b").start();
	}
}
