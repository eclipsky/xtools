package org.sky.x.design.pattern.strategy;

import org.sky.x.design.pattern.strategy.impl.BackDoor;
import org.sky.x.design.pattern.strategy.impl.BlockEnemy;
import org.sky.x.design.pattern.strategy.impl.GivenGreenLight;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 计谋有了，那还要有锦囊
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 25, 2012 9:39:20 AM
 * </p>
 **************************************************************** 
 */
public class Context {
	
	public Context(IStrategy strategy) {
		this.straegy = strategy;
	}

	// 使用计谋了，看我出招了
	public void operate() {
		this.straegy.operate();
	}
	
	// 构造函数，你要使用那个妙计
	private IStrategy straegy;
	
	public static void main(String[] args) {
		
		Context context;
		
		//刚刚到吴国的时候拆第一个
		System.out.println("-----------刚刚到吴国的时候拆第一个-------------");
		context = new Context(new BackDoor()); //拿到妙计
		context.operate(); //拆开执行
		System.out.println("\n");
		
		//刘备乐不思蜀了，拆第二个了
		System.out.println("-----------刘备乐不思蜀了，拆第二个了-------------");
		context = new Context(new GivenGreenLight());
		context.operate(); //执行了第二个锦囊了
		System.out.println("\n");
		
		//孙权的小兵追了，咋办？拆第三个
		System.out.println("-----------孙权的小兵追了，咋办？拆第三个-------------");
		context = new Context(new BlockEnemy());
		context.operate(); //孙夫人退兵
		System.out.println("\n");
		
	}

}
