package org.sky.x.tij.c06;

class FinalBlank {
	final int i=1;
	final int j;
	{
		System.out.println("blank blank");
	}
	static{
		System.out.println("static blank");
	}
	
	FinalBlank(){
		j = 100;
	}
	FinalBlank(int k){
		j=k;
	}
	public static void main(String args[]){
		FinalBlank fb = new FinalBlank();
//		System.out.println(fb.j);
	}
}
