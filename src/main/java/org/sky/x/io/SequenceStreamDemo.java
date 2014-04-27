package org.sky.x.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author xieming  2013-10-13 上午11:21:30
 * 将一个图像文件分割成3部分，再合并
 */
public class SequenceStreamDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		//先分割
		FileInputStream fis = new FileInputStream("d:/wood.jpg");
		FileOutputStream fos;
		byte[] buffer = new byte[1024*100];
		int len=0;
		int count =1;
		while((len=fis.read(buffer))!=-1){
			fos = new FileOutputStream("d:/"+(count++)+".jpg");
			fos.write(buffer, 0, len);
			fos.close();
		}
		fis.close();
		
		//再合并
		ArrayList<FileInputStream> files = new ArrayList<FileInputStream>();
		Enumeration<FileInputStream> en = null;
		for(int i=1;i<=4;i++){
			files.add(new FileInputStream("d:/"+i+".jpg"));
			final Iterator<FileInputStream> it = files.iterator();
			en = new Enumeration<FileInputStream>(){
				@Override
				public boolean hasMoreElements() {
					// TODO Auto-generated method stub
					return it.hasNext();
				}

				@Override
				public FileInputStream nextElement() {
					// TODO Auto-generated method stub
					return it.next();
				}
			};
		}
		
		SequenceInputStream in = new SequenceInputStream(en);
		//创建合并文件
		FileOutputStream merge = new FileOutputStream("d:/wood2.jpg");
		buffer = new byte[1024*50];
		while((len=in.read(buffer))!=-1){
			merge.write(buffer, 0, len);
		}
		in.close();
		merge.close();
	}
}
