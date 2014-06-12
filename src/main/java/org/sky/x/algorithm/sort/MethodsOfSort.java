package org.sky.x.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MethodsOfSort {

	public static int[] unSortedArray;

	public static final int LENGTH = 10;

	public static void main(String[] args) {
		unSortedArray = RandomArray.getRandomArray(LENGTH);
		// int[] sortedArray = insertSort();
		// int[] sortedArray = shellSort();
		// int[] sortedArray = choiceSort();
		// int[] sortedArray = heapSort();
		// int[] sortedArray = bubbleSort();
		// int[] sortedArray = quickSort();
		// int[] sortedArray = mergeSort();
		int[] sortedArray = radixSort();
		for (int i = 0; i < LENGTH; i++) {
			System.out.println("unSortedArray[" + i + "]=" + unSortedArray[i]);
		}
		System.out
				.println("--------------------after sort---------------------");
		for (int i = 0; i < LENGTH; i++) {
			System.out.println("sortedArray[" + i + "]=" + sortedArray[i]);
		}
	}

	/**
	 * 1.��������,����ǰn-1�����Ѿ�����Ҫ��ľ��ǽ���n����ݲ��뵽��Ӧ��λ�ã������������λ
	 * 
	 * @return
	 */
	public static int[] insertSort() {
		int[] a = RandomArray.copyArray(unSortedArray);
		int length = a.length;
		for (int i = 1; i < length; i++) {
			int j = i - 1;
			int tmp = a[i];
			for (; j >= 0 && tmp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = tmp;
		}
		return a;
	}

	/**
	 * 2.ϣ�����򣬰����а�d=n/2�ļ����飬���ڲ��ò��������ٰ�d=d/2����ϸ�֣�ֱ��d=1
	 * 
	 * @return
	 */
	public static int[] shellSort() {
		int[] a = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		do {
			d = (int) Math.ceil(((double) d) / 2);
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i += d) {
					int j = i - d;
					int tmp = a[i];
					for (; j >= x && a[j] > tmp; j -= d) {
						a[j + d] = a[j];
					}
					a[j + d] = tmp;
				}
			}
		} while (d != 1);
		return a;
	}

	/**
	 * 3.��ѡ�����򣬴Ӷ�����ȡ����С��ֵ���һ��λ�ý�������ȥʣ�¶�������С��ֵ��ڶ���λ�ý������4�����
	 * 
	 * @return
	 */
	public static int[] choiceSort() {
		int[] a = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		for (int i = 0; i < d; i++) {
			int tmp;
			for (int j = i; j < d; j++) {
				if (a[i] > a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		return a;
	}

	/**
	 * 4.��������һ������ѡ�������Ƕ�ֱ��ѡ���������Ч�Ľ��ѣ�������ѭ������
	 * 
	 * @return
	 */
	public static int[] heapSort() {
		int a[] = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		// ѭ��������
		for (int i = 0; i < d; i++) {
			// �����һ��Ԫ�ؿ�ʼ����
			int mid = (d - i) / 2 - 1;
			for (; mid >= 0; mid--) {
				int pid = mid;
				while (pid * 2 + 1 < (a.length - i)) {// ���ӽڵ����
					int left = pid * 2 + 1;
					if (left + 1 < (a.length - i) && a[left] < a[left + 1]) {// ѡ�����ӽڵ��нϴ����Ϊ�븸�ڵ�ıȽ϶���
						left++;
					}
					if (a[pid] < a[left]) {// ����н���������Խ�������ӽڵ����жϣ�
						swap(a, pid, left);
						pid = left;
					} else {
						break;
					}
				}
			}
			swap(a, 0, d - 1 - i);
			// buildMaxHeap(a, d - 1 - i);
			// swap(a, 0, d - 1 - i);
			System.out.println(Arrays.toString(a));
		}
		return a;
	}

	// 5.ð������}�����ڵ���Ƚϣ��������³c�
	/**
	 * 
	 */
	public static int[] bubbleSort() {
		int a[] = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
		return a;
	}

	/**
	 * 6.��������ѡ��һ���׼Ԫ�أ�ͨ��һ��ɨ�裬���������зֳ�}���֣�һ���ֱȻ�׼Ԫ��С��
	 * һ���ִ��ڻ�׼Ԫ�أ���ʱ��׼Ԫ�������ź������ȷλ�ã�Ȼ����ͬ���ݹ����򻮷ֵĲ���
	 * 
	 * @return
	 */
	public static int[] quickSort() {
		int a[] = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		_quickSort(a, 0, d - 1);
		return a;
	}

	/**
	 * 7.�鲢���򣬽�����ź���������кϲ�Ϊ�������������
	 * 
	 * @return
	 */
	public static int[] mergeSort() {
		int a[] = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		_mergeSort(a, 0, d - 1);
		return a;
	}

	/**
	 * 8.�������򣬽����д�Ƚ���ֵ��������ͳһΪ��ͬ����λ���ȣ���λ�϶̵���ǰ�油��
	 * Ȼ������Ϊ��ʼ���4ν���һ����������ӵ�λ����һֱ�����λ������ɺ�ͱ����������
	 * 
	 * @return
	 */
	public static int[] radixSort() {
		int a[] = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		// ȷ�������
		int max = a[0];
		int i = 0;
		int time = 0;
		while (i < d) {
			max = max > a[i] ? max : a[i];
			i++;
		}
		// ȷ��λ����Ҫ�ż���
		while (max > 0) {
			max = max / 10;
			time++;
		}
		// ��b10��ArrayList�ֱ�������
		ArrayList list = new ArrayList();
		for (int j = 0; j < 10; j++) {
			list.add(new ArrayList<Integer>());
		}

		// �Ӹ�λ��ʼ�ռ�
		for (int j = 1; j <= time; j++) {
			// ��������Ԫ��
			for (int k = 0; k < d; k++) {
				int x = (int) ((int) a[k] % Math.pow(10, j) / Math.pow(10,
						j - 1));//����/10^n
				((ArrayList) list.get(x)).add(a[k]);
			}
			// �ռ�����Ԫ��
			int count = 0;
			for (int k = 0; k < 10; k++) {
				ArrayList<Integer> queue = (ArrayList<Integer>) list.get(k);
				while (queue.size() > 0) {
					// �ӵ�һ����ȡֵ��ȡ����Ƴ�
					a[count] = queue.get(0);
					queue.remove(0);
					count++;
				}
			}
			System.out.println(Arrays.toString(a));
		}
		return a;
	}

	/**
	 * ��������Ԫ��
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void swap(int[] data, int i, int j) {
		// TODO Auto-generated method stub
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	/**
	 * ��data�����0��lastIndex������
	 */
	private static void buildMaxHeap(int[] data, int lastIndex) {
		int k = (lastIndex - 1) / 2;// �����һ��Ԫ�صĸ��ڵ㿪ʼ
		for (int i = k; i >= 0; i--) {
			// �����ӽڵ�
			int subNode;
			while (i * 2 + 1 <= lastIndex) {// ���ӽڵ��Ƿ����
				subNode = 2 * i + 1;
				if (subNode + 1 <= lastIndex
						&& data[subNode] < data[subNode + 1]) {// ������ӽڵ���ڣ�ȡ��ֵ
					subNode++;
				}
				if (data[i] < data[subNode]) {// �Ƚϸ��ڵ��������ӽڵ�
					swap(data, i, subNode);
					i = subNode;
				} else {
					break;
				}
			}
		}
	}

	/**
	 * �ݹ����
	 * 
	 * @param a
	 * @param low
	 * @param high
	 */
	private static void _quickSort(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		int middle;
		if (low < high) {
			middle = getMiddle(a, low, high);
			_quickSort(a, low, middle - 1);
			_quickSort(a, middle + 1, high);
		}
	}

	/**
	 * ȷ���Ƚ���
	 * 
	 * @param list
	 * @param low
	 * @param high
	 * @return
	 */

	private static int getMiddle(int[] a, int low, int high) {
		int tmp = a[low];
		while (low < high) {
			while (low < high && tmp <= a[high]) {
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] <= tmp) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = tmp;
		return low;
	}

	private static void _mergeSort(int[] data, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			_mergeSort(data, left, center);
			_mergeSort(data, center + 1, right);
			merge(data, left, center, right);
		}
	}

	private static void merge(int data[], int left, int center, int right) {
		int[] tmp = new int[data.length];
		int leftTo = left;
		int leftTmp = left;
		int toRight = center + 1;
		while (leftTo <= center && toRight <= right) {
			// ȡ}���������н�С���������ʱ����
			if (data[leftTo] > data[toRight]) {
				tmp[leftTmp++] = data[toRight++];
			} else {
				tmp[leftTmp++] = data[leftTo++];
			}
		}
		// ��ʣ�������е����������䵽��ʱ�������
		while (leftTo <= center) {
			tmp[leftTmp++] = data[leftTo++];
		}
		while (toRight <= right) {
			tmp[leftTmp++] = data[toRight++];
		}
		// ����ʱ���������滻ԭ����data��Ӧ����ֵ
		while (left <= right) {
			data[left] = tmp[left];
			left++;
		}
	}
}