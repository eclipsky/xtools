package org.sky.x.design.pattern.factoryMethod.impl;

import org.sky.x.design.pattern.factoryMethod.Human;

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
public class BlackHuman implements Human {

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
