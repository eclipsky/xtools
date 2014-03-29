package org.sky.x.design.pattern.abstractFactory.impl;

import org.sky.x.design.pattern.abstractFactory.Human;



/**
 * **************************************************************
 * <p>
 * 
 * @DESCRIPTION :
 * @AUTHOR : andy.meng@xiu.com
 * @DATE :Oct 26, 2012 10:59:28 AM
 *       </p>
 *       ***************************************************************
 */
public abstract class AbstractBlackHuman implements Human {

	@Override
	public void cry() {
		System.out.println("黑人会哭");
	}

	@Override
	public void laugh() {
		System.out.println("黑人会笑");
	}

	@Override
	public void talk() {
		System.out.println("黑人可以说话，一般人听不懂");
	}

}
