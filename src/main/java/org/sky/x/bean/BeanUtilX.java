package org.sky.x.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilX {

	/**
	 * 将map键值对转换为对应的javaBean的属性-值
	 * @param map
	 * @param javaBean
	 * @return
	 */
	public static Object map2Bean(Map<String, Object> map, Object javaBean) {
		Class<?> clazz = javaBean.getClass();
		while (null != clazz) {
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("set")) {
					String field = method.getName().substring(3);
					if (field.length() >= 2
							&& Character.isLowerCase(field.charAt(1))) {
						field = field.toLowerCase().charAt(0)
								+ field.substring(1);
					}
					try {
						method.invoke(javaBean, new Object[] { map.get(field) });
					} catch (Exception e) {
						System.out.println("map转换为javaBean失败");
					}
				}
			}
			clazz = clazz.getSuperclass();// 如果有父类，继续给父类属性赋值
		}
		return javaBean;
	}

	/**
	 * 将javaBean的属性-值转换为对应的map键值对
	 * @param javaBean
	 * @param ignoreNull
	 * @return
	 */
	public static Map<String, Object> bean2Map(Object javaBean,boolean ignoreNull) {
		Map<String, Object> map = new HashMap<String, Object>();
		Class<?> clazz = javaBean.getClass();
		while (null != clazz) {
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					if(method.getName()=="getClass")continue;
					String field = method.getName().substring(3);
					if (field.length() >= 2
							&& Character.isLowerCase(field.charAt(1))) {
						field = field.toLowerCase().charAt(0) + field.substring(1);
					}
					try {
						Object value = method.invoke(javaBean);
						if((ignoreNull && value != null) || !ignoreNull){
							map.put(field,value);
						}
					} catch (Exception e) {
						System.out.println("javaBean转换为map失败");
					} 
				}
			}
			clazz = clazz.getSuperclass();
		}
		return map;
	}

	public static void main(String[] args) {
		// Map<String,Object> data = new HashMap<String,Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 123);
		map.put("name", "sam");
		map.put("addr", "hollywood north to northwest");
		map.put("IP", "192.168.0.1");
		map.put("xRay", "xRay-dog");
		map.put("operator", "sam@oneplus.cn");

		StandardBean javaBean = new StandardBean();
		map2Bean(map, javaBean);
		Field[] fs = javaBean.getClass().getDeclaredFields();
		System.out.println(fs);
		System.out.println("id:" + javaBean.getId());
		System.out.println("name:" + javaBean.getName());
		System.out.println("addr:" + javaBean.getAddr());
		System.out.println("IP:" + javaBean.getIP());
		System.out.println("xRay:" + javaBean.getxRay());
		System.out.println("operator:" + javaBean.getOperator());
		
		Map<String,Object> map1 = bean2Map(javaBean,false);
		Map<String,Object> map2 = bean2Map(javaBean,true);
		System.out.println(map1);
		System.out.println(map2);
	}

}
