package org.sky.x.design.pattern.observer.persion;

import java.util.ArrayList;
import java.util.List;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 被观察者父类
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 26, 2012 5:51:05 PM
 * </p>
 **************************************************************** 
 */
public class Observable {
	
	// 增加观察者
	public void addObserver(Observer observer) {
		this.observerList.add(observer);
	}

	// 删除观察者
	public void deleteObserver(Observer observer) {
		this.observerList.remove(observer);
	}

	// 通知所有的观察者
	public void notifyObservers(String context) {
		for (Observer observer : observerList) {
			observer.update(context);
		}
	}

	// 定义个变长数组，存放所有的观察者
	private List<Observer> observerList = new ArrayList<Observer>();

}
