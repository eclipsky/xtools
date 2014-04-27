package org.sky.x.practise;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Properties;

/**
 * @author xieming  2013-10-25 ионГ09:43:29
 */
public class Hello {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Properties p = System.getProperties();
//		p.list(new PrintStream("c:/SystemProperties.info"));
		int i = 2<<4;
		System.out.println(i);
		short s = 10;
		s+=5;
		Calendar.getInstance();
		System.out.println(s);
	}
}

interface MyInterface{
	public static final int a = 10;
	public abstract void print();
}