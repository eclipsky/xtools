package org.sky.x.data.sort;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

/**
 * @author xieming  
 * 2014年6月15日 下午8:41:48
 */
public class SortMethods {
	
	public int[] array;
	
	public void initArray(int length){
		array = new int[length];
		for(int i=0;i<length;i++){
			array[i] = RandomUtils.nextInt()%40 + 10;
		}
	}
	
	public void display(){
		for(int i=0;i<array.length;i++){
			System.out.println("array["+i+"]="+array[i]);
		}
	}
	
	public void exchange(int idx1,int idx2){
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}
	
	/**
	 * 冒泡排序
	 */
	public void bubbleSort(){
		long start = System.currentTimeMillis();
		/*从左往右移动*/
		/*for(int i=1;i<array.length;i++){
			for(int j=0;j<array.length-i;j++){
				if(array[j]>array[j+1]){
					exchange(j,j+1);
				}
			}
		}*/
		/*双向移动*/
		int left = 0;
		int right = array.length - 1;
		while(left<=right){
			for(int j = left;j<right;j++){
				if(array[j]>array[j+1]){
					exchange(j,j+1);
				}
			}
			right--;
			for(int j=right;j>left;j--){
				if(array[j]<array[j-1]){
					exchange(j,j-1);
				}
			}
			left++;
		}
		System.out.println("bubbleSort cost "+(System.currentTimeMillis() - start)+"ms");
	}
	
	/**
	 * 选择排序
	 */
	public void selectSort(){
		long start = System.currentTimeMillis();
		for(int i=1;i<array.length;i++){
			int max = 0;
			for(int j=1;j<=array.length - i;j++){
				if(array[max]<array[j]){
					max = j;
				}
			}
			if(max!=(array.length - i)){
				exchange(max,array.length - i);
			}
		}
		System.out.println("selectSort cost "+(System.currentTimeMillis() - start)+"ms");
	}
	
	/**
	 * 插入排序
	 */
	public void insertSort(){
		long start = System.currentTimeMillis();
		for(int i=1;i<array.length;i++){
			int tmp = array[i];
			int insertIdx = i;
			for(int j=i-1;j>=0;j--){
				if(tmp < array[j]){
					array[j+1]=array[j]; //比目标数小的数右移
					insertIdx = j;
				}
				if(j>1 && array[j-1]<=tmp){
					break;
				}
			}
			array[insertIdx] = tmp;
		}
		System.out.println("insertSort cost "+(System.currentTimeMillis() - start)+"ms");
	}
	
	@Test
	public void testSort(){
		initArray(10);
		System.out.println("排序前...");
		display();
		bubbleSort();
//		selectSort();
//		insertSort();
		System.out.println("排序后...");
		display();
	}
}
