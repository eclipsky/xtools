package org.sky.x.tij.c03;

public class BreakAndContinue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j=2;
		for(int i = 0; i<100; i++){
			//int j=1;//�ظ�����
			int k =1;
			if(i==85)
				break;
			if(i%10!=0)
				continue;
			else
				System.out.println("i="+i);
		}
		int k  = 2;//�˴�Ϊ�β����ظ����壿
		System.out.println(j);
	}

}
