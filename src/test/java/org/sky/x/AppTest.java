package org.sky.x;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
	
	@Test
	public void getStart() throws IOException{
		byte[] b = new byte[1024];
		System.in.read(b);
		System.out.println(new String(b)+ ":");
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
