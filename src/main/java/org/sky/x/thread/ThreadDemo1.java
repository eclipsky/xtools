package org.sky.x.thread;

class HelloThread implements Runnable {

	private int count = 200;
	
	public synchronized void  decrease() throws Throwable{
//		synchronized(this) {
			System.out.println(Thread.currentThread().getName() + ":"+ count);
			count--;
//		}
//		Thread.sleep(5);
	}
	
	public void run() {
		try {
			while(count > 0){
				decrease();
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
