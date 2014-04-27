package org.sky.x.tij.c14;

class Customer extends Thread{
	public int i;
	
	public Customer(){
		
	}
	
	public Customer(String name){
		super(name);
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName()+":"+i);
		}
			
//		System.out.println("我是消费者"+i);
	}
}

class Factory implements Runnable{
	public int i;
	public Factory(int i){
		this.i = i;
	}
	public void run(){
		System.out.println("我是生产者"+i);
	}
}

public class MyThread  {
	public static void main(String[] args){
		
		Customer c = new Customer();
		Thread c2 = new Thread(c,"jim");
		Thread c3 = new Thread(c,"jim");
//		try {
//			c2.join();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		//c.start();
		c2.start();
		c3.start();
//		for(int i=0;i<10;i++){
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName()+":"+i);
//		}
		Factory f = new Factory(11);
		
	}
	
}
