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
//		QueueI queue = new MyQueue(5);
		QueueI queue = new PriorityQueue(5);
		while(!queue.isFull()){
			int insert = RandomUtils.nextInt()%50;
			System.out.println("insert:"+insert);
			queue.insert(insert);
		}
		while(!queue.isEmpty()){
			System.out.println("remove:"+queue.remove());
		}
	}
		
}
