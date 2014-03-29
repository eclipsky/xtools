package org.sky.x.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.sky.x.design.pattern.proxy.impl.GirlInfoImpl;

/**
 * 动态代理类：在程序运行时，运用反射机制动态创建而成。
 * 代理类可以为委托类预处理消息、把消息转发给委托类和事后处理消息等.
 * 动态代理类的字节码在程序运行时由Java反射机制动态生成，无需程序员手工编写它的源代码。
 * 动态代理类不仅简化了编程工作，而且提高了软件系统的可扩展性，
 * 因为Java 反射机制可以生成任意类型的动态代理类
 * @author IBM
 */
public class GirlDynamicProxy implements InvocationHandler {

	//拦截关联的这个实现类的方法被调用时将被执行
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("在动态代理类调用反射对象之前.可以做一些事情 比如spring中的aop");
		method.invoke(delegate, args);
		System.out.println("在动态代理类调用反射对象之后可以做一些事情 比如spring中的aop");
		return null;
	}
	
    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(),delegate.getClass().getInterfaces(), this);
    }
    
    @SuppressWarnings("unused")
	private Object delegate;

	public static void main(String[] args) {
		GirlDynamicProxy girlDynamicProxy = new GirlDynamicProxy();
		GirlInfo girlInfoImpl = (GirlInfo) girlDynamicProxy.bind(new GirlInfoImpl());
		System.out.println("通过(GirlInfo) girlDynamicProxy.bind(new GirlInfoImpl()).hasBoyFriend()输出：");
		girlInfoImpl.hasBoyFriend();
		
		GirlInfo girlInfoImpl2 = new GirlInfoImpl();
		System.out.println("通过new GirlInfoImpl().hasBoyFriend()输出：");
		girlInfoImpl2.hasBoyFriend();
	}
}
