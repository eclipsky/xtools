package org.sky.x.design.pattern.abstractFactory;

/**
 * **************************************************************
 * <p>
 * 
 * @DESCRIPTION :
 * @AUTHOR : andy.meng@xiu.com
 * @DATE :Oct 26, 2012 12:03:04 PM
 *       </p>
 *       ***************************************************************
 */
public class MaleHumanFactory extends AbstractHumanFactory {

	// 创建一个男性黑种人
	@Override
	public Human createBlackHuman() {
		return super.createHuman(HumanEnum.MaleBlackHuman);
	}

	// 创建一个男性白种人
	@Override
	public Human createWhiteHuman() {
		return super.createHuman(HumanEnum.MaleWhiteHuman);
	}

	// 创建一个男性黄种人
	@Override
	public Human createYellowHuman() {
		return null;
	}
	
	public static void main(String[] args) {
		
		HumanFactory maleHumanFactory = new MaleHumanFactory();
		Human blackHuman = maleHumanFactory.createBlackHuman();
		if (blackHuman != null) {
			blackHuman.laugh();
			blackHuman.cry();
			blackHuman.talk();
			blackHuman.sex();
		}
	}

}
