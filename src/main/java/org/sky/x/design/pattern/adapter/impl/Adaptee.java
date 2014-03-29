package org.sky.x.design.pattern.adapter.impl;

import org.sky.x.design.pattern.adapter.CommentInterface;

public class Adaptee implements CommentInterface {

	public void say() {
	  System.out.println("this is the CommentInterface.say()");
	}

}
