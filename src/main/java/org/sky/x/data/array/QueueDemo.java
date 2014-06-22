package org.sky.x.data.array;


import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

/**
 * @author eclipsky  
 * 2014年6月20日 下午11:54:04
 */
public class QueueDemo {
	
	@Test
	public void testQueue(){
		QueueI queue = new MyQueue(5);
		while(!queue.isFull()){
			queue.insert(RandomUtils.nextInt()%50);
		}
		while(!queue.isEmpty()){
			queue.remove();
		}
	}
		
}
