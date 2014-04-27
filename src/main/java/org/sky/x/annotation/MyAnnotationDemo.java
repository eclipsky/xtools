package org.sky.x.annotation;

import java.lang.reflect.Method;

/**
 * @author xieming  2013-11-11 ����11:50:19
 */
public class MyAnnotationDemo {
	
	@MyAnnotation(id=1,description="first method")
	public void method_first(){};
	
	@MyAnnotation(id=1)
	public void method_default(){};
	
	@MyAnnotation(id=1,description="last method")
	public void method_last(){};
	
	@SingleValue("michael")
	public void method_single(){};
	
	public static void main(String[] args) throws ClassNotFoundException{
		Method[] methods = MyAnnotationDemo.class.getDeclaredMethods();
		for(Method m : methods){
			//�ж��Ƿ���ע�����ͱ���
//			System.out.println(m.getName());
			boolean flag = m.isAnnotationPresent(MyAnnotation.class);
			if(flag){
				MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
				System.out.println(m.getName()+"\t"+annotation.id()+"\t"+annotation.description());
			}
		}
	}
}
