package org.sky.x.thread;

/**
 * @author xieming  2013-10-26 下午09:28:09
 */
public class YieldDemo {
	public static void main(String[] args){
		new YieldThread01().start();
		new YieldThread02().start();
	}
}

class YieldThread01 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程1第"+i+"次执行");
		}
	}
} 

class YieldThread02 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程2第"+i+"次执行");
			Thread.yield();//只是放弃cpu，但是仍可能再次被选中加入运行
		}
	}
} 
