package org.sky.x.jvm;

/**
 * @author xieming  2013-11-12 ����12:40:21
 * ʹ�õݹ����StackOverflow��ÿ�ε��ú�������ѹջ
 */
public class StackOverflowDemo {
	public static void main(String[] args){
		Recurse r = new Recurse();
		System.out.println(r.sum(10000));
		System.out.println(r.sum(10000));
	}
}

class Recurse{
	int total;
	int sum(int num){
		if(num == 1){
			return 1;
		}else{
			total = sum(num - 1)+num;
		}
		return total;
	}
}

