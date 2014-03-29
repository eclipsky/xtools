package org.sky.x.design.pattern.strategy.impl;

import org.sky.x.design.pattern.strategy.IStrategy;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 25, 2012 9:38:40 AM
 * </p>
 **************************************************************** 
 */
public class BlockEnemy implements IStrategy {

	@Override
	public void operate() {
		System.out.println("孙夫人断后，挡住追兵");
	}

}
