package org.sky.x.tij.c03;

public class Equivalence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//直接赋值，1放入共享内存段，定义i2的时候判断初始值是同一个就直接采用i1的引用
		Integer i1 = 1;
		Integer i2 = 1;
		System.out.println(i1==i2);
		
		//通过new生成了两个对象句柄
		Integer i3 = new Integer(1);
		Integer i4 = new Integer(1);
		System.out.println(i3==i4);
		System.out.println(i3==i1);
		
		System.out.println("下面采用equals方法判断对象内容是否相等");
		//使用equal方法来判断对象内容一致的情况
		System.out.println(i3.equals(i4));
		System.out.println(i3.equals(i1));
	}

}
