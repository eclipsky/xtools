package org.sky.x.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * @author xieming  2013-10-18 обнГ12:38:32
 */
public class InetAddressDemo{

	public static void main(String[] args) throws UnknownHostException{
		String host = "localhost";//127.0.0.1,
		byte[] bytes = {127,0,0,1};
		InetAddress[] addrs = InetAddress.getAllByName("www.google.com");//getByAddress(bytes)
		for(InetAddress addr : addrs){
			byte[] tmp = addr.getAddress();
			System.out.println(addr.getHostAddress()+"\t"+addr.getHostName());
		}
		
	}
}
