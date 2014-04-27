package org.sky.x.tij.c11;

interface HashBatteries{}
interface Waterproof{}
interface ShootsThings{}
class Toy{
	Toy(){};
	Toy(int i){};
}
class FancyToy extends Toy implements HashBatteries,Waterproof,ShootsThings{
	FancyToy(){super(1);};
}
public class ToyTest {
	public static void main(String[] args){
		Class c = null;
		try {
			c = Class.forName("xm.com.c11.FancyToy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(c);
		Class[] faces = c.getInterfaces();
		for(int i = 0;i<faces.length;i++){
			printInfo(faces[i]);
		}
		Class cy = c.getSuperclass();
		Object o = null;
		try {
			o = cy.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(o.getClass());
	}
	
	static void printInfo(Class cc){
		System.out.println("Class name:"+cc.getName()+" is interface? ["+cc.isInterface()+"]");
	}
}
