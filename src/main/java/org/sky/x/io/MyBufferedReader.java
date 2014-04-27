package org.sky.x.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author xieming 2013-10-12 下午04:50:17
 */
public class MyBufferedReader {

	private Reader r;

	private int lineNumber = 0;

	public MyBufferedReader(Reader r) {
		this.r = r;
	}

	public String myReadLine() throws IOException {
		StringBuilder sb = new StringBuilder();// 为什么不用StringBuffer
		int tmp;
		while ((tmp = r.read()) != -1) {
			if (tmp == '\r') {
				continue;
			}
			if (tmp == '\n') {
				lineNumber++;
				return sb.toString();
			} else {
				sb.append((char) tmp);
			}
		}
		// if(sb.length()!=0){
		// return sb.toString();
		// }
		return null;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public static void main(String[] args) throws IOException {
		MyBufferedReader reader = new MyBufferedReader(new FileReader(
				"d:/hello.java"));
		String line;
		while ((line = reader.myReadLine()) != null) {
			System.out.println(reader.getLineNumber() + "\t" + line);
		}
	}
}
