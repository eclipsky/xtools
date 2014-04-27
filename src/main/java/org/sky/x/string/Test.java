package org.sky.x.string;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * @author xieming  2013-10-15 ÏÂÎç04:03:44
 */
public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		StringUtils st = new StringUtils();
		String s = "µ¤£¬dan.";
		String s1 = s.substring(0);
//		System.out.println(s.endsWith("."));
//		System.out.println(s==s1);
		System.out.println(String.format("%2$08d", -3123,-5566));  
        System.out.println(String.format("%1$9d", -31));  
        System.out.println(String.format("%1$-9d", -31));  
        System.out.println(String.format("%1$(9d", -31));  
        System.out.println(String.format("%1$#9x", 5689));
//		char[] chars = s.toCharArray();
//		byte[] bytes = s.getBytes();
////		for(char c:chars){
////			System.out.println(c);
////		}
//		System.out.println("--------------------");
//		for(byte b:bytes){
//			System.out.print(b+"\t");
//		}		
//		System.out.println();
//		bytes = s.getBytes("UTF-8");
//		for(byte b:bytes){
//			System.out.print(b+"\t");
//		}
//		System.out.println();
//		String tmp = new String(bytes,"GBK");
//		System.out.println(tmp);
//		System.out.println();
//		bytes = s.getBytes("GBK");
//		for(byte b:bytes){
//			System.out.print(b+"\t");
//		}
//		System.out.println();
//		tmp= new String(bytes,"UTF-8");
//		System.out.println(tmp);
//		Properties p = System.getProperties();
//		p.list(System.out);
	}
}
