package org.sky.x.tij.c04;

public class Arrays {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a1  = {1,2,3,4,5};
		int[] a2 = a1;
		int[] a3 = new int[5];
		for(int i=0;i<a2.length;i++){
			a2[i]++;
			System.out.println(a1[i]);
		}
		// TODO Auto-generated method stub
		System.out.println(a3[1]);
	}
}
