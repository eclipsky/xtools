package org.sky.x.io;

import java.io.File;
import java.io.IOException;

/**
 * @author xieming  2013-10-12 下午01:43:59
 * 文件创建类，处理目录和文件名。有如下几种路径名情况
 * 分路径和文件两个方法
 */
public class CreateFileUtil {

	public static boolean CreateFile(String destFileName) {
		File file = new File(destFileName);
		if (file.exists()) {
			System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
			return false;
		}
		if (destFileName.endsWith(File.separator)) {
			System.out.println("创建单个文件" + destFileName + "失败，目标不能是目录！");
			return false;
		}
		if (!file.getParentFile().exists()) {
			System.out.println("目标文件所在路径不存在，准备创建。。。");
			if (!file.getParentFile().mkdirs()) {
				System.out.println("创建目录文件所在的目录失败！");
				return false;
			}
		}

		// 创建目标文件
		try {
			if (file.createNewFile()) {
				System.out.println("创建单个文件" + destFileName + "成功！");
				return true;
			} else {
				System.out.println("创建单个文件" + destFileName + "失败！");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("创建单个文件" + destFileName + "失败！");
			return false;
		}
	}

	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("创建目录" + destDirName + "失败，目标目录已存在！");
			return false;
		}
//		if (!destDirName.endsWith(File.separator))
//			destDirName = destDirName + File.separator;
		// 创建单个目录
		if (dir.mkdirs()) {
			System.out.println("创建目录" + destDirName + "成功！");
			return true;
		} else {
			System.out.println("创建目录" + destDirName + "成功！");
			return false;
		}
	}

	public static String createTempFile(String prefix, String suffix,
			String dirName) {
		File tempFile = null;
		try {
			if (dirName == null) {
				// 在默认文件夹下创建临时文件
				tempFile = File.createTempFile(prefix, suffix);
				return tempFile.getCanonicalPath();
			} else {
				File dir = new File(dirName);
				// 如果临时文件所在目录不存在，首先创建
				if (!dir.exists()) {
					if (!CreateFileUtil.createDir(dirName)) {
						System.out.println("创建临时文件失败，不能创建临时文件所在目录！");
						return null;
					}
				}
				tempFile = File.createTempFile(prefix, suffix, dir);
				return tempFile.getCanonicalPath();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("创建临时文件失败" + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		// 创建目录
		String dirName = "D:/test/test0/test1";
//		CreateFileUtil.createDir(dirName);
		
		File file = new File(dirName);
		if (!file.exists()) {
			System.out.println("目录不存在，要创建");
			// file
			if (file.mkdir()) {
				System.out.println("创建成功");
			}
		}
		
		// 创建文件
		String fileName = dirName + "/test2/testFile.txt";
		CreateFileUtil.CreateFile(fileName);
		// 创建临时文件
		String prefix = "temp";
		String suffix = ".txt";
		for (int i = 0; i < 10; i++) {
			System.out.println("创建了临时文件:"
					+ CreateFileUtil.createTempFile(prefix, suffix, dirName));
		}

	}

}