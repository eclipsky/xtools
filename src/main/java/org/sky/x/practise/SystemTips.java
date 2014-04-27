package org.sky.x.practise;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Enumeration;

/**
 * ��ò���ϵͳ��JVM��Ϣ
 */
public class SystemTips {
	public static void main(String[] args) throws IOException {
		SystemTips tips  = new SystemTips();
//		tips.printSystemProperties();
//		tips.printSystemFonts();
		tips.lanuchProcess();
		tips.getMemoryUsage();
	}

	public void print(Object o){
		System.out.println(o);
	}
	/**
	 * ��ȡJVM�Ͳ���ϵͳ�����Ϣ
	 */
	public void printSystemProperties() {
		Properties p = System.getProperties();
		p.list(System.out);
//		Enumeration e = p.propertyNames();
//		System.out.println(p);
//		while (e.hasMoreElements()) {
//			String name = (String) e.nextElement();
//			String value = p.getProperty(name);
//			System.out.println(name + ":" + value);
//		}
	}
	
	/**
	 * ��ȡϵͳ������Ϣ
	 */
	public void printSystemFonts(){
		Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		for(Font font : fonts){
			print(font.getFamily()+":"+font.getFontName());
		}
	}
	
	/**
	 * ������һ��java����Ŀ����ر�
	 * @throws IOException
	 */
	public void lanuchProcess() throws IOException{
		Process p = Runtime.getRuntime().exec("java c:/Hello");//�򿪽���
		p.destroy();//�رս���
	}

	/**
	 * �鿴�ڴ�ʹ�� 
	 */
	public void getMemoryUsage(){
		Runtime rt = Runtime.getRuntime();
		print(rt.maxMemory()/1024/1024+"MB");
		print(rt.freeMemory()/1024/1024+"MB");
		print(rt.totalMemory()/1024/1024+"MB");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		System.out.println(date);
		float f = 3.1415926F;
		double d = 3.234d;
		int a = (int) 3.14;
		double a1 = 0.1;
		double a2 = 0.2;
		double a3 = 0.3;
		double a4 = 0.8;
		double a5 = 1.0;
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);
	}
	
	
}
