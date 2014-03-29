package org.sky.x.design.pattern.abstractFactory;
/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * 这次定一个接口，应该要造不同性别的人，需要不同的生产线
 * 那这个八卦炉必须可以制造男人和女人
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 11:48:01 AM
 * </p>
 **************************************************************** 
 */
public interface HumanFactory {

	// 制造黄色人类
	public Human createYellowHuman();

	// 制造一个白色人类
	public Human createWhiteHuman();

	// 制造一个黑色人类
	public Human createBlackHuman();

}
