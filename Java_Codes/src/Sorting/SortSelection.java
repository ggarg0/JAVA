package Sorting;

import java.util.Arrays;

public class SortSelection {
	public static void main(String a[]) {
		int[] arr = { 10, 34, 2, 56, 7, 67, 88, 42 };
		System.out.println("Before sort : " + Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			System.out.println("Iteration : " + (i + 1) + " - " + Arrays.toString(arr));
		}
		System.out.println("After sort : " + Arrays.toString(arr));
	}
}
