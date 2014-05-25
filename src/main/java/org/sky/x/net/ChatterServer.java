package org.sky.x.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author xieming 2013-10-18 上午12:21:25
 */
public class ChatterServer {
	public static final int port = 1723;
	private byte[] buf = new byte[1024];
	private DatagramPacket data = new DatagramPacket(buf, buf.length);
	private DatagramSocket socket;

	public ChatterServer() {
		try {
			socket = new DatagramSocket(port);
			System.out.println("server is running");
			while (true) {
				socket.receive(data);
				String get = DataConvert.toString(data);
				System.out.println(get);
				String echoStr = "echo " + get + data.getAddress() + data.getPort();
				socket.send(DataConvert.toDatagram(echoStr, data.getAddress(),
						data.getPort()));
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ChatterServer();
	}
}
