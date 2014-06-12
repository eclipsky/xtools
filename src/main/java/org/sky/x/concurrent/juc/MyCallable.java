package org.sky.x.concurrent.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable{

	private String cName;
	
	public MyCallable(String cName){
		this.cName = cName;
	}
	
	@Override
	public Object call() throws Exception {
		return cName + "顺利返回";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		/*创建线程池*/
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		/*创建有返回值的任务*/
		Callable c1 = new MyCallable("呼叫者1号");
		Callable c2 = new MyCallable("呼叫者2号");
		
		/*执行任务并获取Futrue对象*/
		Future f1 = pool.submit(c1);
		Future f2 = pool.submit(c2);
		
		/*获取任务执行的返回值*/
		System.out.println(f1.get().toString());
		System.out.println(f2.get().toString());
		
		/*关闭线程池*/
		pool.shutdown();
	}
	
}
