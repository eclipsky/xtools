package org.sky.x.design.pattern.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prototype implements Cloneable {
	
	public Prototype() {
		System.out.println("Prototype原型模式基类构造函数");
	}
	
	@SuppressWarnings("unchecked")
	public void dispalyPrototype(int i) {
		System.out.println("dispalyPrototype原型模式基类"+i+"student.toString()"+student.toString());
		arrayList.add(i);
	}
	
	@Override
	public Prototype clone() {
		Prototype prototype = null;
		try {
			prototype = (Prototype) super.clone();
			//深度拷贝就是 原型与其子类对于引用型数据 是共用一个引用；而浅度拷贝 原型与其子类对于引用数据 其各有一个数据拷贝，每一个有一个数据存储
			//解决深度拷贝的问题 
			//prototype.arrayList = (ArrayList) this.arrayList.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}

	public void displyList1() {
		StringBuffer sb = new StringBuffer();
		for (String element : list) {
			sb.append(element);
		}
		System.out.println(sb.toString());
	}
	
	public List<String> list = Arrays.asList(new String[]{"a","b","c"}); 
	
	@SuppressWarnings("unchecked")
	public ArrayList arrayList = new ArrayList();
	
	public Student student = new Student("menglei");
	
	 class Student {
		
		public Student (String name) {
			this.name = name ;
		}
		
		public String toString() {
			return name;
		}
		
		private String name ;
	 }

}
