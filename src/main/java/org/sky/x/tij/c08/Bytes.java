package org.sky.x.tij.c08;

import java.util.Random;

public class Bytes {
	
	static Random r = new Random();
	public static byte[] b = new byte[10];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		r.nextBytes(b);
		for(int i=0;i<10;i++){
			System.out.println(b[i]+":"+(char)b[i]);
		}
	}

}
