package org.sky.x.net;

import java.net.*;
import java.io.*;
/**
 * @author xieming  2013-10-19 下午05:58:39
 */
public class HttpSimulator {
	
	private Socket socket;
	
	private String host;
	
	private int port = 80;
	
	private String request = "";
	
	private boolean isPost,isHead;
	
	public static void main(String[] args) throws IOException{
		new HttpSimulator().run();
	}
	
	public void run() throws IOException{
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while(true){
			if(!readHostAndPort(reader))break;
			readHttpRequest(reader);
			sendHttpRequest();
			readHttpResponse(reader);
		}
	}
	
	public boolean readHostAndPort(BufferedReader reader) throws IOException{
		System.out.println("请输入主机域名和端口号");
		System.out.print("host:port>");
		String[] ss = null;
		String s = reader.readLine();
		if(s.equals("q")){
			return false;
		}else{
			ss = s.split(":");
			if(!ss[0].equals("")){
				host = ss[0];
			}
			if(ss.length > 1){
				port = Integer.parseInt(ss[1]);
			}
			System.out.println(host+":"+String.valueOf(port));
			return true;
		}
	}
	
	public void readHttpRequest(BufferedReader reader) throws IOException{
		System.out.println("请输入HTTP请求:");
		String s = reader.readLine();
		request = s + "\r\n";
		boolean isPost = s.substring(0,4).equals("POST");
		boolean isHead = s.substring(0,4).equals("HEAD");
		while(!(s = reader.readLine()).equals("")){//读取其他行
			request = request + s + "\r\n";
		}
		request = request + "\r\n";
		if(isPost){
			System.out.println("请输入POST方法的内容");
			s = reader.readLine();
			request += s;
		}
	}
	
	public void sendHttpRequest() throws IOException{
		socket = new Socket();
		socket.setSoTimeout(1000*10);
		System.out.println("正在连接服务器...");
		socket.connect(new InetSocketAddress(host,port),10*1000);
		System.out.println("服务器连接成功...");
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		writer.write(request);
		writer.flush();
	}
	
	public void readHttpResponse(BufferedReader consoleReader) throws IOException{
		String s = "";
		BufferedReader socketReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		System.out.println("---------HTTP头---------");
		boolean b = true;//消息头是否已被读过
		while((s = socketReader.readLine())!=null){
//			if(s.equals("")&& b==true && !isHead){//请求为head时，只返回消息头
//				System.out.println("------------------");
//				b = false;//再遇到空行就不会判断为消息头了
//				System.out.println("是否显示HTTP的内容（Y/N）");
//				String choice = consoleReader.readLine();
//				if(choice.equals("Y")||choice.equals("y")){
//					System.out.println("---------HTTP内容---------");
//					continue;
//				}else{
//					break;
//				}
//			}else{
				System.out.println(s);
//			}
		}
	}
}
