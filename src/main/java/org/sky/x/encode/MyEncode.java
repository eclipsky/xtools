package org.sky.x.encode;

import java.nio.charset.Charset;

import org.junit.Test;

public class MyEncode {
	
	@Test
	public void base(){
		String endian = System.getProperty("sun.cpu.endian");
		System.out.println("当前JRE版本：" + System.getProperty("java.version"));
		System.out.println("当前JVM编码：" + Charset.defaultCharset());
		Integer hex = 012;
		Integer dec = 12;
		Integer oct = 0x12;
		System.out.println("hex：" + hex);
		System.out.println("dec：" + dec);
		System.out.println("oct：" + oct);
		
	}
	
//	@Test
	public void cnEncode(){
		/*使用utf16将根据cup的大小端在字符串前面添加FFFE或FEFF*/
		String china = "中国人";
		System.out.println("---------gbk--------");
		byte[] bs = china.getBytes(Charset.forName("gbk"));
		for(byte b:bs){
			System.out.println(b);
		}
		System.out.println("---------utf8--------");
		bs = china.getBytes(Charset.forName("utf8"));
		for(byte b:bs){
			System.out.println(b);
		}
		System.out.println("---------utf16--------");
		bs = china.getBytes(Charset.forName("utf16"));
		for(byte b:bs){
			System.out.println(b);
		}	
		System.out.println("---------utf32--------");
		bs = china.getBytes(Charset.forName("utf32"));
		for(byte b:bs){
			System.out.println(b);
		}	
		
	}
}
