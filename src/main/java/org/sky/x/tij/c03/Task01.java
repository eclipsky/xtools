package org.sky.x.tij.c03;

public class Task01 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 4)
				// break;
				//return;
			System.out.println("i=" + i);
		}
		
		for (int j = 1; j <= 7; j++) {
			switch (j) {
			case 1:
				System.out.println("Monday");
				break;
			case 2:
				System.out.println("Tuesday");
//				break;//由于此处没有break，后面的case仍旧会执行，直到遇到break；
			case 3:
				System.out.println("Wednesday");
				break;
			case 4:
				System.out.println("Thursday");
				break;
			case 5:
				System.out.println("Friday");
				break;
			case 6:
				System.out.println("Saturday");
//				break;
			case 7:
				System.out.println("Sunday");
				break;
			default:
				System.out.println("Wrongday");
			}
		}
	}
}
