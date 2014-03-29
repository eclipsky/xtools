package org.sky.x.test;

public class TestStackOverFlow {

	public static void main(String[] args) {

		TestStackOverFlow t = new TestStackOverFlow();
		
		Recursive r = t.new Recursive();
		
	    int result= r.doit(5);
	    
	    System.out.println("result="+result);
		
	}

	class Recursive {

		public int doit(int t) {
			if (t <= 1) {
				return 1;
			}
			return t + doit(t - 1);
		}

	}

}
