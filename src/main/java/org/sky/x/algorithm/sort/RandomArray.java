package org.sky.x.algorithm.sort;

import java.util.Random;

public class RandomArray {
	
	public static int[] randomArray;
	
	public static Random random = new Random();
	
	public static int[] getRandomArray(int length){
		randomArray = new int[length];
		for(int i = 0;i<length;i++){
			randomArray[i] = Math.abs(random.nextInt(length*10));
		}
		return randomArray;
	}
	
	public static int[] copyArray(int[] array){
		int[] copyArray = new int[randomArray.length];
		for(int i =0;i<randomArray.length;i++){
			copyArray[i]=randomArray[i];
		}
		return copyArray;
	}
}
