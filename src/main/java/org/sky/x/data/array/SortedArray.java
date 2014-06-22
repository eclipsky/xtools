package org.sky.x.data.array;

/**
 * @author xieming  
 * 2014年6月12日 下午11:06:02
 */

public class SortedArray extends ArrayI{

	public SortedArray(int length) {
		super(length);
	}
	
	@Override
	public int insert(int value) {
		if(nEles==array.length){
			System.out.println("the array is full, insert failed");
			return -1;
		}
		int insertIndex = 0;
		/* 使用顺序查找插入
		while(insertIndex < nEles){
			if(value<=array[insertIndex]){
				for(int i=nEles; i > insertIndex; i--){
					插入后面的数据后移
					array[i]=array[i-1];
				}
				array[insertIndex] = value;
				break;
			}else{
				insertIndex++;
			}
		}
		if(insertIndex==nEles){
			array[insertIndex] = value;
		}
		*/
		
		/* 使用二分查找插入
		 * 找出第一个元素使array[n] <= value < array[n+1]
		 * 那么array[n]就是需要插入的位置
		 */
		int lowerBound = 0;
		int upperBound = nEles;
		int middle = 0;
		while(lowerBound <= upperBound && nEles > 1){
			middle = (lowerBound + upperBound)/2;
			if(value == array[middle]){
				break;
			}
			if(value < array[middle]){
				upperBound = middle - 1;
			}else{
				lowerBound = middle + 1;
				
			}
		}
		
		if(nEles > 0 && value > array[middle] && middle < nEles){
			middle++;
		}
		for(int i = nEles; i > middle; i--){
			array[i]=array[i-1];
		}
		
		array[middle]=value;
		nEles++;
		
		insertIndex = middle;
		System.out.println("insert success array["+insertIndex+"]=" + value);
		return insertIndex;
	}
	
	@Override
	public int delete(int value) {
		int index = search(value);
		if(index == -1){
			System.out.println("delete failed. data is not exists");
			return -1;
		}
		/*删除后面的数据前移*/
		int move = index;
		while(move < nEles){
			array[move] = array[move+1];
			move ++;
		}
		System.out.println("delete success");
		nEles--;
		return index;
	}

	/**
	 * 使用二分查找
	 */
	@Override
	public int search(int value) {
		int lowerBound = 0;
		int upperBound = nEles;
		int middle;
		while(lowerBound <= upperBound){
			middle = (lowerBound + upperBound)/2;
			if(value==array[middle]){
				System.out.println("search success，array[" + middle + "]=" + value);
				return middle;
			}else if(value < array[middle]){
				upperBound = middle - 1;
			}else if(value > array[middle]){
				lowerBound = middle + 1;
			}
		}
		System.out.println("search failed, data is not exists");
		return -1;
	}

	@Override
	public int[] merge(int[] arr1, int[] arr2) {
		/*归并排序*/
		int[] merge = new int[arr1.length + arr2.length];
		int i = 0;
		int n1 = 0;
		int n2 = 0;
		while(i <= merge.length){
			while(n1<arr1.length && n2<arr2.length){
				if(arr1[n1]<=arr2[n2]){
					merge[i]=arr1[n1];
					n1++;
				}else{
					merge[i]=arr2[n2];
					n2++;
				}
				i++;
			}
			if(n1 < arr1.length){
				for(int j = n1 ;j < arr1.length; j++){
					merge[arr2.length + j] = arr1[j];
					i++;
				}
			}
			if(n2 < arr2.length){
				for(int j = n2 ;j < arr2.length; j++){
					merge[arr1.length + j] = arr2[j];
					i++;
				}
			}
		}
		return merge;
	}
	
	@Override
	public void noDup(){
		/*1.遍历数组，从左到右判断填充，左右比较是否相等*/
		int fill=0;
		for(int i=1;i<array.length;i++){
			if(array[i]!=array[fill]){
				fill++;
				if(fill!=i){
					array[fill]=array[i];
				}
			}
		}
		System.out.println("去重后数为:"+(fill+1));
		while(fill<array.length-1){
			array[++fill]=-1;
		}
		
	}
}
