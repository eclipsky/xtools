package org.sky.x.design.pattern.abstractFactory;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 编写一个抽象类，根据enum创建一个人类出来
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 11:50:03 AM
 * </p>
 **************************************************************** 
 */
public abstract class AbstractHumanFactory implements HumanFactory {
	/*
	 * 给定一个性别人类，创建一个人类出来专业术语是产生产品等级
	 */
	@SuppressWarnings("unchecked")
	protected Human createHuman(HumanEnum humanEnum) {
		Human human = null;
		Class c = humanEnum.getC();
		// 如果传递进来不是一个Enum中具体的一个Element的话，则不处理
		if (c != null) {
			try {
				// 直接产生一个实例
				human = (Human) Class.forName(c.getName()).newInstance();
			} catch (Exception e) {
                e.printStackTrace();
			}
		}
		return human;
	}
	
}
