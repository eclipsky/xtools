package org.sky.x.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author xieming  2013-10-18 上午12:47:18
 */
public class ChatterClient extends Thread{
	private byte[] buf = new byte[1024];
	private DatagramPacket data = new DatagramPacket(buf,buf.length);
	private DatagramSocket socket;
	private InetAddress serverAddress;
	private int id;
	
	public ChatterClient(int identifier){
		id = identifier;
		System.out.println("#Client:"+id+" created");
		try {
			socket = new DatagramSocket();
			serverAddress = InetAddress.getByName("localhost");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		String toSent = "Client#" + id;
		try {
			//发送数据包
			socket.send(DataConvert.toDatagram(toSent, serverAddress, ChatterServer.port));
			//接受数据报
			socket.receive(data);
			System.out.println(DataConvert.toString(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		for(int i = 1; i < 10; i++)
			new ChatterClient(i).start();
	}
}
