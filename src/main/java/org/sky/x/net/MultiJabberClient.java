package org.sky.x.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xieming 2013-10-17 обнГ08:10:56
 */
public class MultiJabberClient {
	
	public static final int MAX_THREADS = 10;

	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getByName(null);
		while (true) {
			if (ClientThread.getThreadCount() < MAX_THREADS) {
				new ClientThread(addr);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
