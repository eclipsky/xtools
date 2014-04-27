package org.sky.x.tij.c04;

class Task01 {
	Task01(){
		System.out.println("I waw born");
	}
	Task01(String str){
		System.out.println("I waw born at :"+str);
	}
	public static void main(String[] args){
		new Task01();
		new Task01("sam");
		Task01[] ts = new Task01[5];
		for(int i=0;i<ts.length;i++){
			ts[i]=new Task01(String.valueOf(i));
		}
	}
	
}
