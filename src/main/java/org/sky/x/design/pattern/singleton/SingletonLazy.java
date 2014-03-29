package org.sky.x.design.pattern.singleton;

public class SingletonLazy {

	public static synchronized SingletonLazy getInstance1() {
		// 解决多线程下，单例模式安全性
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
	
	public static SingletonLazy getInstance2() {
		// 解决多线程下，单例模式安全性，较1在一定情况下，更高效
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new SingletonLazy();
				}
			}
		}
		return instance;
	}

	private SingletonLazy() {

	}

	private static SingletonLazy instance = null;

	public static void main(String[] args) {
		SingletonLazy singletonTest1 = SingletonLazy.getInstance1();
		SingletonLazy singletonTest2 = SingletonLazy.getInstance2();
		System.out.println("singletonTest1.equals(singletonTest2): "+ singletonTest1.equals(singletonTest2));
		System.out.println("singletonTest1==singletonTest2: "+ (singletonTest1 == singletonTest2));
	}
}
