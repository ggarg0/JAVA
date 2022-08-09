package com.test;

public class SortBubble {
	public static void main(String[] args) {
		int[] array = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i] > array[k]) {
					int temp;
					temp = array[i];
					array[i] = array[k];
					array[k] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
}
