package org.sky.x.data.array;

/**
 * @author eclipsky  
 * 2014年6月22日 下午3:57:41
 */
public class PriorityQueue implements QueueI {

	private int[] array;
	private int nEles;
	private int max;
	
	public PriorityQueue(int length){
		array = new int[length];
		max = length;
		nEles = 0;
	}
	
	@Override
	public void insert(int ele) {
		if(nEles<max){
			if(nEles==0){
				array[0]=ele;
			}else{
				int insertIndex = -1;
				for(int i=0;i<nEles;i++){
					if(ele >= array[i]){
						insertIndex = i;
						break;
					}
				}if(insertIndex == -1){
					insertIndex = nEles;
				}
				/*插入位置以及其后的元素后移*/
				int move = insertIndex;
				while(move < nEles){
					array[move+1]=array[move];
					move++;
				}
				array[insertIndex] = ele;
			}
			nEles++;
		}else{
			System.out.println("queue is full, insert failed");
		}
	}

	@Override
	public int remove() {
		nEles--;
		return array[nEles];
	}

	@Override
	public boolean isEmpty() {
		return nEles==0;
	}

	@Override
	public boolean isFull() {
		return nEles==max;
	}

	@Override
	public int size() {
		return nEles;
	}

}
