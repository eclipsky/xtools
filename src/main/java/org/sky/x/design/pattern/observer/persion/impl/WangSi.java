package org.sky.x.design.pattern.observer.persion.impl;

import org.sky.x.design.pattern.observer.persion.ILiSi;
import org.sky.x.design.pattern.observer.persion.Observer;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 4:46:25 PM
 * </p>
 **************************************************************** 
 */
public class WangSi implements Observer,ILiSi {

	@Override
	public void update(String context) {
		System.out.println("王斯:观察到韩非子活动，开始向老板汇报了...");
		this.reportToQiShiHuang(context);
		System.out.println("王斯：汇报完毕，秦老板赏给他两个萝卜吃吃...");
	}

	// 汇报给秦始皇
	@Override
	public void reportToQiShiHuang(String reportContext) {
		System.out.println("王斯：报告，秦老板！韩非子有活动了--->" + reportContext);
	}

}
