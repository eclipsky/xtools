package org.sky.x.design.pattern.factoryMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.sky.x.design.pattern.factoryMethod.impl.BlackHuman;
import org.sky.x.design.pattern.factoryMethod.impl.WhiteHuman;
import org.sky.x.design.pattern.factoryMethod.impl.YellowHuman;

/**
 * **************************************************************
 * <p>
 * 
 * @DESCRIPTION : 今天讲女娲造人的故事，这个故事梗概是这样的： 很久很久以前，盘古开辟了天地，用身躯造出日月星辰、山川草木，天地一片繁华
 *              One day，女娲下界走了一遭，哎！太寂寞，太孤独了，没个会笑的、会哭的、会说话的东东
 *              那怎么办呢？不用愁，女娲，神仙呀，造出来呀，然后捏泥巴，放八卦炉（后来这个成了太白金星的宝贝）中烤，于是就有了人：
 *              我们把这个生产人的过程用Java程序表现出来：
 * @AUTHOR : andy.meng@xiu.com
 * @DATE :Oct 26, 2012 11:05:42 AM
 *       </p>
 *       ***************************************************************
 */
public class HumanFactory {

	/**
	 * @Description:
	 * @param args
	 */
	public static void main(String[] args) {
		
		//女娲第一次造人，试验性质，少造点，火候不足，缺陷产品
		System.out.println("------------造出的第一批人是这样的：白人-----------------");
		Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
		whiteHuman.cry();
		whiteHuman.laugh();
		whiteHuman.talk();
		
		//女娲第二次造人，火候加足点，然后又出了个次品，黑人
		System.out.println("------------造出的第二批人是这样的：黑人-----------------");
		Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
		blackHuman.cry();
		blackHuman.laugh();
		blackHuman.talk();
		
		//第三批人了，这次火候掌握的正好，黄色人类（不写黄人，免得引起歧义），备注：RB人不属于此列
		System.out.println("------------造出的第三批人是这样的：黄色人类-----------------");
		Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
		yellowHuman.cry();
		yellowHuman.laugh();
		yellowHuman.talk();
		
		//女娲烦躁了，爱是啥人类就是啥人类，烧吧
		for (int i = 0; i < 3; i++) {
			System.out.println("------------随机产生人类了-----------------------------" + i);
			Human human = HumanFactory.createHuman();
			human.cry();
			human.laugh();
			human.talk();
		}
		
	}

	// 定一个烤箱，泥巴塞进去，人就出来，这个太先进了
	@SuppressWarnings("unchecked")
	public static Human createHuman(Class c) {
		Human human = null; // 定义一个类型的人类
		try {
			// 如果MAP中有，则直接从取出，不用初始化了
			if (humans.containsKey(c.getSimpleName())) {
				human = humans.get(c.getSimpleName());
			} else {
				human = (Human) Class.forName(c.getName()).newInstance();
				// 放到MAP中
				humans.put(c.getSimpleName(), human);
			}
		} catch (InstantiationException e) {// 你要是不说个人类颜色的话，没法烤，要白的黑，你说话了才好烤
			System.out.println("必须指定人类的颜色");
		} catch (IllegalAccessException e) { // 定义的人类有问题，那就烤不出来了，这是...
			System.out.println("人类定义错误！");
		} catch (ClassNotFoundException e) { // 你随便说个人类，我到哪里给你制造去？！
			System.out.println("混蛋，你指定的人类找不到！");
		}
		return human;
	}
	
	// 女娲生气了，把一团泥巴塞到八卦炉，哎产生啥人类就啥人类
	@SuppressWarnings("unchecked")
	public static Human createHuman() {
		Human human = null; // 定义一个类型的人类
		// 首先是获得有多少个实现类，多少个人类
		List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class); // 定义了多少人类
		// 八卦炉自己开始想烧出什么人就什么人
		Random random = new Random();
		int rand = random.nextInt(concreteHumanList.size());
		human = createHuman(concreteHumanList.get(rand));
		return human;
	}
	
	private static Map<String,Human> humans = new HashMap<String,Human>();

}
