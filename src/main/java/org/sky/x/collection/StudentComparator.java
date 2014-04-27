package org.sky.x.collection;

import java.util.Comparator;
/**
 * @author xieming  2013-10-16 ����05:57:19
 */
public class StudentComparator implements Comparator<Student>{
	 	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
}
