package org.sky.x.jvm;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author xieming  2013-11-13 下午07:03:42
 */
public class ClassLoaderDemo {
	public static void main(String[] args) throws ClassNotFoundException{
//		getAllClassLoader();
		myClassLoader();
//		Class custom = Class.forName("com.sam.jvm.StackOverflowDemo");
//		System.out.println(custom.getClassLoader());
	}
	
	public static void myClassLoader(){
//		String rootDir = "D:\\workspace\\mycode\\bin";//这个地址作为classpath被sysClassLoader读取
		String rootDir = "D:";//这个地址无法委派给系统加载器加载，只能由自定义类加载器处理(为什么系统找不到文件)
		String className="com.sam.jvm.Sample";
		MyClassLoader loader1 = new MyClassLoader(rootDir);
		MyClassLoader loader2 = new MyClassLoader(rootDir);
		try {
			Class<?> c1 = loader1.loadClass(className);
			URL[] urls = ((URLClassLoader)c1.getClassLoader()).getURLs();
			for(URL url: urls){
				System.out.println(url);//为什么自定义类加载器无效sun.misc.Launcher$AppClassLoader
			}
			Object o1 = c1.newInstance();
			Class<?> c2 = loader2.loadClass(className);
			Object o2 = c1.newInstance();
			Method setSampleMethod = c1.getMethod("setSample",java.lang.Object.class);
			setSampleMethod.invoke(o1, o2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAllClassLoader(){
		System.out.println("----------BootstrapClassLoadger加载路径----------");
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(URL url:urls){
			System.out.println(url);
		}
		
		URLClassLoader extClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent();
		System.out.println("----------ExtClassLoader类加载器"+extClassLoader+"----------");
		urls = extClassLoader.getURLs();
		for(URL url:urls){
			System.out.println(url);
		}
		
		URLClassLoader sysClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
		System.out.println("----------SystemClassLoader类加载器"+sysClassLoader+"----------");
		urls = sysClassLoader.getURLs();
		for(URL url:urls){
			System.out.println(url);
		}
		
	}
}
