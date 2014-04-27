package org.sky.x.oop;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @author xieming  2013-12-22 下午02:51:45
 */
//enum Color {
//	RED,GREEN,BLANK,YELLOW;
//}


enum Color{
	RED("红色",1),GREEN("绿色",2),BLANK("白色",3);
	
	public String name;
	
	public int index;
	
	private Color(String name){
		this.name = name; 
	}
	
	private Color(String name,int index){
		this.name = name;
		this.index = index;
	}
	
	public int getIndex(){
		return index;
	}
	
	public String getName(){
		return name;
	}
	
	public static String getName(int index){
		for(Color c : Color.values()){
			if(c.index == index){
				return c.name;
			}
		}
		return null;
	}
	
	public static Map getMap(){
		Map<Integer,String> map = new HashMap<Integer,String>();
		for(Color c : Color.values()){
			map.put(c.getIndex(), c.getName()+" FROM "+c.toString());
		}
		return map;
	}
}

public class EnumDemo{
	Signal signal = Signal.GREEN;
	
	public void singalChange(){
		switch(signal){
		case RED:
			signal = Signal.RED;
			break;
		case GREEN:
			signal = Signal.GREEN;
			break;
		case YELLOW:
			signal = Signal.YELLOW;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(Color.getName(1)+Color.valueOf(Signal.class, "YELLOW").ordinal());
//		Color c1 = Color.valueOf("RED");
//		Color c2 = Color.valueOf("GREEN");
//		Color c3 = Color.valueOf("BLANK");
//		System.out.println(c1.GREEN.toString());
//		System.out.println(c2.toString());
//		System.out.println(c3.getName(3));
//		System.out.println("---------------");
//		Map<Integer,String> map = Color.getMap();
//		for(Color c:Color.values()){
//			System.out.println(c.getIndex()+"-"+c.name+"-"+c.name());
//		}
//		
//		System.out.println("---------------");
//		EnumMap enumMap = new EnumMap(Color.class);
//		enumMap.put(Color.GREEN, "");
		System.out.println(EnumDemo.class.getClassLoader());
		System.out.println(String.class.getClassLoader());
		System.out.println(DNSNameService.class.getClassLoader());
		System.out.println("---");
		
		String str1 = String.class.newInstance();
		String str2 = new String("helios");
		String str3 = (String) Class.forName("java.lang.String").newInstance();
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}

