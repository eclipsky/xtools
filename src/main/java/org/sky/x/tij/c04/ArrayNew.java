package org.sky.x.tij.c04;

import java.util.Random;

public class ArrayNew {
	static Random rand = new Random();
	static int pRand(int mod){
		return Math.abs(rand.nextInt()%mod)+1;
	}
	public static void main(String[] args){
		Integer[] a,b;
		a = new Integer[pRand(10)];//只是创造了对象句柄，而并没有实例化
		b = new Integer[]{new Integer(1),new Integer(2),};
//		b = {new Integer(1),new Integer(2)};//只能在定义的时候通过这种方式初始化，如下
		Integer[] c = {new Integer(1),new Integer(2)};
		System.out.println("length of a = "+a.length);
		for(int i=0;i<a.length;i++){
			System.out.println("a["+i+"]="+a[i]);
		}
		System.out.println(new Integer(0));
	}
}
