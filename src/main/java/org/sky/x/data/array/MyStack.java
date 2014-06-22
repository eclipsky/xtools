package org.sky.x.data.array;

/**
 * @author eclipsky  
 * 2014年6月19日 下午11:31:51
 */
public class MyStack implements StackI{

	private int[] array;
	private int max;
	private int top;
	
	public MyStack(int length){
		array = new int[length];
		max = length;
		top = -1;
	}
	
	@Override
	public int pop() {
		System.out.println("pop:"+array[top]);
		return array[top--];
	}

	@Override
	public void push(int ele) {
		array[++top] = ele;
		System.out.println("push:"+array[top]);
	}

	@Override
	public int peek() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == (max - 1);
	}

}
