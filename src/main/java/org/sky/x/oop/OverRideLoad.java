package org.sky.x.oop;

import java.util.*;

/**
 * @author xieming  2013-10-20 ÏÂÎç04:36:56
 */
public class OverRideLoad {
	public static void main(String[] args){
		Sam sam = new Sam();
		System.out.println((new Sam().a));
	}
}

class Boy{
	int a = 5;
	int b =10;
	List getList(int a){
		return new LinkedList();
	}
}

class Sam extends Boy{
	int a = 6;
	int getA(){
		return super.a;
	}
	int getB(){
		return b;
	}
	ArrayList getAList(int a){
		return new ArrayList();
	}
}
