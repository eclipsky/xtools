package org.sky.x.concurrent.thread;

class Resource{
	int x;
	
	Resource(int x){
		this.x = x;
	}
}

class ReadWrite {
	
	private Resource r1 = new Resource(2);
	private Resource r2 = new Resource(5);
	
	public void write(int x1, int x2){
		synchronized(r1){
			System.out.println(Thread.currentThread() + "获取资源" + "R1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			r1.x = x1;
			synchronized(r2){
				System.out.println(Thread.currentThread() + "获取资源" + "R2");
				r2.x = x2;
			}
		}
	}
	
	public void read(){
		synchronized(r2){
			System.out.println(Thread.currentThread() + "获取资源" + "R2");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(r1){
				System.out.println(Thread.currentThread() + "获取资源" + "R1");
				System.out.println(r1.x = r2.x);
			}
		}
	}
}

public class DeadLock{
	public static void main(String[] args){
		final ReadWrite rw = new ReadWrite();
		Thread write = new Thread(new Runnable(){
			@Override
			public void run() {
				rw.write(10,20);
			}
		});
		Thread read = new Thread(new Runnable(){
			@Override
			public void run() {
				rw.read();
			}
		});
		write.start();
		read.start();
	}

}
