package Arrays.TwoPointers;

import java.util.Arrays;

public class DutchFlagProblem {

	public static void dutchNationalFlag(int[] arr) {
		int start = 0;
		int current = 0;
		int end = arr.length - 1;

		while (current <= end) {
			if (arr[current] == 1) {
				current++;
			} else if (arr[current] == 0) {
				swap(arr, start++, current++);
			} else if (arr[current] == 2) {
				swap(arr, current, end--);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 0,1,0 };
		dutchNationalFlag(arr);
		System.out.println(Arrays.toString(arr));
	}
}
