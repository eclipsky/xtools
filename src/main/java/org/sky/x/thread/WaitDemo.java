package org.sky.x.thread;

/**
 * @author xieming  2013-10-26 下午05:03:51
 */
public class WaitDemo {
	public static void main(String[] args) throws InterruptedException{
		ThreadB b = new ThreadB();
		b.start();
		synchronized(b){
			System.out.println("未计算总数为："+b.total);
			b.wait();
			System.out.println("我能执行吗？");
			System.out.println("计算后总数为："+b.total);
		}
		Thread.sleep(100);
	}
}

class ThreadB extends Thread{
	
	int total = 0;
	
	public void run(){
		synchronized(this){
			for(int i = 0;i<100;i++){
//				try{
//					Thread.sleep(1);
//				}catch(InterruptedException e){
//					
//				}
				total += i;
			}
		}
	}
}
