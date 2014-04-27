package org.sky.x.tij.c03;

public class Loop {
	public static void main(String[] args){
		int i = 0;
		for(;i<=5;i++){
			System.out.println("for:i="+i);
		}
		i=0;
		while(i<=5){
			System.out.println("while:i="+i);
			i++;
		}
		i=0;
		do{
			System.out.println("do:i="+i);
			i++;
		}
		while(i<=5);
		
		int m=10,n=m+5;
		System.out.println("m="+m+",n="+n);
		for(m=n*2+10;m>n;m--,n++){
			System.out.println("m="+m+",n="+n);
		}
	}
}
