package org.sky.x.data.array;

/**
 * @author xieming  
 * 2014年6月18日 下午9:53:16
 */
public interface StackI {
	public int pop();
	public void push(int ele);
	public int peek();
	public boolean isEmpty();
	public boolean isFull();
}
