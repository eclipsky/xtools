package org.sky.x.thread;

import java.util.Random;

/**
 * @author xieming 2013-10-25 上午11:35:21
 */

class Warehouse {

	public static final int MAX_STOCK = 100; // 仓库最大库存，超过就不能继续生产了。

	public static final int MIN_STOCK = 10; // 仓库最低库存，低于就不能继续消费了。

	private int stock;// 仓库当前库存量

	public Warehouse(int stock) {
		this.stock = stock;
		System.out.println("新仓库的库存为：" + stock);
	}

	public synchronized 
	void produce(int num) throws InterruptedException {
		Thread.sleep(10);
		while ((stock + num) > MAX_STOCK) {
			System.out.println("生产了" + num + "个商品" + "\t超过最大库存，本次生产无效");
			wait();
		}
		stock += num;
		System.out.println("生产了" + num + "个商品" + "\t当前库存为:" + stock);
		notifyAll();
	}

	public synchronized 
	void consume(int num) throws InterruptedException {
		Thread.sleep(10);
		while ((stock - num) < MIN_STOCK) {
			System.out.println("消费了" + num + "个商品" + "\t低于最小库存，本次消费无效");
			wait();
		}
		stock -= num;
		System.out.println("消费了" + num + "个商品" + "\t当前库存为:" + stock);
		notifyAll();
	}

	public int getStock() {
		return stock;
	}
}

class Producer extends Thread {

	public Warehouse warehouse;

	public Producer(Warehouse w) {
		warehouse = w;
	}

	public void run() {
		Random r = new Random();
		int num = r.nextInt(10) + 10;
		try {
			warehouse.produce(num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Consumer extends Thread {
	public Warehouse warehouse;

	public Consumer(Warehouse w) {
		warehouse = w;
	}

	public void run() {
		Random r = new Random();
		int num = r.nextInt(10) + 10;
		try {
			warehouse.consume(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

public class ProducerConsumer {
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse(50);
		for (int i = 0; i < 5; i++) {
			new Producer(warehouse).start();
			new Consumer(warehouse).start();
		}
	}
}
