package org.sky.x.concurrent.thread;

import org.apache.commons.lang.math.RandomUtils;

class Warehouse {
	
	int stock;//仓库当前库存
	int max = 90;//最高库存
	int min = 10;//最低库存
	
	public Warehouse(int stock){
		this.stock = stock;
	}
	
	public synchronized void getGoods(int num){
		try{			
			while(stock < min){
				System.out.println("库存告急，立即通知工厂生产！");
				wait();
			}
			stock -= num;
			System.out.println(Thread.currentThread().getName() + "消费了："+num+"，剩余库存：" + stock);
			Thread.sleep(1000);
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void putGoods(int num){
		try{			
			while(stock > max){
				System.out.println("库存已满，立即通知顾客消费！");
				wait();
			}
			stock += num;
			System.out.println(Thread.currentThread().getName() + "生产了："+num+"，剩余库存：" + stock);
			Thread.sleep(1000);
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable{

	public Warehouse wh;
	
	public Producer(Warehouse wh){
		this.wh = wh;
	}
	
	@Override
	public void run() {
		while(true){
			wh.putGoods(RandomUtils.nextInt(5)+5);
		}
	}
	
}

class Consumer implements Runnable{
	
	public Warehouse wh;
	
	public Consumer(Warehouse wh){
		this.wh = wh;
	}
	
	@Override
	public void run() {
		while(true){
			wh.getGoods(RandomUtils.nextInt(3)+1);
		}
	}
	
}

public class ProducerConsumer{
	public static void main(String[] args){
		Warehouse wh = new Warehouse(20);
		Producer p = new Producer(wh);
		Consumer c = new Consumer(wh);
		Thread tp1 = new Thread(p,"生产者1");
//		Thread tp2 = new Thread(p,"生产者2");
//		Thread tp3 = new Thread(p,"生产者3");
		Thread tc1 = new Thread(c,"消费者1");
		Thread tc2 = new Thread(c,"消费者2");
		Thread tc3 = new Thread(c,"消费者3");
		System.out.println("开启生产消费模式");
		tp1.start();
//		tp2.start();
//		tp3.start();
		tc1.start();
		tc2.start();
		tc3.start();
		while(Thread.activeCount() == 1){
			/*只有主线程活动*/
			System.out.println("结束生产消费模式");
		}
	}
}