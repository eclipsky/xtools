package org.sky.x.string;

import java.util.Date;

/**
 * @author xieming  2013-10-14 下午04:37:49
 */
public class StringDemo {
	
	String s;
	String s1=null;
	Integer i2;
	int i1;
	Date date;
	static String s3;
	public void test(){
		String s0 = new String();
		String s00 = new String("");
		String s01="";
//		System.out.println(s0==s00);
//		System.out.println(s0==s01);
		String s1 = "ab";
		String s2 = "cd";
		String s3 = "ab"+"cd";
		String s4 = s1+"cd";
		String s5 = "ab".concat(s2);
		String s6 = "ab".concat("cd");
		String s7 = "abcd".concat("");
		String s8 = s3.concat("");
		String s9 = s4.concat("");
//		System.out.println(s0==s1);
//		System.out.println(s3==s4);//false
//		System.out.println(s3==s5);//false
//		System.out.println(s3==s6);//false
//		System.out.println(s5==s6);//false
//		System.out.println(s3==s7);//true
//		System.out.println(s4==s7);//false
//		System.out.println(s3==s8);//true
//		System.out.println(s4==s9);//true
		String t1 = "";
		String t2 = new String("");
		
		String t3 = ""+"";
		String t4 = t1.trim();
		String t5 = t2.trim();
		String t6 = "abc";
		String t7 = t6.trim();
		System.out.println(t1==t2);//false
		System.out.println(t1==t3);//true
		System.out.println(t1==t4);//true
		System.out.println(t2==t5);//true
		System.out.println(t6==t7);//true
		
//		System.out.println(s);
//		System.out.println(s1);
//		System.out.println(s==s1);
////		System.out.println(s.length());
////		System.out.println(s.equals(s1));
//		System.out.println(i2);
//		System.out.println(i1);
//		System.out.println(date);
//		
//		System.out.println(s3);
//		String s4 = new String();
//		System.out.println(s3+s4);
//		System.out.println(s3+"ab");
//		System.out.println(s3+"");
	}
	
	public static void main(String[] args){
		StringDemo sd = new StringDemo();
		sd.test();
//		System.out.println(date);
//		System.out.println(abc);
//		System.out.println(a);
//		System.out.println(s);//为什么static变量可以不
//        //在池中和堆中分别创建String对象"abc",s1指向堆中对象 
//        String s1 = new String("abc"); 
//        //s2直接指向池中对象"abc" 
//        String s2 = "abc"; 
//        //在堆中新创建"abc"对象，s3指向该对象 
//        String s3 = new String("abc"); 
//        //在池中创建对象"ab" 和 "c"，并且s4指向池中对象"abc" 
//        String s4 = "ab" + "c"; 
//        //c指向池中对象"c" 
//        String c = "c"; 
//        //在堆中创建新的对象"abc"，并且s5指向该对象 
//        String s5 = "ab" + c; 
//
//        String s6 = "ab".concat("c"); 
//        String s7 = "ab".concat(c); 
//
//        System.out.println("------------实串-----------"); 
//        System.out.println(s1 == s2); //false 
//        System.out.println(s1 == s3); //false 
//        System.out.println(s2 == s3); //false 
//        System.out.println(s2 == s4); //true 
//        System.out.println(s2 == s5); //false 
//        System.out.println(s2 == s6); //false 
//        System.out.println(s2 == s7); //false 
//
//        String b1 = new String(""); 
//        String b2 = ""; 
//        String b3 = new String(""); 
//        String b4 = "".intern(); 
//        String b5 = "" + ""; 
//        String b6 = "".concat(""); 
//        String b7 = "  ".trim(); 
//        String b8 = "  "; 
//        String b9 = "    ".trim(); 
//
//        System.out.println("------------空串-----------"); 
//        System.out.println(b1 == b2);  //false 
//        System.out.println(b1 == b3);  //false 
//        System.out.println(b2 == b3);  //false 
//        System.out.println(b2 == b4);  //true 
//        System.out.println(b2 == b5);  //true* 
//        System.out.println(b2 == b6);  //true* 
//        System.out.println(b2 == b7);  //false* 
//        System.out.println("-----a----"); 
//        System.out.println(b2.equals(b7));  //true 
//        System.out.println(b7 == b8);  //false 
//        System.out.println(b7 == b9);  //false 
//        System.out.println(b7.equals(b9)); //true 
//        System.out.println(b9 == null);//false 
//        System.out.println("b8.trim():"); 
//        for (byte b : b8.getBytes()) { 
//            System.out.print(">>>" + (int) b + " "); 
//        } 
//        System.out.println("\nb8.trim():"); 
//        for (byte b : b8.trim().getBytes()) { 
//            System.out.print(">>>" + (int) b + " "); 
//        } 
//        System.out.println("\nb9.trim():"); 
//        for (byte b : b9.trim().getBytes()) { 
//            System.out.print(">>>" + (int) b + " "); 
//        }
//        byte[] b = "".getBytes();
//        byte[] bb = "  ".getBytes();
//        byte[] bc = new byte[2];
//        System.out.println(b);
//        System.out.println(bb);
//        System.out.println(bc);
//        String sss = null;
//        String ss1;
//        String ss2 = sss+"aa";
//        System.out.println(ss2);
//        System.out.println(sss.length());
    } 
	
}
