package org.sky.x.net;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
/**
 * @author xieming  2013-10-20 下午01:34:37
 */
public class HttpServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket();
		server.setReuseAddress(true);
		server.bind(new InetSocketAddress("localhost",80));
		System.out.println("服务器已经启动，端口号为8088");
		System.out.print("isClosed():"+server.isClosed());
		System.out.print("isBound():"+server.isBound());
		while(true){
			server.close();
//			Socket socket = server.accept();
//			new ServerThread(socket);
//			server.close();
//			socket.close();
		}
	}

}