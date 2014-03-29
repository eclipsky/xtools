package org.sky.x.design.pattern.proxy;

import org.sky.x.design.pattern.proxy.impl.GirlInfoImpl;

/**
 * 静态代理类implements GirlInfo接口，而动态代理类implements InvocationHandler接口
 * 实际上这里就可以体现出静态代理的局限性了，静态代理必须实现接口的所有方法，而动态代理不用
 * @author IBM
 */
public class GirlStaticProxy implements GirlInfo {

	@Override
	public void BoyFriendSmart() {
		printString("调用BoyFriendSmart()之前可以做一些事情");
		girlInfoImpl.BoyFriendSmart();
		printString("调用BoyFriendSmart()之后可以做一些事情");
	}

	@Override
	public void hasBoyFriend() {
		girlInfoImpl.BoyFriendSmart();
	}
	
	public GirlStaticProxy(GirlInfo girlInfoImpl) {
		this.girlInfoImpl = girlInfoImpl;
	}

	private void printString(String printString) {
		System.out.println(printString);
	}

	private GirlInfo girlInfoImpl;

	public static void main(String[] args) {
		GirlInfo girlInfoImpl = new GirlInfoImpl();
		GirlStaticProxy girlStaticProxy = new GirlStaticProxy(girlInfoImpl);
		girlStaticProxy.BoyFriendSmart();
	}
}
