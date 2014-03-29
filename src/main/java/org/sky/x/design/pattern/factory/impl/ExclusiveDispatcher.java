package org.sky.x.design.pattern.factory.impl;

import java.util.Date;

import org.sky.x.design.pattern.factory.AbstractDispatcher;

/**
 * 功能描述：此调动器专门负责对 任务组类型为2：排他组 类型的job进行调度处理。
 * 
 * @author menglei
 * @date 2011-06-13
 * @version 1.0
 */

public class ExclusiveDispatcher extends AbstractDispatcher {
	
	@Override
	public void doDispatcher() {
		System.out.println("ExclusiveDispatcher调度器程序调度时间："+new Date()+" ,ExclusiveDispatcher调度器程序调度类"+ExclusiveDispatcher.class);
	}
}
