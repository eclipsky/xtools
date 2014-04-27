package org.sky.x.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.Reader;

/**
 * @author xieming 2013-10-11 上午10:33:38
 */
public class ReadFromFile{
	
	public void readByByte(File file){
		try {
			FileInputStream fis = new FileInputStream(file);
			int tmpByte = 0;
			while((tmpByte=fis.read())!=-1){
				System.out.write(tmpByte);//如果tmpByte为换行，那么将启动flush
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readByBytes(File file){
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] tmpBytes = new byte[128];
			int len = 0;
			System.out.println(fis.available());
			while((len = fis.read(tmpBytes))!=-1){
				System.out.println(fis.available());
				System.out.write(tmpBytes, 0, len);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readByChar(File file){
		FileReader fr;
		try {
			fr = new FileReader(file);
			int tmpChar;
			while((tmpChar=fr.read())!=-1){
				System.out.print((char)tmpChar);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readByChars(File file){
		try {
			FileReader fr = new FileReader(file);
			char[] tmpChars = new char[50];
			int len;
			while((len = fr.read(tmpChars))!=-1){
//				System.out.print(tmpChars);
				System.out.print(String.valueOf(tmpChars, 0, len));
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readByLine(File file){
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str;
			int line = 1;
			while(null!=(str=br.readLine())){
				System.out.println((line++)+"\t"+str);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readByRandom(File file){
		try {
			RandomAccessFile ra = new RandomAccessFile(file, "rw");
			System.out.println(ra.getFilePointer());
			long len = ra.length();
			ra.seek(len);
			ra.writeBytes("String");
			ra.writeChars("Chars");
			ra.seek(len);
			char tmp;
			while((tmp=ra.readChar())!=-1)
			System.out.println(tmp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void print(Object obj){
		System.out.println(obj);
	}
	
	public static void main(String[] args){
		String filePath = "d:/Hello.java";
		File file = new File(filePath);
		ReadFromFile read = new ReadFromFile();
//		read.readByByte(file);
//		read.readByBytes(file);
//		read.readByChar(file);
//		read.readByChars(file);
//		read.readByLine(file);
		read.readByRandom(file);
	}
}
