package org.sky.x.tij.c04;

import java.util.Random;

public class ArrayNew {
	static Random rand = new Random();
	static int pRand(int mod){
		return Math.abs(rand.nextInt()%mod)+1;
	}
	public static void main(String[] args){
		Integer[] a,b;
		a = new Integer[pRand(10)];//ֻ�Ǵ����˶�����������û��ʵ����
		b = new Integer[]{new Integer(1),new Integer(2),};
//		b = {new Integer(1),new Integer(2)};//ֻ���ڶ����ʱ��ͨ�����ַ�ʽ��ʼ��������
		Integer[] c = {new Integer(1),new Integer(2)};
		System.out.println("length of a = "+a.length);
		for(int i=0;i<a.length;i++){
			System.out.println("a["+i+"]="+a[i]);
		}
		System.out.println(new Integer(0));
	}
}
