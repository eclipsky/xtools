package org.sky.x.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xieming  2013-11-14 ÉÏÎç10:21:11
 */
public class MyClassLoader extends ClassLoader{
	private String rootDir;
	
	public MyClassLoader(String rootDir){
//		super();
		this.rootDir = rootDir;
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		byte[] classData = getClassData(name);
		if(classData == null){
			throw new ClassNotFoundException();
		}else{
			return defineClass(name,classData,0,classData.length);
		}
	}
	
	private byte[] getClassData(String className){
		String path = classNameToPath(className);
		try {
			InputStream in = new FileInputStream(path);
			byte[] buffer = new byte[10240];
			int byteNumRead = 0;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			while((byteNumRead = in.read(buffer))!=-1){
				out.write(buffer, 0, byteNumRead);
			}
			return out.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String classNameToPath(String className){
		return rootDir+File.separatorChar+className.replace('.', File.separatorChar)+".class'";
	}
}
