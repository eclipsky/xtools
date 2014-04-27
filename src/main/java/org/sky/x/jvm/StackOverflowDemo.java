package org.sky.x.jvm;

/**
 * @author xieming  2013-11-12 下午12:40:21
 * 使用递归测试StackOverflow，每次调用函数都会压栈
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

