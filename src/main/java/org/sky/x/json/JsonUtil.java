package org.sky.x.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	private ObjectMapper mapper;

	public JsonUtil(Inclusion inclusion) {
		mapper = new ObjectMapper();
		// 设置输出包含的属性
		mapper.getSerializationConfig().setSerializationInclusion(inclusion);
		// 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
		mapper.getDeserializationConfig().set(
				Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 禁用int代表Enum的order()來反序列化Enum
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
		//允许单个值作为数组
		mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	}

	/**
	 * 创建输出全部属性到Json字符串的Binder.
	 */
	public static JsonUtil buildNormalBinder() {
		return new JsonUtil(Inclusion.ALWAYS);
	}

	/**
	 * 创建只输出非空属性到Json字符串的Binder.
	 */
	public static JsonUtil buildNonNullBinder() {
		return new JsonUtil(Inclusion.NON_NULL);
	}

	/**
	 * 创建只输出初始值被改变的属性到Json字符串的Binder.
	 */
	public static JsonUtil buildNonDefaultBinder() {
		return new JsonUtil(Inclusion.NON_DEFAULT);
	}

	/**
	 * 如果JSON字符串为Null或"null"字符串,返回Null. 如果JSON字符串为"[]",返回空集合.
	 * 
	 * 如需读取集合如List/Map,且不是List<String>这种简单类型时使用如下语句: List<MyBean> beanList =
	 * binder.getMapper().readValue(listString, new
	 * TypeReference<List<MyBean>>() {});
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}

	/**
	 * 如果对象为Null,返回"null". 如果集合为空集合,返回"[]".
	 */
	public String toJson(Object object) {

		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		}
	}

	/**
	 * 设置转换日期类型的format pattern,如果不设置默认打印Timestamp毫秒数.
	 */
	public void setDateFormat(String pattern) {
		if (StringUtils.isNotBlank(pattern)) {
			DateFormat df = new SimpleDateFormat(pattern);
			mapper.getSerializationConfig().withDateFormat(df);
			mapper.getDeserializationConfig().withDateFormat(df);
			mapper.setDateFormat(df);
		}
	}

	/**
	 * 取出Mapper做进一步的设置或使用其他序列化API.
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}
}