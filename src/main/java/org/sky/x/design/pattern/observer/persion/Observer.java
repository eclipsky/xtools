package org.sky.x.design.pattern.observer.persion;
/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 观察者父接口
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 5:53:11 PM
 * </p>
 **************************************************************** 
 */
public interface Observer {
	
	//一发现别人有动静，自己也要行动起来
	public void update(String context);

}
