package org.sky.x.design.pattern.prototype;

import java.util.List;

public class ConcretePrototype extends Prototype {
	
	public ConcretePrototype () {
		System.out.println("ConcretePrototype原型模式实现类构造函数");
	}

	@SuppressWarnings("unchecked")
	public void dispalyConcretePrototype(int i) {
		System.out.println("dispalyConcretePrototype原型模式实现类"+i+"student.toString()"+student.toString());
		arrayList.add(i);
	}
	
	public void displyList2() {
		if (tempList==null) {
			System.out.println("tempList==null 原型模式是浅度拷贝");
			return;
		}
		StringBuffer sb = new StringBuffer();
		for (String element : tempList) {
			sb.append(element);
		}
		System.out.println(sb.toString());
	}
	
	private static List<String> tempList = null;

	public static void main(String[] args) {
		ConcretePrototype cp = new ConcretePrototype();
		cp.dispalyPrototype(-1);
		cp.dispalyConcretePrototype(-1);
		cp.displyList1();
		tempList = cp.list;
		cp.displyList2();
		tempList = null;
		System.out.println(cp.arrayList.get(0));
		for (int i = 0; i < 1; i++) {
			ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
			clonecp.dispalyPrototype(i);
			clonecp.dispalyConcretePrototype(i);
			clonecp.displyList1();
			tempList = clonecp.list;
			clonecp.displyList2();
			if (clonecp.arrayList!=null) {
				System.out.println(clonecp.arrayList.get(0));
			}
		}
	}

}
