package org.sky.x;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
	
	/**
	 * 将二维数组交叉组合
	 * String[][] arr = {{ "A","B" },{ "a","b","c" },{ "0" , "1"}};
	 * 变成
	 * [ [A, a, 0], [B, a, 0], [A, b, 0], [B, b, 0], [A, c, 0], [B, c, 0], 
	 * 	 [A, a, 1], [B, a, 1], [A, b, 1], [B, b, 1], [A, c, 1], [B, c, 1] ]
	 * @param <T>
	 * @param arr
	 */
	public static <T> List<List<T>> crossCombine(T[][] arr){
		int[] maxIdx=new int[arr.length];
		for(int i=0; i<arr.length; i++){
			maxIdx[i]=arr[i].length-1;
		}
		List<T> list = null;
		List<List<T>> result = new ArrayList<List<T>>();
		int[] idx=new int[arr.length];
		while(idx!=null){
			list=new ArrayList<T>();
			for(int i=0; i<idx.length; i++){
				list.add(arr[i][idx[i]]);
			}
			result.add(list);
			idx=incrIdx(maxIdx, idx);
		}
		return result;
	
	}
	private static int[] incrIdx(int[] maxIdx, int[] idx){
		boolean eqFlag=true;
		for(int i=0; i<maxIdx.length; i++){
			if(maxIdx[i] != idx[i]){
				eqFlag=false;
				break;
			}
		}
		if(eqFlag){
			return null;
		}
		for(int i=0; i < maxIdx.length; i++){
			if(i==0 && idx[i] < maxIdx[i]){
				idx[i]++;
				break;
			}else{
				idx[i]=0;
				if(i+1 < maxIdx.length && idx[i+1] < maxIdx[i+1]){
					idx[i+1]++;
					break;
				}
			}
		}
		return idx;
	}
	
	
	/**
	 * 根据数组类型的class创建对应类型的数组
	 * @param <T> 目标类型
	 * @param clazz
	 * @param length 数组长度
	 * @return T类型的数组
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] newArrayByArrayClass(Class<T[]> clazz, int length) {
		return (T[]) Array.newInstance(clazz.getComponentType(), length);
	}
	
	/**
	 * 根据普通类型的class创建数组
	 * @param <T> 目标类型
	 * @param clazz
	 * @param length 数组长度
	 * @return T类型的数组
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] newArrayByClass(Class<T> clazz, int length) {
		return (T[]) Array.newInstance(clazz, length);
	}

}
