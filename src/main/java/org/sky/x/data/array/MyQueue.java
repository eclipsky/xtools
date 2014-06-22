package org.sky.x.data.array;

/**
 * @author eclipsky  
 * 2014年6月20日 下午11:40:35
 */
public class MyQueue implements QueueI{
	
	private int max;
	private int nEles;
	private int[] array;
	private int front;
	private int rear;
	
	public MyQueue(int length){
		array = new int[length];
		max = length;
		front = 0;
		rear = -1;
		nEles = 0;
	}
	
	public void insert(int ele){
		if(rear == max - 1){
			rear = -1;
		}
		array[++rear] = ele;
		System.out.println("insert:"+ele);
		nEles++;
	}
	
	public int remove(){
		int tmp = array[front++];
		System.out.println("remove:"+tmp);
		if(front==max){
			front=0;
		}
		nEles--;
		return tmp;
	}
	
	public boolean isEmpty(){
		return nEles == 0;
	}
	
	public boolean isFull(){
		return nEles == max;
	}
	
	public int size(){
		return nEles;
	}
	
}
