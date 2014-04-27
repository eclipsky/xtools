package org.sky.x.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Comparator;

/**
 * @author xieming 2013-10-15 ����09:17:34
 */
public class CollectionDemo {
	public static void main(String[] args) {
		List list = new ArrayList();
		
//		list.add(1);
		list.add("a");
		Collection c = Collections.checkedCollection(list, Integer.class);
		c.add(2);
		c.add("b");
//		System.out.println(Collections.checkedList(list, Integer.class));
	}
}