package org.sky.x.design.pattern.adapter;

import org.sky.x.design.pattern.adapter.impl.Adaptee;

public class Adapter extends Adaptee implements TargetInterface {

	public void speak() {
		System.out.println("this is the TargetInterface.speak()");
	}

	public static void main(String[] args) {
		Adapter adapter = new Adapter();
		adapter.say();
		adapter.speak();
	}
}
