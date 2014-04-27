package org.sky.x.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


class Customer implements Runnable{

	private PipedInputStream pis;
	
	public Customer(PipedInputStream pis){
		this.pis = pis;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte[] bytes = new byte[100];
		int length = 0;
		try {
			length = pis.read(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(bytes,0,length));
	}
}

class Producer implements Runnable{

	private PipedOutputStream pos;
	
	public int runtimes = 0;
	
	public Producer(PipedOutputStream pos){
		this.pos = pos;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String str = "created product";
		try {
			pos.write(str.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

/**
 * @author xieming  2013-10-13 ÉÏÎç08:40:10
 */
public class PipedStreamDemo {
	
	public static void main(String[] args) throws IOException{
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream(pos);
		Producer p = new Producer(pos);
		Thread tp = new Thread(p);
		Customer c = new Customer(pis);
		Thread tc = new Thread(c);
		tc.start();
		tp.start();
		
	}
}
