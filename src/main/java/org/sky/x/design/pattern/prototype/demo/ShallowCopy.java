package org.sky.x.design.pattern.prototype.demo;

import java.util.ArrayList;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : java中的浅拷贝
 *                Object类提供的方法clone只是拷贝本对象，其对象内部的数组、引用对象等都不拷贝，
		          还是指向原生对象的内部元素地址，这种拷贝就叫做浅拷贝，确实是非常浅，两个对象共享了一个私有变量arrayList
		          内部的数组和引用对象才不拷贝，其他的原始类型比如int,long,String(Java就希望你把String认为是基本类型，
		          String是没有clone方法的)等都会被拷贝的
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Nov 5, 2012 3:25:27 PM
 * </p>
 **************************************************************** 
 */
public class ShallowCopy implements Cloneable {
	
	public static void main(String[] args) {

		// 产生一个对象
		ShallowCopy thing = new ShallowCopy();
		thing.setValue("张三");
		System.out.println("(thing.getValue()):"+(thing.getValue()));

		// 拷贝一个对象
		ShallowCopy cloneThing = thing.clone();
		cloneThing.setValue("李四");
		
		//是因为Java做了一个偷懒的拷贝动作，Object类提供的方法clone只是拷贝本对象，其对象内部的数组、引用对象等都不拷贝，
		//还是指向原生对象的内部元素地址，这种拷贝就叫做浅拷贝，确实是非常浅，两个对象共享了一个私有变量arrayList
		//内部的数组和引用对象才不拷贝，其他的原始类型比如int,long,String(Java就希望你把String认为是基本类型，String是没有clone方法的)等都会被拷贝的
		System.out.println("(cloneThing.getValue()):"+cloneThing.getValue());
		System.out.println("(thing.getValue()):"+thing.getValue());
		
		System.out.println("(thing.getValue()==cloneThing.getValue()):"+(thing.getValue()==cloneThing.getValue()));
		
		//cloneThing和thing是两个不同的对象，他们有不同的内存地址分配
		System.out.println("(cloneThing == thing):"+(cloneThing == thing));

	}

	@Override
	public ShallowCopy clone() {
		ShallowCopy shallowCopy = null;
		try {
			shallowCopy = (ShallowCopy) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return shallowCopy;
	}

	// 设置HashMap的值
	public void setValue(String value) {
		this.arrayList.add(value);
	}

	// 取得arrayList的值
	public ArrayList<String> getValue() {
		return this.arrayList;
	}

	// 定义一个私有变量
	private ArrayList<String> arrayList = new ArrayList<String>();

}
