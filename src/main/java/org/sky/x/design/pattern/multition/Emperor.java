package org.sky.x.design.pattern.multition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * **************************************************************
 * <p>
 * 
 * @DESCRIPTION :
 * @AUTHOR : andy.meng@xiu.com
 * @DATE :Oct 26, 2012 10:34:47 AM
 *       </p>
 *       ***************************************************************
 */
@SuppressWarnings("all")
public class Emperor {

	/**
	 * @Description:
	 * @param args
	 */
	public static void main(String[] args) {
		int ministerNum = 10; // 10个大臣
		for (int i = 0; i < ministerNum; i++) {
			Emperor emperor = Emperor.getInstance();
			System.out.println("第" + (i + 1) + "个大臣参拜的是："+ emperor.getEmperorName());
		}
	}

	// 就这么多皇帝了，不允许再推举一个皇帝(new 一个皇帝）
	private Emperor() {
	// 世俗和道德约束你，目的就是不让你产生第二个皇帝
	}

	private Emperor(String name) {
		emperorNameList.add(name);
	}

	// 正在被人尊称的是那个皇帝对象信息
	public static Emperor getInstance() {
		Random random = new Random();
		countNumOfEmperor = random.nextInt(maxNumOfEmperor); // 随机拉出一个皇帝，只要是个精神领袖就成
		return (Emperor) emperorObjectList.get(countNumOfEmperor);
	}

	// 正在被人尊称的是那个皇帝名字
	public static String getEmperorName() {
		return emperorNameList.get(countNumOfEmperor);
	}
	
	private static int maxNumOfEmperor = 2;                                                  // 最多只能有连个皇帝
	private static List<String> emperorNameList = new ArrayList<String>(maxNumOfEmperor);    // 皇帝名字列表
	private static List<Emperor> emperorObjectList = new ArrayList<Emperor>(maxNumOfEmperor); // 装皇帝对象列表；
	private static int countNumOfEmperor = 0;                                                 // 正在被人尊称的是那个皇帝
	
	// 先把2个皇帝产生出来
	static {
		// 把所有的皇帝都产生出来
		for (int i = 0; i < maxNumOfEmperor; i++) {
			emperorObjectList.add(new Emperor("皇" + (i + 1) + "帝"));
		}
	}

}
