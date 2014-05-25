package org.sky.x;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
	
	@Test
	public void getStart(){
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
//		System.out.println(Thread.currentThread().getName());
//		Thread.currentThread().setName("main线程改名为主线程");
//		System.out.println(Thread.currentThread().getName());
//		Hello hello = new Hello();
//		Thread t1 = new Thread(hello);
//		t1.setName("线程1");
//		Thread t2 = new Thread(hello);
//		t2.setName("线程2");
//		for(int i = 0;i<10;i++){
//			System.out.println(Thread.currentThread().getName()+":"+i);
//		}
//		t1.start();
//		t2.start();
	}
	
}

class Hello implements Runnable{
	public void run() {
		for(int i = 0; i < 10; i++){
/*			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
