package org.sky.x;

public class Test {

	public static final int A = 4 + 4;
	
	//public static final int B = 4 + new Random().nextInt(10);
	
	static {
		System.out.println("如果执行了，证明类初始化了……");
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		
		//Class clazz = Class.forName("java.lang.String");
		//System.out.println("加载类java.lang.String的类加载器为：="+clazz.getClassLoader());
		
		//Singleton mysingleton = Singleton.GetInstence();
		//System.out.println("加载类Singleton的类加载器为：="+mysingleton.getClass().getClassLoader());

		//System.out.println("TestXX.A="+TestXX.A);
		//System.out.println("TestXX.B="+TestXX.B);
		
		//System.out.println("Test.A="+Test.A);
		//System.out.println("TestXX.B="+TestXX.B);
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		@SuppressWarnings("unused")
		Class<?> clazz = classLoader.loadClass("Test");
		
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("catalina.base"));
		System.out.println(System.getProperty("catalina.home"));
	}

}
