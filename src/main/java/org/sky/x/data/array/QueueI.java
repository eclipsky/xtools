package org.sky.x.data.array;

/**
 * @author eclipsky  
 * 2014年6月20日 下午11:52:12
 */
public interface QueueI {
	public void insert(int ele);
	public int remove();
	public boolean isEmpty();
	public boolean isFull();
	public int size();
}
