package org.sky.x.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 * @author xieming 2013-10-12 下午01:00:06
 */
public class Demo01 {

	public void fileRW(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {// 文件不存在，就创建
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String content = "Hello,Dan,我们交朋友吧";
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(content);// 将字符串写入文件
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileReader reader;
		try {
			reader = new FileReader(fileName);
			int tmp = 0;
			char[] tmpChars = new char[50];
			int len = 0;
			while ((len = reader.read(tmpChars)) != -1) {
				System.out.println((char) tmp);
				System.out.println(tmpChars);
				System.out.println(new String(tmpChars, 0, len));
			}
			;
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void bufferRW() {// 实现文本拷贝
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"d:/hello.java"));
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"d:/world.java"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
				writer.flush();
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 实现图片复制
	public void copyImg() {
		int tmp;
		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("d:/east.jpg"));
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("d:/wood.gif"));
			while ((tmp = bis.read()) != -1) {
				bos.write(tmp);
			}
			bis.close();
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 将控制台输入另存为文本
	public void conoleToFile() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("d:/console2.txt"), "utf-8"));// utf-8
																		// gbk
			String str;
			while ((str = reader.readLine()) != null) {
				if (str.equals("q")) {
					System.out.println("退出控制台");
					System.exit(0);
				}
				writer.write(str);
				writer.newLine();
				writer.flush();
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过Properties将键值对存放在文件中
	 */
	public void readProperty() {
		Properties pro = new Properties();// System.getProperties();
		try {
			File file = new File("d:/run.properties");
			if (!file.exists()) {
				file.createNewFile();// 如果文件不存在就新建
				FileWriter out = new FileWriter(file);
				FileReader in = new FileReader(file);
				pro.load(in);
				pro.setProperty("usetimes", String.valueOf(0));
				pro.setProperty("maxtimes", String.valueOf(5));
				pro.store(out, null);
				System.out.println("初始化。。。");
			} else {
				pro.load(new FileReader("d:/run.properties"));
				int usetimes = Integer.valueOf(pro.getProperty("usetimes"));
				int maxtimes = Integer.valueOf(pro.getProperty("maxtimes"));
				if (usetimes < maxtimes) {
					System.out.println("使用中。。。。。");
				}
				if (usetimes < maxtimes) {
					usetimes++;
					pro.setProperty("usetimes", String.valueOf(usetimes));
					pro.store(new FileWriter("d:/run.properties"), null);
				}else{
					System.out.println("超过使用次数，请购买密钥！");
					System.exit(0);
					
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pro.list(System.out);
	}

	public static void main(String[] args) throws IOException {
		Demo01 demo = new Demo01();
		// FileOutputStream out = new FileOutputStream("d:/dan.txt");
		// out.write(new String("Dan, I miss you so much").getBytes());
		// out.close();
		// demo.fileRW(fileName);
		// demo.bufferRW();
		// demo.copyImg();
		// demo.conoleToFile();
		demo.readProperty();
		System.out.println("使用结束。。。");
	}
}
