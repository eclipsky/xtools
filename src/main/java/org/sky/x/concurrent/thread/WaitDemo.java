package org.sky.x.concurrent.thread;

/**
 * @author xieming  2013-10-26 ����05:03:51
 */
public class WaitDemo {
	public static void main(String[] args) throws InterruptedException{
		ThreadB b = new ThreadB();
		b.start();
		synchronized(b){
			System.out.println("δ��������Ϊ��"+b.total);
			b.wait();
			System.out.println("����ִ����");
			System.out.println("���������Ϊ��"+b.total);
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
