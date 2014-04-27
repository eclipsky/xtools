package org.sky.x.net;

import java.io.*;
import java.net.*;

/**
 * @author xieming  2013-10-17 ÏÂÎç07:20:03
 */
public class JabberServer {
	public static final int port = 8080;
	
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(port);
		try {
			while(true){
			System.out.println("started:"+server);
			Socket socket = server.accept();
			System.out.println("Connection accepted:"+socket);
			InputStream in2 = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			while(true){
				String str = in.readLine();
//				in2.close();
//			System.out.println(server.isClosed());
//				if(str.equals("end"))break;
				System.out.println("Echoing:"+str);
				out.write("from the server:"+str+"\r\n");
				out.flush();
//			}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
//			server.close();
		}
//		System.out.println(server.isClosed());
	}
}
