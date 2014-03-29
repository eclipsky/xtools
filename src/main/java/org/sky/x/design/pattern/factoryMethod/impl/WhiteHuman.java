package org.sky.x.design.pattern.factoryMethod.impl;

import org.sky.x.design.pattern.factoryMethod.Human;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 10:59:28 AM
 * </p>
 **************************************************************** 
 */
public class WhiteHuman implements Human {

	@Override
	public void cry() {
		System.out.println("白色人类会哭");
	}

	@Override
	public void laugh() {
		System.out.println("白色人类会大笑，侵略的笑声");
	}

	@Override
	public void talk() {
		System.out.println("白色人类会说话，一般都是但是单字节！");
	}

}
