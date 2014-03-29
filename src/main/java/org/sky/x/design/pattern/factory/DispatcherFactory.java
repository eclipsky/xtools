package org.sky.x.design.pattern.factory;

import org.sky.x.design.pattern.factory.impl.ExclusiveDispatcher;
import org.sky.x.design.pattern.factory.impl.NormalDispatcher;
import org.sky.x.design.pattern.factory.impl.SequenceDispatcher;

public class DispatcherFactory {

	public static AbstractDispatcher getDispatcherInstance(int taskGroupType) {
		if (taskGroupType == 0) {
			return new NormalDispatcher();
		} else if (taskGroupType == 1) {
			return new SequenceDispatcher();
		} else if (taskGroupType == 2) {
			return new ExclusiveDispatcher();
		}
		return null;
	}

	public static void main(String[] args) {
		AbstractDispatcher normalDispatcher = DispatcherFactory.getDispatcherInstance(0);
		System.out.println("DispatcherFactory.getDispatcherInstance(0).doDispatcher()");
		normalDispatcher.doDispatcher();
		
		AbstractDispatcher sequenceDispatcher = DispatcherFactory.getDispatcherInstance(1);
		System.out.println("DispatcherFactory.getDispatcherInstance(0).doDispatcher()");
		sequenceDispatcher.doDispatcher();
		
		AbstractDispatcher exclusiveDispatcher = DispatcherFactory.getDispatcherInstance(2);
		System.out.println("DispatcherFactory.getDispatcherInstance(0).doDispatcher()");
		exclusiveDispatcher.doDispatcher();
	}
}
