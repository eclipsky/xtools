package org.sky.x.data.array;

import org.apache.commons.lang.math.RandomUtils;

/**
 * @author xieming  
 * 2014年6月12日 下午11:03:39
 */

public abstract class ArrayI{

	protected int[] array;
	
	protected int nEles;

	public ArrayI(int length){
		array = new int[length];
		nEles = 0;
	}
	
	public void randomFill(int min, int max){
		for(int i=0; i < array.length; i++){
			insert(RandomUtils.nextInt()%(max - min) + min);
		}
	}
	
	public void display(){
		System.out.println("数组为：");
		for(int i=0;i< nEles;i++){
			System.out.println("array["+i+"]=" + array[i]);
		}
	}

	public int getSize(){
		return nEles;
	}

	public int[] getArray(){
		return array;
	}
	
	public abstract int insert(int value);
	
	public abstract int delete(int value);
	
	public abstract int search(int value);
	
	public abstract int[] merge(int[] array1,int[] array2);
	
	public abstract void noDup();
	
}


