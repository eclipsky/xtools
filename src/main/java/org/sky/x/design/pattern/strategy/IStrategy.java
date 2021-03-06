package org.sky.x.design.pattern.strategy;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 首先定一个策略接口，这是诸葛亮老人家给赵云的三个锦囊妙计的接口
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 25, 2012 9:34:10 AM
 * </p>
 **************************************************************** 
 */
public interface IStrategy {
	
	// 每个锦囊妙计都是一个可执行的算法
	public void operate();
	
}
