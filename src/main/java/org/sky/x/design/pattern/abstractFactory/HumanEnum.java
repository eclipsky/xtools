package org.sky.x.design.pattern.abstractFactory;

import org.sky.x.design.pattern.abstractFactory.impl.MaleBlackHuman;
import org.sky.x.design.pattern.abstractFactory.impl.MaleWhiteHuman;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 12:05:56 PM
 * </p>
 **************************************************************** 
 */
public enum HumanEnum {
	
	// 把世界上所有人类型都定义出来
	MaleBlackHuman(MaleBlackHuman.class),
	MaleWhiteHuman(MaleWhiteHuman.class);

	// 定义构造函数，目的是Data(value)类型的相匹配
	@SuppressWarnings("unchecked")
	private HumanEnum(Class c) {
		this.c = c;
	}

	@SuppressWarnings("unchecked")
	public Class getC() {
		return this.c;
	}

	@SuppressWarnings("unchecked")
	private Class c ;

}
