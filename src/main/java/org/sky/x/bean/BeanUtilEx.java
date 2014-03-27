package org.sky.x.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimeConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;
import org.json.JSONObject;

public class BeanUtilEx extends BeanUtils {
	
	private BeanUtilEx() {}

	static {
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
		ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
		ConvertUtils.register(new SqlTimeConverter(null), java.sql.Time.class);
		ConvertUtils.register(new SqlTimeConverter(null), java.sql.Time.class);
	}
	
	public static void copyProperties(Object target, Object source){
		try {
			BeanUtils.copyProperties(target, source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(Object bean, String name) {
		String str = null;
		try {
			str = BeanUtils.getProperty(bean,name);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static Map<String, Object> toMap(Object javaBean) {
		return toMap(javaBean,false);
	}
	
	/**
	 * 将javaBean转换成Map
	 * @param javaBean javaBean
	 * @return Map对象
	 */
	public static Map<String, Object> toMap(Object javaBean,boolean includeNull) {
		Map<String, Object> result = new HashMap<String, Object>();
		//获取父类的参数
		Class<?> superClazz = javaBean.getClass().getSuperclass();
		while (superClazz != Object.class) {
			Method[] methods = javaBean.getClass().getSuperclass().getDeclaredMethods();
			for (Method method : methods) {
				try {
					if (method.getName().startsWith("get")) {
						String field = method.getName();
						field = field.substring(3);
						field = field.toLowerCase().charAt(0)+field.substring(1);
						Object value = method.invoke(javaBean);
						if(value == null && !includeNull) continue;
						result.put(field, value);
					}
				} catch (Exception e) {
					throw new RuntimeException("JavaBean转化Map出错");
				}
			}
			superClazz = superClazz.getClass().getSuperclass();
		}
		//获取自己的属性
		Method[] methods = javaBean.getClass().getDeclaredMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("get")) {
					String field = method.getName();
					field = field.substring(3);
					field = field.toLowerCase().charAt(0)+field.substring(1);
					Object value = method.invoke(javaBean);
					if(value == null && !includeNull) continue;
					result.put(field, value);
				}
			} catch (Exception e) {
				throw new RuntimeException("JavaBean转化Map出错");
			}
		}
		return result;
	}

	/**
	 * 将json对象转换成Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> toMap(JSONObject jsonObject) {
		Map<String, String> result = new HashMap<String, String>();
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = jsonObject.getString(key);
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 将javaBean转换成JSONObject
	 */
	public static JSONObject toJSON(Object bean) {
		return new JSONObject(toMap(bean));
	}

	/**
	 * 将map转换成Javabean
	 */
	public static Object toJavaBean(Object javabean, Map<String, String> data) {
		Method[] methods = javabean.getClass().getDeclaredMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("set")) {
					String field = method.getName();
					field = field.substring(field.indexOf("set") + 3);
					field = field.toLowerCase().charAt(0) + field.substring(1);
					method.invoke(javabean, new Object[] { data.get(field) });
				}
			} catch (Exception e) {
				throw new RuntimeException("Map转化JavaBean出错");
			}
		}
		return javabean;
	}

	/**
	 * 将javaBean转换成JSONObject
	 */
	public static void toJavaBean(Object javabean, String data){
		JSONObject jsonObject = new JSONObject(data);
		toJavaBean(javabean, toMap(jsonObject));
	}

}