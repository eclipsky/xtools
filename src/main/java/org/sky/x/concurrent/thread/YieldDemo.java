package org.sky.x.concurrent.thread;

/**
 * @author xieming  2013-10-26 ����09:28:09
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
			System.out.println("�߳�1��"+i+"��ִ��");
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
			System.out.println("�߳�2��"+i+"��ִ��");
			Thread.yield();//ֻ�Ƿ���cpu�������Կ����ٴα�ѡ�м�������
		}
	}
} 
