package org.sky.x.io;

import java.io.UnsupportedEncodingException;

/**
 * @author xieming  2013-10-13 ÏÂÎç02:07:29
 */
public class CodeDecodeDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		String s = "ÄãºÃ";
		//±àÂë
		byte[] bytes  = s.getBytes("gbk");//etBytes("GBK");
		
		//½âÂë
		String s1 = new String(bytes,"iso8859-1");
		System.out.println(s1);
		
		byte[] bytes1 = s.getBytes("iso8859-1");
		String s2 = new String(bytes,"gbk");
		System.out.println(s2);
		
	}
}
