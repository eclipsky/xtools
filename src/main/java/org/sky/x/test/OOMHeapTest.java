package org.sky.x.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OOMHeapTest {

	public static void main(String[] args) {
		oom();
	}

	private static void oom() {
		Map<String, Pilot> map = new HashMap<String, Pilot>();
		Object[] array = new Object[1000000];
		for (int i = 0; i < 1000000; i++) {
			String d = new Date().toString();
			OOMHeapTest t = new OOMHeapTest();
			Pilot p =  t.new Pilot(d, i);
			map.put(i + "andy", p);
			array[i] = p;
		}
	}
	
    class Pilot{
	    
	    String name;
	    int age;
	    
	    public Pilot(String a, int b){
	        name = a;
	        age = b;
	    }
	} 

}
