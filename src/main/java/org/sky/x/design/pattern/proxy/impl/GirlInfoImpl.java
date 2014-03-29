package org.sky.x.design.pattern.proxy.impl;

import org.sky.x.design.pattern.proxy.GirlInfo;

public class GirlInfoImpl implements GirlInfo {

	public void hasBoyFriend() {
	   System.out.println("这个女孩还没有男朋友");
	}
	
	public void BoyFriendSmart() {
	   System.out.println("这个女孩的男朋友很帅");
	}
}
