package org.sky.x.design.pattern.singleton;

public class SingletonInit {

	// 这里提供了一个供外部访问本class的静态方法，可以直接访问
	public static SingletonInit getInstance1() {
		return instance1;
	}

	private SingletonInit() {

	}

	// 这是private 只供内部调用
	private static final SingletonInit instance1 = new SingletonInit();

	public static void main(String[] args) {
		SingletonInit singletonTest1 = SingletonInit.getInstance1();
		SingletonInit singletonTest2 = SingletonInit.getInstance1();
		System.out.println("singletonTest1.equals(singletonTest2): "+ singletonTest1.equals(singletonTest2));
		System.out.println("singletonTest1==singletonTest2: "+ (singletonTest1 == singletonTest2));
	}
}
