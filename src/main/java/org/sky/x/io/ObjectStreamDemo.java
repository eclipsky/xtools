package org.sky.x.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author xieming  2013-10-13 ����01:36:57
 */

public class ObjectStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Boy boy = new Boy(20,"sam","football");
		System.out.println("----------boy��ʼ��----------");
		boy.info();
		//���л�����
		FileOutputStream out = new FileOutputStream("d:/boy.info"); 
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(boy);
		oos.close();
		out.close();
		//�޸�boy����
		boy.setAge(10);
		boy.setName("jack");
		boy.setHobby("basketball");
		System.out.println("----------boy�޸ĺ�----------");
		boy.info();
		//�����ж����ж�ȡ��ע��ʹ��transient���ε����Բ��ᱻ���л���
		FileInputStream in = new FileInputStream("d:/boy.info"); 
		ObjectInputStream ois = new ObjectInputStream(in);
		boy = (Boy)ois.readObject();
		System.out.println("----------boy�����л������ж�ȡ----------");
		boy.info();
	}
}
