package org.sky.x.tij.c04;

class Tree{
	 int height;
	 
	 Tree(){
		 prt("a seed");
	 }
	 
	 Tree(int h){
		 prt("a tree height="+h);
		 height = h;
	 }
	 
	 void info(){
		 prt("with no name");
	 }
	 
	 void info(String str){
		 prt("with an name:"+str);
	 }
	 
	 static void prt(String str){
		 System.out.println(str);
	 }
}
public class Overloading {
	public static void main(String[] args){
		Tree t1 = new Tree();
		Tree t2 = new Tree(12);
		t1.info();
		t1.info("baiyang");
	}
}
