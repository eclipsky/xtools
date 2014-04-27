package org.sky.x.collection;

import java.util.Arrays;

/**
 * @author xieming 2013-10-16 ����05:50:30
 */
public class CollectionCompare {
	public static void main(String[] args) {
		ComparableStudent[] cstu = new ComparableStudent[] {
				new ComparableStudent("amy", 10),
				new ComparableStudent("bruce", 33),
				new ComparableStudent("cute", 5),
				new ComparableStudent("danial", 28) };
		for (ComparableStudent obj : cstu) {
			System.out.print(obj.getAge()+"\t");
		}
		Arrays.sort(cstu);
		System.out.println();
		for (ComparableStudent obj : cstu) {
			System.out.print(obj.getAge()+"\t");
		}

		
		Student[] stu = new Student[] { new Student("mike", 34),
				new Student("adam", 55), new Student("susan", 88),
				new Student("jack", 45) };
		StudentComparator comparator = new StudentComparator();
		System.out.println();
		for(Student obj : stu){
			System.out.print(obj.getName()+"\t");
		}
		Arrays.sort(stu,comparator);
		System.out.println();
		for(Student obj : stu){
			System.out.print(obj.getName()+"\t");
		}
	}
}
