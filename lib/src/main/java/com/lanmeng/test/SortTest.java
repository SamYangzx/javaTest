package com.lanmeng.test;

public class SortTest {

	public static void main(String[] args) {
		int array[] = { 10, 7, 3, 15, 9, 8, 87, 22, 45, 87, 12, 35, 95, 85, 01, 22, 33, 44, 55, 66, 77, 88, 99, 11,
				12 };
		SortTest test = new SortTest();
		test.quick_sort(array, 0, array.length - 1);
		test.printArray(array);

	}

	void quick_sort(int s[], int left, int right) {
		if (left < right) {
			// Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
			int i = left, j = right, x = s[left];
			while (i < j) {
				while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];

				while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quick_sort(s, left, i - 1); // 递归调用
			quick_sort(s, i + 1, right);
			printArray(s);
		}
	}

	void printArray(int[] array) {
		System.out.println("---------");
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + ", " + array[i]);
		}
	}

}
