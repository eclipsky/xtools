package org.sky.x.data.array;

import org.junit.Test;

/**
 * @author xieming  2014年6月5日 下午10:08:35
 */

public class ArrayDemo {
	
	@Test
	public void testUnsortedArray(){
//		array.insert(23);
//		array.insert(98);
//		array.insert(35);
//		array.display();
//		System.out.println("删除存在的数据。。。");
//		array.delete(71);
//		array.display();
//		System.out.println("删除不存在的数据。。。");
//		array.delete(11);
//		array.display();
//		System.out.println("新增数据。。。");
//		array.insert(99);
		CommonArray array = new UnsortedArray(10);
		array.randomFill(580, 590);
		array.display();		
		array.noDup();
		array.display();
	}
	
//	@Test
	public void testSortedArray(){
		System.out.println("有序数组。。。");
		CommonArray array1 = new SortedArray(10);
		CommonArray array2 = new SortedArray(10);
		array1.randomFill(300, 700);
		array2.randomFill(500, 900);
		int[] arr1 = array1.getArray();
		int[] arr2 = array2.getArray();
		int[] merge = array1.merge(arr1, arr2);
		for(int i =0;i< merge.length;i++){
			System.out.println("合并后的数组merge["+i+"]="+merge[i]);
			
		}
//		array.display();
//		array.search(1); 
//		array.delete(71);
//		array.display();
	}
}
