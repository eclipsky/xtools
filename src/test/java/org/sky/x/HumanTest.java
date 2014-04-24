package org.sky.x;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void say();
}

class WhiteHuman implements Human{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("白人");
	}
	
}

class HumanProxy{
	private Human human;
	
	public HumanProxy(Human human){
		this.human = human;
	}
	
	public void say(){
		System.out.println("静态代理开始...");
		human.say();
		System.out.println("静态代理结束...");
	}
}

class HumanProxyDynamic implements InvocationHandler{

	private Object obj;
	
	public HumanProxyDynamic(Object obj){
		this.obj= obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("动态代理开始...");
		Object result = method.invoke(obj, args);
		System.out.println("动态代理结束...");
		return result;
	}
	
}

class HumanTest{
	public static void main(String[] args){
		Human human = new WhiteHuman();
		/**静态代理*/
		new HumanProxy(human).say();
		/**动态代理*/
		InvocationHandler handler = new HumanProxyDynamic(human);
		Human h = (Human)Proxy.newProxyInstance(human.getClass().getClassLoader(), human.getClass().getInterfaces(), handler);
		h.say();
	}
}
