package Sorting;

import java.util.Arrays;

public class SortBubble {
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println("Iteration : " + i + " - " + Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {
		int[] arr = { 14, 9, 23, 12 };
		System.out.println("Before sort : " + Arrays.toString(arr));
		bubbleSort(arr);
	}
}
