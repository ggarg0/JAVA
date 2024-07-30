package Arrays;

import java.util.Arrays;

/*
Inversion count represents how far or close an array is from being sorted. If an array is sorted,
the inversion count is 0. But if it’s sorted in the reverse order, the inversion count is maximum.

(9, 5, 6, 11, 8, 10)
Number of inversions = 5
i-e: (9, 5), (9, 6), (9, 8), (11, 8), (11, 10)

*/


public class InversionCount {
	public static int InvCount(int[] arr) {
		int size = arr.length;
		int count = 0;
		for (int curr = 0; curr < size - 1; curr++)
			for (int right = curr + 1; right < size; right++)
				if (arr[curr] > arr[right])
					count++;

		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 8, 4 };
		System.out.println(Arrays.toString(arr) + "  --->  " + InvCount(arr));
	}
}
