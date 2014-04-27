package org.sky.x.tij.c05;

import org.sky.x.tij.c04.PackageClass1;

class MyClass1 {
	void main(){
		System.out.println("MyClass1");
	}
}

public class MyClass extends PackageClass1{
	public static void main(String[] args){
		System.out.println("Myclass");
		new MyClass1().main();
	}
//	PackageClass t1 = new PackageClass("a");//不是public无法调用
}
