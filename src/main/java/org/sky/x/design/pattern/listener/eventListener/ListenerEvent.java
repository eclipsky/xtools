package org.sky.x.design.pattern.listener.eventListener;

import java.util.EventObject;

/**
 * 其次定义事件（状态）对象（该事件对象包装了事件源对象、作为参数传递给监听器、很薄的一层包装类）
 * @author IBM
 */
public class ListenerEvent extends EventObject{

	public ListenerEvent(Object source) {
		super(source);
	}
	
	public void say() {
        System.out.println("This is say method...");
    }

	private static final long serialVersionUID = 1L;
}
