package org.sky.x.thread;

/**
 * @author xieming  2013-10-26 ����04:22:12
 */

class ResourceA{
	int a;
}

class ResourceB{
	int b;
}

class ReadWrite {
	ResourceA a = new ResourceA();
	ResourceB b = new ResourceB();
	public int read() throws InterruptedException{
		synchronized(a){
			System.out.println("���߳�ռ����A��");
			Thread.sleep(10);
			synchronized(b){
				System.out.println("���߳�ռ����B��");
				return a.a + b.b;
			}
		}
	}
	
	public void write() throws InterruptedException{
		synchronized(b){
			System.out.println("д�߳�ռ����B��");
			Thread.sleep(10);
			synchronized(a){
				System.out.println("д�߳�ռ����A��");
				a.a = 10;
				b.b = 20;
			}
		}
	}
}

class ReadThread extends Thread{
	
	ReadWrite rw;
	
	public ReadThread(ReadWrite rw){
		this.rw = rw;
	}
	
	public void run(){
		try {
			rw.read();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class WriteThread extends Thread{
	
	ReadWrite rw;
	
	public WriteThread(ReadWrite rw){
		this.rw = rw;
	}
	
	public void run(){
		try {
			rw.write();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class DeadThreadDemo{
	public static void main(String[] args){
		ReadWrite rw = new ReadWrite();
		ReadThread r = new ReadThread(rw);
		WriteThread w = new WriteThread(rw);
		r.start();
		w.start();
	}
}
