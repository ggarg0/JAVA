package Arrays;

import java.util.Arrays;

public class DutchFlagProblem {

	public static void dutchNationalFlag(int[] arr) {
		int start = 0;
		int mid = 0;
		int end = arr.length - 1;

		while (mid <= end) {
			if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 0) {
				swap(arr, start++, mid++);
			} else if (arr[mid] == 2) {
				swap(arr, mid, end--);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 0, 0, 1, 2, 1 };
		dutchNationalFlag(arr);
		System.out.println(Arrays.toString(arr));
	}
}
