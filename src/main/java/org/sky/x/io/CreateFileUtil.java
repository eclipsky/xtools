package org.sky.x.io;

import java.io.File;
import java.io.IOException;

/**
 * @author xieming  2013-10-12 ����01:43:59
 * �ļ������࣬����Ŀ¼���ļ����������¼���·�������
 * ��·�����ļ���������
 */
public class CreateFileUtil {

	public static boolean CreateFile(String destFileName) {
		File file = new File(destFileName);
		if (file.exists()) {
			System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�Ŀ���ļ��Ѵ��ڣ�");
			return false;
		}
		if (destFileName.endsWith(File.separator)) {
			System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�Ŀ�겻����Ŀ¼��");
			return false;
		}
		if (!file.getParentFile().exists()) {
			System.out.println("Ŀ���ļ�����·�������ڣ�׼������������");
			if (!file.getParentFile().mkdirs()) {
				System.out.println("����Ŀ¼�ļ����ڵ�Ŀ¼ʧ�ܣ�");
				return false;
			}
		}

		// ����Ŀ���ļ�
		try {
			if (file.createNewFile()) {
				System.out.println("���������ļ�" + destFileName + "�ɹ���");
				return true;
			} else {
				System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�");
			return false;
		}
	}

	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�Ŀ��Ŀ¼�Ѵ��ڣ�");
			return false;
		}
//		if (!destDirName.endsWith(File.separator))
//			destDirName = destDirName + File.separator;
		// ��������Ŀ¼
		if (dir.mkdirs()) {
			System.out.println("����Ŀ¼" + destDirName + "�ɹ���");
			return true;
		} else {
			System.out.println("����Ŀ¼" + destDirName + "�ɹ���");
			return false;
		}
	}

	public static String createTempFile(String prefix, String suffix,
			String dirName) {
		File tempFile = null;
		try {
			if (dirName == null) {
				// ��Ĭ���ļ����´�����ʱ�ļ�
				tempFile = File.createTempFile(prefix, suffix);
				return tempFile.getCanonicalPath();
			} else {
				File dir = new File(dirName);
				// �����ʱ�ļ�����Ŀ¼�����ڣ����ȴ���
				if (!dir.exists()) {
					if (!CreateFileUtil.createDir(dirName)) {
						System.out.println("������ʱ�ļ�ʧ�ܣ����ܴ�����ʱ�ļ�����Ŀ¼��");
						return null;
					}
				}
				tempFile = File.createTempFile(prefix, suffix, dir);
				return tempFile.getCanonicalPath();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("������ʱ�ļ�ʧ��" + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		// ����Ŀ¼
		String dirName = "D:/test/test0/test1";
//		CreateFileUtil.createDir(dirName);
		
		File file = new File(dirName);
		if (!file.exists()) {
			System.out.println("Ŀ¼�����ڣ�Ҫ����");
			// file
			if (file.mkdir()) {
				System.out.println("�����ɹ�");
			}
		}
		
		// �����ļ�
		String fileName = dirName + "/test2/testFile.txt";
		CreateFileUtil.CreateFile(fileName);
		// ������ʱ�ļ�
		String prefix = "temp";
		String suffix = ".txt";
		for (int i = 0; i < 10; i++) {
			System.out.println("��������ʱ�ļ�:"
					+ CreateFileUtil.createTempFile(prefix, suffix, dirName));
		}

	}

}