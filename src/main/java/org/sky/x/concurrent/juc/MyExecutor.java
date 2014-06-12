package org.sky.x.concurrent.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author eclipsky
 *
 */

public class MyExecutor extends Thread{
	
	/*线程池貌似按一个线程执行完，再继续下一个线程这样的阻塞方式来执行的?*/
	public static void main(String[] args){
		/*单线程执行器*/
//		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		/*固定大小的线程池*/
//		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		/*可变尺寸的线程池*/
//		ExecutorService pool = Executors.newCachedThreadPool();
		
		/*固定尺寸可延迟线程池*/
//		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		
		/*单线程可延迟线程池*/
//		ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
		
		/*创建等待队列*/
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
		/*单线程线程池*/
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1,3,2,TimeUnit.SECONDS,queue);
		MyExecutor t1 = new MyExecutor();t1.setName("t1"); 
		MyExecutor t2 = new MyExecutor();t2.setName("t2"); 
		MyExecutor t3 = new MyExecutor();t3.setName("t3"); 
		MyExecutor t4 = new MyExecutor();t4.setName("t4"); 
		MyExecutor t5 = new MyExecutor();t5.setName("t5");
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
//		pool.execute(t4);
//		pool.execute(t5);
//		pool.schedule(t4, 10, TimeUnit.SECONDS);
//		pool.schedule(t5, 10, TimeUnit.SECONDS);
		pool.shutdown();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
//		for(int i=0;i<5;i++){
//			System.out.println(Thread.currentThread()+"-"+i);风vr
//			try {
//				Thread.sleep(0);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}
