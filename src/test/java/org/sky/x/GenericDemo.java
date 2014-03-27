package org.sky.x;

import java.util.ArrayList;
import java.util.Collection;

public class GenericDemo<T> {
	
//	public static List<T> list = new ArrayList<T>();
	
	@SuppressWarnings("hiding")
	public <T> void put(T t){
//		list. 
		Collection<String> c = new ArrayList<String>();
		c.add("");
	}
	
	
}
