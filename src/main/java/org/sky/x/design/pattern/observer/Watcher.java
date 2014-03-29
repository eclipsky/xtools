package org.sky.x.design.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 * @author IBM
 */
public class Watcher implements Observer {

	public void update(Observable obj, Object arg) {
		System.out.println("Update() called, count is "+ ((Integer) arg).intValue());
	}
	
	public static void main(String[] args) {
		BeingWatched beingWatched = new BeingWatched();// 受查者
		Watcher watcher = new Watcher();// 观察者
		beingWatched.addObserver(watcher);
		beingWatched.counter(10);
	}   
}
