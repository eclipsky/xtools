package org.sky.x.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.util.Enumeration;
import java.net.ServerSocket;

/**
 * @author xieming 2013-10-17 下午06:04:57
 */
public class WhoAmI {
	
	public static void main(String[] args) throws Exception {
		WhoAmI who = new WhoAmI();
		
//		ServerSocket socket = new ServerSocket(0);
//		System.out.println(socket);
		// who.testMethod01();
		// who.testMethod02();
		// who.testMethod03();
//		who.testMethod04();
		who.testMethod05();
		
	}

	public void testMethod01() throws UnknownHostException {
		InetAddress host = InetAddress.getLocalHost();
		System.out.println(host.getHostAddress());
		InetAddress a1 = InetAddress.getByName("");// ""
		InetAddress a2 = InetAddress.getByName("192.168.1.116");// localhost/127.0.0.1/0.0.0.0
		a2.getHostName();
		InetAddress a3 = InetAddress.getByAddress("MyLocalHost", new byte[] {
				127, 0, 0, 1 });// " "/baidu.com/127.baidu.com
		a3.getHostName();

		System.out.println(a1 + new String(a1.getAddress()));
		System.out.println(a2);
		System.out.println(a3);
		String s = "a " + "b " + "c ";
		s = URLEncoder.encode(s.trim());
		System.out.println(s);
	}

	public void testMethod02() throws IOException {
		long invalidSeconds = 1;
		java.security.Security.setProperty("networkaddress.cache.ttl",
				String.valueOf(invalidSeconds));
		System.out.println(invalidSeconds + "秒钟之后失效");
		long start = System.currentTimeMillis();
		InetAddress[] add1 = InetAddress.getAllByName("eclipsky.com");
		long end = System.currentTimeMillis();
		System.out.println("add1查询时间为：" + (end - start));
		if (add1.length > 0) {
			for (int i = 0; i < add1.length; i++) {
				System.out.println(add1[i]);
			}
		}
		System.out.println("按任意键继续");
		System.in.read();
		start = System.currentTimeMillis();
		InetAddress[] add2 = InetAddress.getAllByName("eclipsky.com");
		end = System.currentTimeMillis();
		System.out.println("add2查询时间为：" + (end - start));
		if (add2.length > 0) {
			for (int i = 0; i < add2.length; i++) {
				System.out.println(add2[i].getCanonicalHostName());
				System.out.println(add2[i]);
			}
		}
	}

	public void testMethod03() throws SocketException, UnknownHostException {
		InetAddress addr;
		// addr = InetAddress.getByName("localhost");
		addr = InetAddress.getLocalHost();
		NetworkInterface net = NetworkInterface.getByName("eth1");
		NetworkInterface net2 = NetworkInterface.getByInetAddress(addr);
		Enumeration nets = NetworkInterface.getNetworkInterfaces();
		while (nets.hasMoreElements()) {
			System.out.println(nets.nextElement());
		}

		// System.out.println(net);
		// System.out.println(net2);
	}

	public void testMethod04() throws IOException {
		int minPort = 70;
		int maxPort = 90;
		System.out.println("连接开始");
		Socket s = new Socket();
		s.connect(new InetSocketAddress("baidu.com",70),1000);
		System.out.println("连接成公");
		InetAddress  addr = s.getInetAddress();
		System.out.println(s);
		System.out.println(addr);
//		for (int i = minPort; i < maxPort; i++) {//扫描端口
//			try {
//				Socket socket = new Socket();
//				socket.connect(new InetSocketAddress("baidu.com",i), 10000);
//				System.out.println("port:" + i + " is OK");
//				socket.close();
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		System.out.println("连接结束");
	}
	
	public void testMethod05() throws Exception{
//		Socket socket1 = new Socket("localhost",8080);
		Socket socket = new Socket("localhost", 8088);
//		while(true){
			//向服务器发送消息
//			BufferedWriter writer = new BufferedWriter(
//					new OutputStreamWriter(socket.getOutputStream()));
//			writer.write("hello");
		Thread.sleep(1000);
		PrintWriter writer  = new PrintWriter(socket.getOutputStream());
		writer.write("hello\r\n");//后面一定要加\r\n,socket以此判断请求/响应结束
		writer.println("world");
		writer.flush();
		System.out.println("read()="+socket.getInputStream().read());
		System.out.println("isConnected()="+socket.isConnected());
		System.out.println("isClosed()="+socket.isClosed());
			//从服务器读取消息
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String echo = reader.readLine();
			System.out.println(echo);
//		}
	}
}
