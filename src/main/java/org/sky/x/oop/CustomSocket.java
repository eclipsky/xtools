package org.sky.x.oop;

import java.io.*;
import java.net.*;

/**
 * @author xieming  2013-10-20 ����05:32:10
 */

class SubSocket extends Socket{
	public String getRequestHeader() throws IOException{
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(this.getInputStream()));
		String s = "";
		StringBuffer result = new StringBuffer("");
		while(!(s=reader.readLine()).equals("")){
			result.append(s+"\r\n");
		}
		return result.toString();
	}
}

class SubServerSocket extends ServerSocket{
	
	/**
	 * @throws IOException
	 */
	public SubServerSocket(int port) throws IOException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public Socket accept() throws IOException{
		Socket socket = new SubSocket();
		/**
		 * ��accept�������صĶ�������ΪSubSocket
		 * ����Ǳ������ͨ��ǿ������ת�����У�
		 */
		implAccept(socket);
		return socket;
	}
	
}

public class CustomSocket {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		SubServerSocket subServer = new SubServerSocket(1234);
		subServer.setSoTimeout(0);
		while(true){
			SubSocket subSocket = (SubSocket) subServer.accept();
			subSocket.setKeepAlive(true);
			System.out.println(subSocket.getRequestHeader());
		}
	}

}
