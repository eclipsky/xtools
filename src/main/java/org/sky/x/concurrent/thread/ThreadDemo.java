package org.sky.x.concurrent.thread;

class Student extends Thread {

	public Student(String name) {
		this.setName(name);
	}

	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getState());
		System.out.println((currentThread.isInterrupted() ? "�ж�" : "δ�ж�"));
		currentThread.interrupt();
		System.out.println((currentThread.isInterrupted() ? "�ж�" : "δ�ж�"));
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		System.out.println(currentThread.getState());
		System.out.println((currentThread.isInterrupted() ? "�ж�" : "δ�ж�"));
//		for (int i = 0; i < 5; i++) {
//			Thread currentThread = Thread.currentThread();
//			System.out.println(i + ":"
//					+ (currentThread.isInterrupted() ? "�ж�" : "δ�ж�"));
//			System.out.println("student " + this.getName() + ":\t" + i);
//		}
	}
}

class Teacher implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("teacher " + Thread.currentThread().getName()
					+ "\t" + i);
		}
	}
}

/**
 * @author xieming 2013-10-17 ����01:44:21
 */
public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException{
		Thread mainThread = Thread.currentThread();
		// mainThread.start();
		// System.out.println("mainThread running...");
		Thread ts = new Student("sam");
//		 Teacher t = new Teacher();
//		 Thread t1 = new Thread(t, "liu");
		// Thread t2 = new Thread(t, "xie");
		// System.out.println(Thread.MAX_PRIORITY+"-"+Thread.NORM_PRIORITY+"-"+Thread.MIN_PRIORITY);
		// System.out.println("1:"+ts.isAlive());
		ts.start();
//		 t1.start();
//		 t1.join();
		 for(int i = 0;i<10;i++){
//			 Thread.sleep(10);
//			 System.out.println("main:"+i);
//			 Thread.currentThread().yield();
		 }
		// System.out.println("2:"+ts.isAlive());
		// try{
		// Thread.sleep(5);
		// System.out.println("3:"+ts.isAlive());
		// ts.join();
		// System.out.println("4:"+ts.isAlive());
		// }catch(InterruptedException e){
		// e.printStackTrace();
		//
		// }
		// // t1.start();
		// // t2.start();
		// System.out.println("5:"+ts.isAlive());
		// System.out.println("mainThread exiting...");
	}
}
