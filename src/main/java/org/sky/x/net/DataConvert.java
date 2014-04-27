package org.sky.x.net;

import java.net.DatagramPacket;
import java.net.InetAddress;
/**
 * @author xieming  2013-10-17 ÏÂÎç10:50:32
 */
public class DataConvert {
	
	public static DatagramPacket toDatagram(String s,InetAddress destIA, int destPort){
		int len = s.length();
		byte[] buffer = new byte[len+1];
		buffer = s.getBytes();
		return new DatagramPacket(buffer,buffer.length,destIA,destPort);
	}
	
	public static String toString(DatagramPacket p){
		return new String(p.getData(),0,p.getLength());
	}
	
	public static void main(String[] args){
		byte[] chars = new byte[10];
		byte[] b2 = "àÞ".getBytes();
		System.out.println(b2.length);
		chars[0] = b2[0];
		chars[1] = b2[1];
		String s = new String(new byte[]{0,0,0,0});
		DatagramPacket data = new DatagramPacket(chars,20);
		System.out.println(s.length());
		System.out.println(s);
	}
}
