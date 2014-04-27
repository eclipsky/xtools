package org.sky.x.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xieming 2013-10-12 ÏÂÎç11:40:12
 */

public class FileDemo {

	public static void listDir(File dir, int level) throws IOException {
		print(getLevel(level) + dir.getName());
		level++;
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			if (files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					listDir(files[i], level);
				}
			}
		}
	}

	public static String getLevel(int level) {
		StringBuffer sb = new StringBuffer();
		sb.append("|-");
		for (int i = 0; i < level; i++) {
			sb.insert(0, "| ");
		}
		return sb.toString();
	}

	public static void dropDir(File dir) {
		File[] files = dir.listFiles();
		if (null != files && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					dropDir(files[i]);
				}
				files[i].delete();
			}
		}
		dir.delete();
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void printWriter() throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(System.out,true);
		pw.println("Äã´óÒ¯°¡£¡");
//		pw.flush();
//		pw.close();
	} 
	
	public static void pipedStream(){
		
	}
	
	public static void main(String[] args) throws IOException {
//		File f1 = new File("D:/java/xm/com/c01/hello");// D:/java/xm/com/c01/hello.class
		// listDir(new File("d:/java"),0);
//		dropDir(new File("d:/java1"));
		printWriter();
	}
}
