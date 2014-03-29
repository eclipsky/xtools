package org.sky.x.design.pattern.abstractFactory;
/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 定义一个人类的统称
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 10:57:27 AM
 * </p>
 **************************************************************** 
 */
public interface Human {
	
	//人是愉快的，会笑的，本来是想用smile表示，想了一下laugh更合适，好长时间没有大笑了；
	public void laugh();
	
	//人类还会哭，代表痛苦
	public void cry();
	
	//人类会说话
	public void talk();
	
	//定义性别
	public void sex();

}
