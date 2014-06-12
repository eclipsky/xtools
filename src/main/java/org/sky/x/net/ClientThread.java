package org.sky.x.net;

import java.io.*;
import java.net.*;

/**
 * @author xieming 2013-10-17 下午08:10:01
 */
public class ClientThread extends Thread {
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;
	private static int running_threads = 0;

	public ClientThread(InetAddress addr) {
		System.out.println("Client:" + this.getName());
		try {
			socket = new Socket(addr, MultiJabberServer.PORT);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()), true);
			out.print("Hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		running_threads++;
		start();
	}

	public static int getThreadCount() {
		return running_threads;
	}

	public void run() {
		try {
			for (int i = 1; i < 10; i++) {
				Thread.sleep(10);
				System.out.println("from client:" + this.getName() + ":" + i);
				out.println("to server:" + this.getName() + ":" + i);
			}
			out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
