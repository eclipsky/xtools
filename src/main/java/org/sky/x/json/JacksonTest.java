package org.sky.x.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.impl.StaticListSerializerBase;
import org.codehaus.jackson.node.JsonNodeFactory;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Nov 5, 2012 6:41:59 PM
 * </p>
 **************************************************************** 
 */
public class JacksonTest {

	private static JsonGenerator jsonGenerator = null;
	private static ObjectMapper objectMapper = null;
	private static User user = null;

	/**
	 * @title writeObjectJson
	 * @Description: 将参数对象转换成json对象
	 * @param Object entity eg:JavaBean/Map/List/Array等
	 * @throws IOException
	 */
	public static void writeObjectJson(Object entity) throws IOException {
		jsonGenerator.writeObject(entity);
	}
	
	/**
	 * @title writeValueJson
	 * @Description: 将参数对象转换成json对象
	 * @param Object entity eg:JavaBean/Map/List/Array等
	 * @throws IOException
	 */
	public static void writeValueJson(Object entity) throws IOException {
		objectMapper.writeValue(System.out, entity);
	}

	public static void writeOthersJSON() {
		try {
			String str = "hello world jackson!";
			// byte
			jsonGenerator.writeBinary(str.getBytes());
			// boolean
			jsonGenerator.writeBoolean(true);
			// null
			jsonGenerator.writeNull();
			// float
			jsonGenerator.writeNumber(2.2f);
			// char
			jsonGenerator.writeRaw("c");
			// String
			jsonGenerator.writeRaw(str, 5, 10);
			// String
			jsonGenerator.writeRawValue(str, 5, 5);
			// String
			jsonGenerator.writeString(str);
			jsonGenerator.writeTree(JsonNodeFactory.instance.POJONode(str));
			
			// Object
			jsonGenerator.writeStartObject();// {
			jsonGenerator.writeObjectFieldStart("user");// user:
			jsonGenerator.writeStringField("name", "jackson");// name:jackson
			jsonGenerator.writeBooleanField("sex", true);// sex:true
			jsonGenerator.writeNumberField("age", 22);// age:22
			jsonGenerator.writeEndObject();
			jsonGenerator.writeArrayFieldStart("infos");// infos:[
			jsonGenerator.writeNumber(22);// 22
			jsonGenerator.writeString("this is array");// this is array
			jsonGenerator.writeEndArray();// ]
			jsonGenerator.writeEndObject();// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title readJson2Entity
	 * @Description:  Json转java对象 (若JSON为Null或"null"字符串, 返回Null;若JSON字符串为"[]", 返回空集合)
	 * @param String jsonString, Class<T> clazz
	 * @return <T> T
	 * @throws IOException
	 */
	public static <T> T readJson2Entity(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return objectMapper.readValue(jsonString, clazz);
		} catch (JsonParseException e) {
			return null;
		} catch (JsonMappingException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * JSON转换为List对象
	 */
	@SuppressWarnings("unchecked")
	public static List<LinkedHashMap<String, Object>> readJson2List(String jsonString) {
		List<LinkedHashMap<String, Object>> list = null;
		try {
			list = objectMapper.readValue(jsonString, List.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * JSON转换为数组对象
	 */
	public static void readJson2Array() {
		String json = "[{\"uid\":1,\"uname\":\"www\",\"number\":234,\"upwd\":\"456\"},"
				+ "{\"uid\":2,\"uname\":\"sdfsdf\",\"number\":4745,\"upwd\":\"23456\"}]";
		try {
			User[] arr = objectMapper.readValue(json, User[].class);
			System.out.println(arr.length);
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * JSON转换为Map对象
	 */
	@SuppressWarnings("unchecked")
	public static void readJson2Map() {
		String json = "{\"success\":true,\"A\":{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"
				+ "\"B\":{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}}";
		try {
			Map<String, Map<String, Object>> maps = objectMapper.readValue(json, Map.class);
			System.out.println(maps.size());
			Set<String> key = maps.keySet();
			Iterator<String> iter = key.iterator();
			while (iter.hasNext()) {
				String field = iter.next();
				System.out.println(field + ":" + maps.get(field));
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String, String> jsonParser(String jsonStr) {
		Map<String, String> map = new HashMap<String, String> ();   
		try {
			JsonFactory jsonFactory = new MappingJsonFactory();
			JsonParser jsonParser = jsonFactory.createJsonParser(jsonStr);
			jsonParser.nextToken();
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				jsonParser.nextToken();
				map.put(jsonParser.getCurrentName(), jsonParser.getText());
			}
		} catch (Exception e) {
			
		}
		return map;
	}
	
	public static void main(String[] args) {
		user = new User();
		user.setUid(5);
		user.setUname("tom");
		user.setUpwd("123");
		user.setNumber(3.44);
		objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
			
			 User user1 = new User(1,"andy1","123456",1.0);
			 User user2 = new User(2,"andy2","123456",2.0);
			 List<User> userList = new ArrayList<User>();
			 userList.add(user1);
			 userList.add(user2);
			 
			 //writeObjectJson(userList);
			 
			 //writeValueJson(user1);
			 
			 //writeOthersJSON();
			 
			 /*String jsonEntityStr = "{\"uid\":5,\"uname\":\"tom\",\"number\":3.44,\"upwd\":\"123\"}";
			 User jsonEntity = readJson2Entity(jsonEntityStr ,User.class);
			 System.out.println("---------------------------------");
			 System.out.println("jsonEntityStr:"+jsonEntityStr);
			 System.out.println("jsonEntity.toString():"+jsonEntity.toString());
			 System.out.println("---------------------------------");
			 
			 String jsonListStr = "[{\"uid\":1,\"uname\":\"www\",\"number\":234,\"upwd\":\"456\"},"
					+ "{\"uid\":5,\"uname\":\"tom\",\"number\":3.44,\"upwd\":\"123\"}]";
			 List<LinkedHashMap<String, Object>> jsonList = readJson2List(jsonListStr);
			 System.out.println("---------------------------------");
			 System.out.println("jsonListStr:"+jsonListStr);
			 if (jsonList != null && jsonList.size() > 0) {
				for (int i = 0; i < jsonList.size(); i++) {
					Map<String, Object> map = jsonList.get(i);
					Set<String> set = map.keySet();
					for (Iterator<String> it = set.iterator(); it.hasNext();) {
						String key = it.next();
						System.out.println(key + ":" + map.get(key));
					}
				}
			 }
			 System.out.println("---------------------------------");*/
			 
		     //readJson2Array();
			 //readJson2Map();
			 
			 
			String json = "{\"A\":{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"}}";
			Map<String, String> map = jsonParser(json);
			System.out.println("---------------------------------");
			System.out.println("jsonEntityStr:"+json);
			Set<String> set = map.keySet();
			for (Iterator<String> it = set.iterator(); it.hasNext();) {
				String key = it.next();
				System.out.println(key + ":" + map.get(key));
			}
			System.out.println("---------------------------------"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
