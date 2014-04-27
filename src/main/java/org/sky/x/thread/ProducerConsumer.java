package org.sky.x.thread;

import java.util.Random;

/**
 * @author xieming 2013-10-25 ����11:35:21
 */

class Warehouse {

	public static final int MAX_STOCK = 100; // �ֿ�����棬�����Ͳ��ܼ��������ˡ�

	public static final int MIN_STOCK = 10; // �ֿ���Ϳ�棬���ھͲ��ܼ��������ˡ�

	private int stock;// �ֿ⵱ǰ�����

	public Warehouse(int stock) {
		this.stock = stock;
		System.out.println("�²ֿ�Ŀ��Ϊ��" + stock);
	}

	public synchronized 
	void produce(int num) throws InterruptedException {
		Thread.sleep(10);
		while ((stock + num) > MAX_STOCK) {
			System.out.println("������" + num + "����Ʒ" + "\t��������棬����������Ч");
			wait();
		}
		stock += num;
		System.out.println("������" + num + "����Ʒ" + "\t��ǰ���Ϊ:" + stock);
		notifyAll();
	}

	public synchronized 
	void consume(int num) throws InterruptedException {
		Thread.sleep(10);
		while ((stock - num) < MIN_STOCK) {
			System.out.println("������" + num + "����Ʒ" + "\t������С��棬����������Ч");
			wait();
		}
		stock -= num;
		System.out.println("������" + num + "����Ʒ" + "\t��ǰ���Ϊ:" + stock);
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
