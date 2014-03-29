package org.sky.x.design.pattern.strategy.impl;

import org.sky.x.design.pattern.strategy.IStrategy;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 25, 2012 9:38:00 AM
 * </p>
 **************************************************************** 
 */
public class GivenGreenLight implements IStrategy {

	@Override
	public void operate() {
		System.out.println("求吴国太开个绿灯,放行！");
	}

}
