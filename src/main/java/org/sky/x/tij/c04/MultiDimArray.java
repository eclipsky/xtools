package org.sky.x.tij.c04;

import java.util.Random;

public class MultiDimArray {
	static Random rand = new Random(); 
	static int pRand(int mod){
		return Math.abs(rand.nextInt()%mod)+1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ͨ��new�ؼ��ֶ��壬����Ҫ�ڱ������ƶ���һά�ĳ��ȣ�������ά�ȿ�����������ȷ��
		int[] a11 = {1,2,3,4};
		int[] a12 = new int[2];
		int[][] a21 = {{1,2,3},{11,22,33}};
		int[][] a22 = new int[2][];
		int[][] a23 = new int[2][3];
		int[][][] a31 = {{{1,2,3},{11,22,33}},{},};
		int[][][] a32 = new int[2][][];
		int[][][] a33 = new int[2][3][];
		for(int i=0;i<a32.length;i++){
			a32[i] = new int[pRand(3)][];
			for(int j=0;j < a32[i].length;j++){
				a32[i][j] = new int[pRand(5)];
			}
		}
		
		for(int i=0;i<a32.length;i++){
			for(int j=0;j<a32[i].length;j++){
				for(int k=0;k<a32[i][j].length;k++)
					a32[i][j][k]= pRand(30);
			}
		}
		
		for(int i=0;i<a32.length;i++){
			for(int j=0;j<a32[i].length;j++){
				for(int k=0;k<a32[i][j].length;k++)
					System.out.println("a32["+i+"]["+j+"]["+k+"]:"+a32[i][j][k]);
			}
		}
		
	}

}
