package org.sky.x.sort;

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
	 * 1.插入排序,假设前n-1个数已经排序，要做的就是将第n个数据插入到对应的位置，往后的数往后移位
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
	 * 2.希尔排序，把序列按d=n/2的间隔分组，组内采用插入排序，再按d=d/2继续细分，直到d=1
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
	 * 3.简单选择排序，从队列中取出最小的值与第一个位置交换，再去剩下队列中最小的值与第二个位置交换，依次排列
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
	 * 4.堆排序是一种树形选择排序，是对直接选择排序的有效改进。建堆，交换。循环处理
	 * 
	 * @return
	 */
	public static int[] heapSort() {
		int a[] = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		// 循环建最大堆
		for (int i = 0; i < d; i++) {
			// 从最后一个元素开始建堆
			int mid = (d - i) / 2 - 1;
			for (; mid >= 0; mid--) {
				int pid = mid;
				while (pid * 2 + 1 < (a.length - i)) {// 左子节点存在
					int left = pid * 2 + 1;
					if (left + 1 < (a.length - i) && a[left] < a[left + 1]) {// 选左右子节点中较大的作为与父节点的比较对象
						left++;
					}
					if (a[pid] < a[left]) {// 如果有交换，继续对交换后的子节点作判断，
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

	// 5.冒泡排序，两个相邻的数比较，大数往下沉，
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
	 * 6.快速排序，选择一个基准元素，通过一趟扫描，将待排序列分成两部分，一部分比基准元素小，
	 * 一部分大于基准元素，此时基准元素在其排好序的正确位置，然后用同样方法递归排序划分的部分
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
	 * 7.归并排序，将多个排好序的子序列合并为整体的有序序列
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
	 * 8.基数排序，将所有待比较数值（正整数）统一为相同的数位长度，数位较短的数前面补零
	 * 然后从最低为开始，依次进行一次排序，这样从低位排序一直到最高位排序完成后就变成有序序列
	 * 
	 * @return
	 */
	public static int[] radixSort() {
		int a[] = RandomArray.copyArray(unSortedArray);
		int d = a.length;
		// 确定最大数
		int max = a[0];
		int i = 0;
		int time = 0;
		while (i < d) {
			max = max > a[i] ? max : a[i];
			i++;
		}
		// 确定位数，需要排几趟
		while (max > 0) {
			max = max / 10;
			time++;
		}
		// 建立10个ArrayList分别保留余数
		ArrayList list = new ArrayList();
		for (int j = 0; j < 10; j++) {
			list.add(new ArrayList<Integer>());
		}

		// 从个位数开始收集
		for (int j = 1; j <= time; j++) {
			// 分配数组元素
			for (int k = 0; k < d; k++) {
				int x = (int) ((int) a[k] % Math.pow(10, j) / Math.pow(10,
						j - 1));//余数/10^n
				((ArrayList) list.get(x)).add(a[k]);
			}
			// 收集队列元素
			int count = 0;
			for (int k = 0; k < 10; k++) {
				ArrayList<Integer> queue = (ArrayList<Integer>) list.get(k);
				while (queue.size() > 0) {
					// 从第一个数取值，取完后移出
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
	 * 交换数组元素
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
	 * 对data数组从0到lastIndex建最大堆
	 */
	private static void buildMaxHeap(int[] data, int lastIndex) {
		int k = (lastIndex - 1) / 2;// 从最后一个元素的父节点开始
		for (int i = k; i >= 0; i--) {
			// 查找子节点
			int subNode;
			while (i * 2 + 1 <= lastIndex) {// 左子节点是否存在
				subNode = 2 * i + 1;
				if (subNode + 1 <= lastIndex
						&& data[subNode] < data[subNode + 1]) {// 如果右子节点存在，取大值
					subNode++;
				}
				if (data[i] < data[subNode]) {// 比较父节点与最大的子节点
					swap(data, i, subNode);
					i = subNode;
				} else {
					break;
				}
			}
		}
	}

	/**
	 * 递归调用
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
	 * 确定比较数
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
			// 取两个子序列中较小的数放入临时数组
			if (data[leftTo] > data[toRight]) {
				tmp[leftTmp++] = data[toRight++];
			} else {
				tmp[leftTmp++] = data[leftTo++];
			}
		}
		// 将剩下子序列的数据依序填充到临时数组后面
		while (leftTo <= center) {
			tmp[leftTmp++] = data[leftTo++];
		}
		while (toRight <= right) {
			tmp[leftTmp++] = data[toRight++];
		}
		// 将临时排序序列替换原数组data对应的数值
		while (left <= right) {
			data[left] = tmp[left];
			left++;
		}
	}
}