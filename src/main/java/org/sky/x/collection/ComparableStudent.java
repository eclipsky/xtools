package org.sky.x.collection;

/**
 * @author xieming  2013-10-16 ����05:36:42
 */
public class ComparableStudent extends Student implements Comparable{

	/**
	 * @param name
	 * @param age
	 */
	public ComparableStudent(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.getAge()-((Student)o).getAge();
	}
}
