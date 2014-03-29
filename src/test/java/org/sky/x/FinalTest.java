package org.sky.x;

public class FinalTest {

	public static void main(String[] args) {
		FinalTest ft = new FinalTest();
		Student st = ft.new Student("1");
        System.out.println(st.toString());
        //st.name = "2";
	}
	
	class Student {
		
		public Student(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return name;
		}

		public final String name;

		public String getName() {
			return name;
		}

	} 

}
