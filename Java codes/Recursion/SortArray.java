package Recursion;

import java.util.Arrays;

public class SortArray {

	public static void sortArray(int[] array, int len) {
		if (len == 1) {
			return;
		}
		for (int i = 0; i < len - 1; i++) {
			if (array[i] > array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		}
		System.out.println("Iteration : " + Arrays.toString(array));
		sortArray(array, len - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 40, 24, 60, 15, 10, 45 };
		System.out.println("Before sort : " + Arrays.toString(arr));
		sortArray(arr, arr.length);
		System.out.println("After sort : " + Arrays.toString(arr));
	}
}
