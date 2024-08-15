package Recursion;

import java.util.Arrays;

public class MaxInArray {

	public static int max(int[] arr, int index) {
		if (index == arr.length - 1) {
			return arr[index];
		} else {
			int max = max(arr, index + 1);
			if (max > arr[index])
				return max;
			else
				return arr[index];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 40, 5, 6, 9, 2, -11 };
		System.out.println(Arrays.toString(arr));
		System.out.println(max(arr, 0));
	}
}
