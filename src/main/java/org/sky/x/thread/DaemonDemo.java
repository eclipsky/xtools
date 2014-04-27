package org.sky.x.thread;

/**
 * @author xieming  2013-10-26 下午10:14:18
 */
public class DaemonDemo {
	public static void main(String[] args) throws Exception{
		DaemonThread md = new DaemonThread();
		md.setDaemon(true);
		md.start();
		for(int i=0;i<10; i++){
//			Thread.sleep(10);
			System.out.println("线程main："+i);
		}
	}
}

class DaemonThread extends Thread{
	public void run(){
		for(int i=0;i<10; i++){
			System.out.println("线程1："+i);
		}
	}
}
