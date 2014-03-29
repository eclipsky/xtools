package org.sky.x.design.pattern.observer.persion;

import org.sky.x.design.pattern.observer.persion.impl.HanFeiZi;
import org.sky.x.design.pattern.observer.persion.impl.LiSi;
import org.sky.x.design.pattern.observer.persion.impl.WangSi;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 6:07:09 PM
 * </p>
 **************************************************************** 
 */
public class Client {
	
public static void main(String[] args) {
		
		//定义李斯 观察者
		Observer liSi = new LiSi();
		Observer wangSi = new WangSi();
		
		//定义韩非子 被观察者
		HanFeiZi hanFeiZi = new HanFeiZi();
		
		hanFeiZi.addObserver(liSi);
		hanFeiZi.addObserver(wangSi);
		
		//然后这里我们看看韩非子在干什么
		hanFeiZi.haveBreakfast();
		
		//韩非子娱乐了
		hanFeiZi.haveFun();
		
	}

}
