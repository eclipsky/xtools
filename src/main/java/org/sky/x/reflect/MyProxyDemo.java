package org.sky.x.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xieming  2013-11-16 上午02:19:44
 */
public class MyProxyDemo{
	public static void main(String[] args) throws Exception{
		//业务对象
		A target = new MyImplements();
		//调用对象
		MyInvocationHandler handler = new MyInvocationHandler(target);
//		A proxy = (A) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
		/**
		 * 分步骤实现newProxyInstance方法
		 */
		//1.生成代理类的Class对象
		Class<?> clazz = Proxy.getProxyClass(target.getClass().getClassLoader(),target.getClass().getInterfaces());
		//2.指定handler返回构造类
		Constructor<?> cons = clazz.getConstructor(new Class[]{MyInvocationHandler.class});
		//3.通过构造类生成对象
		A proxy = (A) cons.newInstance(new Object[]{handler});
		proxy.printA();
	}
}

class MyInvocationHandler implements InvocationHandler{

	public Object target;
	
	public MyInvocationHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("----------before invocation----------");
		Object result = method.invoke(target, args);
		System.out.println("----------after invocation----------");
		return result;
	}
	
}

class MyImplements implements A,B{

	@Override
	public void printA() {
		// TODO Auto-generated method stub
		System.out.println("method printA invocation");
	}
	
	@Override
	public void printB() {
		// TODO Auto-generated method stub
		System.out.println("method printB invocation");
	}
	
}

interface A{
	void printA();
}

interface B{
	void printB();
}
