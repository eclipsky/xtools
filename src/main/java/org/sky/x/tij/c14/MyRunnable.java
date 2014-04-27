package org.sky.x.tij.c14;
class Foo{
	private int x;
	
	public Foo(int x){
		this.x = x;
	}
	
	public synchronized int fix(int y){
		x = x-y;
		return x;
	}
	
	public synchronized int getX(){
		return x;
	}
}

public class MyRunnable implements Runnable{

	private Foo foo = new Foo(100);
	
	public static void main(String[] args){
		MyRunnable mr = new MyRunnable();
		Thread ta = new Thread(mr,"Thread-A");
		Thread tb = new Thread(mr,"Thread-B");
		ta.start();
		tb.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++){
			this.fix(15);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":当前foo对象中x的值为："+foo.getX());
		}
	}
	public int fix(int y){
		return foo.fix(y);
	}
}
