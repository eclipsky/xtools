package org.sky.x.tij.c03;

public class Equivalence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ֱ�Ӹ�ֵ��1���빲���ڴ�Σ�����i2��ʱ���жϳ�ʼֵ��ͬһ����ֱ�Ӳ���i1������
		Integer i1 = 1;
		Integer i2 = 1;
		System.out.println(i1==i2);
		
		//ͨ��new����������������
		Integer i3 = new Integer(1);
		Integer i4 = new Integer(1);
		System.out.println(i3==i4);
		System.out.println(i3==i1);
		
		System.out.println("�������equals�����ж϶��������Ƿ����");
		//ʹ��equal�������ж϶�������һ�µ����
		System.out.println(i3.equals(i4));
		System.out.println(i3.equals(i1));
	}

}
