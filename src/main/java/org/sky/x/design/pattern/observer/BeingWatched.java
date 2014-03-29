package org.sky.x.design.pattern.observer;

import java.util.Observable;

/**
 * 受查者
 * @author IBM
 */
public class BeingWatched extends Observable {
	
	public void counter(int period) {
		for (; period >= 0; period--) {
			setChanged();
			notifyObservers(new Integer(period));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Sleep interrupeted");
			}
		}
	}
	
}
