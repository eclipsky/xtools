package org.sky.x.sort;

/**
 * �ݹ�ʵ�ֺ�ŵ��
 * 
 * @author Administrator
 * 
 */
public class Hanoi {

	public static int count;

	public static final int num = 30;

	public static void main(String[] atgs) {
		long begin = System.currentTimeMillis();
		hanoi(num, 'a', 'b', 'c');
		long end = System.currentTimeMillis();
		System.out.println("��Ҫ�ƶ�������" + count+"����ʱ��"+(end-begin)+"ms");
	}

	public static void mov(int n, char from, char to) {
//		System.out.println("Բ��" + n + "\t��" + from + "��" + to);
		count++;
	}

	/**
	 * ��ʾn��������Ҫ����tmp����from��to
	 * 
	 * @param n
	 * @param from
	 * @param tmp
	 * @param to
	 */
	public static void hanoi(int n, char from, char tmp, char to) {
//		if (n == 1) {
//			mov(1, from, to);
//		} else {
//			hanoi(n - 1, from, to, tmp);
//			mov(n, from, to);
//			hanoi(n - 1, tmp, from, to);
//		}
		String str1="a";
		String str2 = str1+"b";
		String str3="ab";
		String str4=new String("ab");
		str4="ab";
		System.out.println(str4=="ab");
		System.out.println(str3=="ab");
		System.out.println(str4.equals("ab"));
	}
}
