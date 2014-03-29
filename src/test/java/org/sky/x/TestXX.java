package org.sky.x;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestXX {
	
    public static final int A = 4 + 4;
    
    public static final int B = 4 + new Random().nextInt(10);
	
	static {
		System.out.println("如果执行了，证明类初始化了……");
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		TestXX tx = new TestXX();
		MyThread mt = tx.new MyThread();
		mt.start();
		Map map = Collections.synchronizedMap(new HashMap());
		System.out.println(map);
	}
	
	class MyThread extends Thread {
		
		public void run() {
			for (;;) {
				System.out.println("mythread");
			}
		}
		
	} 

}
