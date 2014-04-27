package org.sky.x.net;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;

/**
 * @author xieming 2013-10-17 обнГ07:41:31
 */
public class JabberClient {
	public static void main(String[] args){
		InetAddress address;
		Socket client = new Socket();
		try {
			address = InetAddress.getByName("localhost");
			client = new Socket(address, JabberServer.port);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			for(int i = 0 ;i<10;i++){
				out.println("howdy ");
				String str = in.readLine();
//				System.out.println(str);
			}
			out.println("end");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
