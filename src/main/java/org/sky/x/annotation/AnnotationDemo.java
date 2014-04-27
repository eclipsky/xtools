package org.sky.x.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieming  2013-11-8 ����09:19:55
 */
public class AnnotationDemo {
	
	@Override
	public String toString(){
		return "toString";
	}
	
	public static  void main(String[] args){
//		System.out.println(new AnnotationDemo());
//		DeprecatedClass.deprecatedMethod();
//		saying();
		sayHelloWithDefaultFontColor();
		sayHelloWithRedFontColor();
	}
		
	@Greeting(name="defaultFontColor")
	public static void sayHelloWithDefaultFontColor(){
		
	}
	
	@Greeting(name="myFontColor",fontColor=Greeting.FontColor.BLUE)
	public static void sayHelloWithRedFontColor(){
		
	}
}

class DeprecatedClass{
	@Deprecated
	public static void deprecatedMethod(){};
}

class SuppressWarningsClass{
	public static List list = new ArrayList();
	
	@SuppressWarnings("unchecked")
	public static void addElement(String data){
		list.add(data);
	}
}

  