package org.sky.x.string;

import java.io.UnsupportedEncodingException;

/**
 * @author xieming  2013-10-15 下午04:03:44
 */
public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		Test test = new Test();
		String original = "who am i";
		System.out.println("before change："+original);
		System.out.println("original1:"+original.hashCode());
		test.changeString(original);
		System.out.println("after change："+original);
		
		System.out.println("12"+null);
		System.out.println(12+new String());
	}
	
	public void changeString(String original){
		System.out.println("original2:"+original.hashCode());
		String another = original;
		System.out.println("another1:"+another.hashCode());
		another = "012345";
		System.out.println("another2:"+another.hashCode());
		System.out.println("before sub："+original);
		String newString = original.substring(0, 3);
		System.out.println(newString);
		System.out.println("after sub："+original);
	}
	
}
