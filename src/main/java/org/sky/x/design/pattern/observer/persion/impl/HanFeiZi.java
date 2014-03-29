package org.sky.x.design.pattern.observer.persion.impl;

import org.sky.x.design.pattern.observer.persion.IHanFeiZi;
import org.sky.x.design.pattern.observer.persion.Observable;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 被观察者
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 4:38:14 PM
 * </p>
 **************************************************************** 
 */
public class HanFeiZi extends Observable implements IHanFeiZi {

	@Override
	public void haveBreakfast() {
		System.out.println("韩非子:开始吃饭了...");
		notifyObservers("韩非子在吃饭");
	}

	@Override
	public void haveFun() {
		System.out.println("韩非子:开始娱乐了...");
		notifyObservers("韩非子在娱乐");
	}

}
