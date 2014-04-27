package org.sky.x.tij.c05;

import org.sky.x.tij.c04.PackageClass1;


class AccessClass1 extends PackageClass1{
	
	protected void protectedMethod(){
		super.protectedMethod();
		System.out.println("protectedMethod()--AccessClass1");
	}
	
	public static void main(String[] args){
		
		
		System.out.println("AccessClass1 Start");
		AccessClass1 ac = new AccessClass1();
		PackageClass1 t1 = new PackageClass1();
//		PackageClass t2 = new PackageClass("a");//不是public无法调用
		
		ac.a = 3;
		ac.b = 4;
		t1.a = 3;
		t1.publicMethod();
		ac.protectedMethod();
		System.out.println("AccessClass1 End");
	}
}
class AccessClass2{
	
	public static void main(String[] args){
		System.out.println("AccessClass2 Start");
		AccessClass2 ac = new AccessClass2();
		PackageClass2 t2 = new PackageClass2();
		t2.a = 3;
		t2.b = 4;
		t2.c = 5;
		t2.publicMethod();
//		t2.p
		System.out.println("AccessClass2 End");
	}
}
