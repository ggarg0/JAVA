package Sorting;

import java.util.Arrays;

public class SortInsertion {
	static void insertionSort(int arr[]) {
		int temp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
			System.out.println("Iteration : " + i + " - " + Arrays.toString(arr));
		}
	}

	public static void main(String a[]) {
		int[] arr = { 10, 34, 2, 56, 7, 67, 88, 42 };
		System.out.println("Before sort : " + Arrays.toString(arr));
		insertionSort(arr);
	}
}
