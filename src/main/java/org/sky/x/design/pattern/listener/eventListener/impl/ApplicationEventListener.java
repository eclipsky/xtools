package org.sky.x.design.pattern.listener.eventListener.impl;

import org.sky.x.design.pattern.listener.eventListener.EventListenerInterface;
import org.sky.x.design.pattern.listener.eventListener.ListenerEvent;

/**
 * 定义具体的事件监听器
 * @author IBM
 */
public class ApplicationEventListener implements EventListenerInterface {

	public void handleEvent(ListenerEvent listenerEvent) {
		 System.out.println("Inside ApplicationEventListener...");   
		 listenerEvent.say();    //回调	
    }
	
	public static void main(String[] args){
		
	}
}
