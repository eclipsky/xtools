package org.sky.x.jvm;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author xieming  2013-11-13 ����07:03:42
 */
public class ClassLoaderDemo {
	public static void main(String[] args) throws ClassNotFoundException{
//		getAllClassLoader();
		myClassLoader();
//		Class custom = Class.forName("com.sam.jvm.StackOverflowDemo");
//		System.out.println(custom.getClassLoader());
	}
	
	public static void myClassLoader(){
//		String rootDir = "D:\\workspace\\mycode\\bin";//�����ַ��Ϊclasspath��sysClassLoader��ȡ
		String rootDir = "D:";//�����ַ�޷�ί�ɸ�ϵͳ���������أ�ֻ�����Զ��������������(Ϊʲôϵͳ�Ҳ����ļ�)
		String className="com.sam.jvm.Sample";
		MyClassLoader loader1 = new MyClassLoader(rootDir);
		MyClassLoader loader2 = new MyClassLoader(rootDir);
		try {
			Class<?> c1 = loader1.loadClass(className);
			URL[] urls = ((URLClassLoader)c1.getClassLoader()).getURLs();
			for(URL url: urls){
				System.out.println(url);//Ϊʲô�Զ������������Чsun.misc.Launcher$AppClassLoader
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
		System.out.println("----------BootstrapClassLoadger����·��----------");
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(URL url:urls){
			System.out.println(url);
		}
		
		URLClassLoader extClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent();
		System.out.println("----------ExtClassLoader�������"+extClassLoader+"----------");
		urls = extClassLoader.getURLs();
		for(URL url:urls){
			System.out.println(url);
		}
		
		URLClassLoader sysClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
		System.out.println("----------SystemClassLoader�������"+sysClassLoader+"----------");
		urls = sysClassLoader.getURLs();
		for(URL url:urls){
			System.out.println(url);
		}
		
	}
}
