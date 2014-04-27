package org.sky.x.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.sky.x.annotation.FruitColor.Colors;

/**
 * @author xieming  2013-11-11 ����02:26:50
 */
public class FruitInfoUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fruitName="ˮ����ƣ�";
		String fruitColor="ˮ����ɫ��";
		String fruitProvider="ˮ��Ӧ�̣�";
		Field[] fs = Apple.class.getDeclaredFields();
		for(Field field : fs){
			if(field.isAnnotationPresent(FruitName.class)){
				String name = field.getAnnotation(FruitName.class).value();
				fruitName += name;
			}else if(field.isAnnotationPresent(FruitColor.class)){
				String name = field.getAnnotation(FruitColor.class).fruitColor().toString();
				fruitColor += name;
			}else if(field.isAnnotationPresent(Provider.class)){
				Provider p = field.getAnnotation(Provider.class);
				int id = p.id();
				String name = p.name();
				String address = p.address();
				fruitProvider = fruitProvider + id + name + address;
			}
		}
		System.out.println(fruitName+"\n"+fruitColor+"\n"+fruitProvider);
	}

}

//ˮ����ע��
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FruitName{
	String value() default "";
}

//ˮ����ɫע��
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FruitColor{
	enum Colors{
		GREEN,RED,BLUE;
	}
	Colors fruitColor() default Colors.BLUE;
}

//ˮ��Ӧ��ע��
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Provider{
	int id() default -1;
	String name() default "";
	String address() default "";
}

//
class Apple{
	@FruitName("�츻ʿ")
	String name;
	
	@FruitColor(fruitColor=Colors.RED)
	String color;
	
	@Provider(id=10086,name="�����츻ʿ",address="���������츻ʿ��ֳ���")
	String provider;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
}