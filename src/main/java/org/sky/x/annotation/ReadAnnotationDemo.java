package org.sky.x.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author xieming 2013-11-10 ����08:49:11
 */
public class ReadAnnotationDemo {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("com.sam.annotation.AnnotationDemo");
		Method[] methods = c.getDeclaredMethods();
		Annotation[] annotations;
		for (Method m : methods) {
			System.out.println("������"+ m.getName());
			annotations = m.getDeclaredAnnotations();
			for (Annotation a : annotations) {
				System.out.println("������" + m.getName() + "\tע����"
						+ a.annotationType().getSimpleName());
				Method[] ms = a.annotationType().getDeclaredMethods();
				for (Method method : ms) {
					System.out.println(method.getName());
				}
			}
		}
	}
}
