package org.sky.x.data.array;

/**
 * @author xieming  
 * 2014年6月12日 下午11:05:00
 */

public class UnsortedArray extends CommonArray{
	
	public UnsortedArray(int length) {
		super(length);
	}

	@Override
	public int insert(int num){
		if(nEles==array.length){
			System.out.println("the array is full, insert failed");
			return -1;
		}
		array[nEles] = num;
		nEles++;
		return nEles - 1;
	}
	
	@Override
	public int delete(int value){
		int i;
		for(i = 0; i < nEles; i++){
			if(value==array[i]){
				System.out.println("删除数据，array["+i+"]=" + value);
				break;
			}
		}
		if(i == nEles){
			System.out.println("找不到数据：value=" + value);
			return -1;
		}else{
			System.out.println("被删除数据后面的元素需要向前移");
			for(int k = i; k < nEles - 1; k++){
				array[k] = array[k+1];
			}
			nEles--;
		}
		return i;
	}
	
	@Override
	public int search(int value){
		for(int i = 0;i<nEles;i++){
			if(value == array[i]){
				System.out.println("找到指定value，array["+i+"]=" + value);
				return i;
			}
		}
		System.out.println("找不到指定value");
		return -1;
	}

	@Override
	public int[] merge(int[] arr1, int[] arr2) {
		return null;
	}

	@Override
	public void noDup(){
		/*1.遍历数组，标记重复记录，晚出现的作为待删除项*/
		for(int i=0;i<array.length;i++){
			if(array[i]==-1)break;
			for(int j=i+1;j<array.length;j++){
				if(array[j]==array[i]){
					array[j]=-1;
				}
			}
		}
		System.out.println("标记后的数组为");
		display();
		int fill = 0;
		/*2.遍历数组，从左到右填充*/
		for(int i=0;i<array.length;i++){
			if(array[i]!=-1){
				if(fill!=i){
					array[fill]=array[i];
					array[i]=-1;
				}
				fill++;
			}
		}
		System.out.println("去重后数为:"+fill);
		
	}
}

