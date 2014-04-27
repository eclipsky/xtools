package org.sky.x.tij.c03;

public class StrConn {
	public static void main(String[] args){
		int i = 1;
		int j = 2;
		int m = 3;
		String s = "Sam";
		System.out.println(s+i+j+m);//字符在前，后面的也做字符处理
		System.out.println(i+j+m+s+i);//数字在前，连续的数字处理完之后在转为字符串拼接
		
//		while(x=y){//x=y在c/c++中是可行的，但是在java中检查比较严格，无法编译
		//唯一不会出现编译错误 的情况是，x，y都是boolean值
//			System.out.println();
//		}
		
		
	}
}
