package org.sky.x.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author xieming  2013-10-13 下午01:36:57
 */

public class ObjectStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Boy boy = new Boy(20,"sam","football");
		System.out.println("----------boy初始化----------");
		boy.info();
		//序列化操作
		FileOutputStream out = new FileOutputStream("d:/boy.info"); 
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(boy);
		oos.close();
		out.close();
		//修改boy对象
		boy.setAge(10);
		boy.setName("jack");
		boy.setHobby("basketball");
		System.out.println("----------boy修改后----------");
		boy.info();
		//从序列对象中读取（注意使用transient修饰的属性不会被序列化）
		FileInputStream in = new FileInputStream("d:/boy.info"); 
		ObjectInputStream ois = new ObjectInputStream(in);
		boy = (Boy)ois.readObject();
		System.out.println("----------boy从序列化对象中读取----------");
		boy.info();
	}
}
