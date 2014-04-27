package org.sky.x.tij.c02;

import java.util.Date;
import java.util.Properties;

public class Property {
	public static void main(String[] args){
		if(null!=args){
			for(int i=0;i<args.length;i++){
				System.out.println(args[i]);
			}
		}
		System.out.println(new Date());
//		try {
//			Thread.currentThread().sleep(1000*5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Properties p = System.getProperties();
//		p.list(System.out);
//		System.out.println("-----Memory Usage-----:");
//		Runtime rt = Runtime.getRuntime();
//		System.out.println("Total Memory="+rt.totalMemory());
//		System.out.println("Free Memory="+rt.freeMemory());
	}
}
