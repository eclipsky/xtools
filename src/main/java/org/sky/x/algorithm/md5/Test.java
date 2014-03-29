package org.sky.x.algorithm.md5;
/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 24, 2012 4:50:59 PM
 * </p>
 **************************************************************** 
 */
public class Test {

	/**
	 * @Description: 
	 * @param args  
	 */
	public static void main(String[] args) {

		testMethod();

	}

	private static void testMethod() {
		String s[];
		int i, x, n;
		for (x = 0; x < 2; x++) {
			if (x == 0) {
				s = new String[4];
				for (i = 0, n = 1; i < 4; i++) {
					s[i] = String.valueOf(n);
					n++;
				}
			} else {
				s = new String[4];
				for (i = 0, n = 5; i < 4; i++) {
					s[i] = String.valueOf(n);
					n++;
				}
			}
			for (i = 0; i < s.length; i++) {
				System.out.println(s[i]);
			}
		}
	}
	
}
