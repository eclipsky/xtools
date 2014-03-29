package org.sky.x.design.pattern.strategy.impl;

import org.sky.x.design.pattern.strategy.IStrategy;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 25, 2012 9:37:00 AM
 * </p>
 **************************************************************** 
 */
public class BackDoor implements IStrategy {

	@Override
	public void operate() {
		System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
	}

}
