package org.sky.x.net;

import java.io.*;
import java.net.*;

/**
 * @author xieming 2013-10-17 ÏÂÎç08:10:01
 */
public class ServerThread extends Thread {
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;

	public ServerThread(Socket s) {
		socket = s;
		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start();
	}

	public void run(){
		try {
			String str = "";
			out.write("HTTP/1.1 404 OK\r\n\r\n");
			while(!(str=in.readLine()).equals("")){
				System.out.println(str);
				out.write("<html><body>"+str+"<br/></body></html>");
			}
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		} finally{
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
