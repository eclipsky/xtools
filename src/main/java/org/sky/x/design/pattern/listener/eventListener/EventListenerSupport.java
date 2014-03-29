package org.sky.x.design.pattern.listener.eventListener;

import java.util.Enumeration;
import java.util.Vector;

import org.sky.x.design.pattern.listener.eventListener.impl.ApplicationEventListener;

/**
 * 首要定义事件源对象（事件源相当于单击按钮事件当中的按钮对象、属于被监听者）
 * @author IBM
 */
public class EventListenerSupport {
	
    public EventListenerSupport(){
    	
    }
    
    public void addEventListener(EventListenerInterface eventListenerInterface) {
		repository.addElement(eventListenerInterface);
	}
    
    public void notifyEventListener() {// 通知所有的监听器
		Enumeration<EventListenerInterface> enumeration = repository.elements();
		while (enumeration.hasMoreElements()) {
			EventListenerInterface eventListenerInterface = (EventListenerInterface) enumeration.nextElement();
			eventListenerInterface.handleEvent(new ListenerEvent(this));
		}
	}
    
    private Vector<EventListenerInterface> repository = new Vector<EventListenerInterface>();//监听自己的监听器队列
    
    public static void main(String[] args) {
		EventListenerSupport eventListenerSupport = new EventListenerSupport();
		EventListenerInterface applicationEventListener = new ApplicationEventListener();
		eventListenerSupport.addEventListener(applicationEventListener);
		eventListenerSupport.addEventListener(new EventListenerInterface() {
			public void handleEvent(ListenerEvent listenerEvent) {
				System.out.println("Method come from 匿名类...");
			}});
		eventListenerSupport.notifyEventListener();
	}
}
