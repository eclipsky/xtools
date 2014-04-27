package org.sky.x.tij.c08;

import java.util.*;
import java.util.Map.Entry;

import sun.reflect.generics.tree.Tree;

public class Collection1 {
	// Fill with 'size' elements, start
	// counting at 'start':
	public static Collection fill(Collection c, int start, int size) {
		for (int i = start; i < start + size; i++)
			c.add(Integer.toString(i));
		return c;
	}

	// Default to a "start" of 0:
	public static Collection fill(Collection c, int size) {
		return fill(c, 0, size);
	}

	// Default to 10 elements:
	public static Collection fill(Collection c) {
		return fill(c, 0, 10);
	}

	// Create & upcast to Collection:
	public static Collection newCollection() {
		return fill(new ArrayList());
		// ArrayList is used for simplicity, but it's
		// only seen as a generic Collection
		// everywhere else in the program.
	}

	// Fill a Collection with a range of values:
	public static Collection newCollection(int start, int size) {
		return fill(new ArrayList(), start, size);
	}

	// Moving through a List with an iterator:
	public static void print(Collection c) {
		for (Iterator x = c.iterator(); x.hasNext();)
			System.out.print(x.next() + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Collection c = newCollection();
		c.add("ten");
		c.add("eleven");
		print(c);
		// Make an array from the List:
		Object[] array = c.toArray();
		// Make a String array from the List:
		String[] str = (String[]) c.toArray(new String[1]);
		// Find max and min elements; this means
		// different things depending on the way
		// the Comparable interface is implemented:
		System.out.println("Collections.max(c) = " + Collections.max(c));
		System.out.println("Collections.min(c) = " + Collections.min(c));
		// Add a Collection to another Collection
		c.addAll(newCollection());
		print(c);
		c.remove("3"); // Removes the first one
		print(c);
		c.remove("3"); // Removes the second one
		print(c);
		// Remove all components that are in the
		// argument collection:
		c.removeAll(newCollection());
		print(c);
		c.addAll(newCollection());
		print(c);
		// Is an element in this Collection?
		System.out.println("c.contains( \"4\") = " + c.contains("4"));
		// Is a Collection in t his Collection?
		System.out.println("c.containsAll(newCollection()) = "
				+ c.containsAll(newCollection()));
		Collection c2 = newCollection(5, 3);
		// Keep all the elements that are in both
		// c and c2 (an intersection of sets):
		c.retainAll(c2);
		print(c);
		// Throw away all the elements in c that
		// also appear in c2:
		c.removeAll(c2);
		System.out.println("c.isEmpty() = " + c.isEmpty());
		c = newCollection();
		print(c);
		c.clear(); // Remove all elements
		System.out.println("after c.clear():");
		print(c);
		
		List ls1 = new ArrayList();
		List ls2 = new LinkedList();
		Iterator it1 = ls1.iterator();
		
		Set st1 = new HashSet();
		Set st2 = new TreeSet();
		Set st3 = new LinkedHashSet();
		
		st3.add("a");
		st3.add("b");
		st3.add("a");
		System.out.println("st3的长度为："+st3.size());
		for(Object t: st3){
			System.out.println((String)t);
		}
		
		Map mp1 = new HashMap();
		Map mp2 = new TreeMap();
		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Map<String,String> mp = new HashMap<String,String>();
		Map<String,String> mph = new LinkedHashMap<String,String>();
		TreeMap<String,String> mp = new TreeMap<String,String>(mph);
		
		mp.put("1", "one");
		mp.put("3", "three");
		mp.put("2", "two");
		mp.put("4", "four");
		
		//1
		System.out.println("-------------------1-----------------");
		for(String key:mp.keySet()){
			System.out.println("["+key+"],["+mp.get(key)+"]");//如果key值有重复，只会取后面的值
		}
		//2
		System.out.println("-------------------2-----------------");
		for(String value:mp.values()){
			System.out.println("values="+value);
		}
		//3
		System.out.println("-------------------3-----------------");
		Iterator<Map.Entry<String, String>> it = mp.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,String> itm = it.next();
			System.out.println("["+itm.getKey()+"],["+itm.getValue()+"]");
		}
		//4
		System.out.println("-------------------4-----------------");
		for(Map.Entry<String,String> entry : mp.entrySet()){
			System.out.println("["+entry.getKey()+"],["+entry.getValue()+"]");
		}
		if("11" instanceof String){
			System.out.println("11是一个字符串");
		}
		if(String.class.isInstance("11")){
			System.out.println("12是一个字符串");
		}
;
	}
} // /:~
