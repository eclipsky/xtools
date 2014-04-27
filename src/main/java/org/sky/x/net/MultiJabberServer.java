package org.sky.x.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xieming 2013-10-17 обнГ08:10:44
 */
public class MultiJabberServer {
	public static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Server start");
		try {
			while (true) {
				Socket socket = s.accept();
				new ServerThread(socket);
			}
		} finally {
			s.close();
		}
	}
}
