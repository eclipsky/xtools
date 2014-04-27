package org.sky.x.tij.c03;

public class ShortCuicuit {

	/**Âß¼­ÅĞ¶ÏÖĞµÄ¶ÌÂ·
	 * @param args
	 */
	static boolean test1(int i){
		System.out.println("test1"+"("+i+"):"+(i<1));
		return i<1;
	}
	static boolean test2(int i){
		System.out.println("test2"+"("+i+"):"+(i<2));
		return i<2;
	}
	static boolean test3(int i){
		System.out.println("test3"+"("+i+"):"+(i<3));
		return i<3;
	}
	static boolean test4(int i){
		System.out.println("test4"+"("+i+"):"+(i<4));
		return i<4;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean x = true;
		Boolean y = false;
		y.booleanValue();
		
		if(test1(0)&&test2(2)&&test3(2)||test4(3)){
			System.out.println("result:true");
		}else{
			System.out.println("result:false");
		}
		System.out.println("------------------");
		if(test1(0)&&test2(1)&&test3(2)||test4(3)){
			System.out.println("result:true");
		}else{
			System.out.println("result:false");
		}
		System.out.println("------------------");
		if(test1(0)&&test2(1)&&(test3(3)||test4(3))){
			System.out.println("result:true");
		}else{
			System.out.println("result:false");
		}
	}

}
