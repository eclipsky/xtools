package org.sky.x.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xieming  2013-11-10 ����07:04:01
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation{
	public int id();
	public String description() default "no description";
}

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Greeting{
	public enum FontColor{
		BLUE,RED,GREEN;
	}
	String name();
	FontColor fontColor() default FontColor.BLUE;
}

@interface SingleValue{
	String value() default "singleValue";
}


