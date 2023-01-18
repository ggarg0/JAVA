package Sorting;

import java.util.Arrays;

public class SortMerge {

	public static void main(String[] args) {
		int[] input = new int[] { 10, 34, 2, 56};
		System.out.println("Before sort: " + Arrays.toString(input));
		mergeSort(0, input.length - 1, input);
		System.out.println("Before sort: " + Arrays.toString(input));
	}

	private static void mergeSort(int start, int end, int[] input) {
		if (start == end)
			return;

		int mid = (start + end) / 2;
		mergeSort(start, mid, input);
		mergeSort(mid + 1, end, input);

		int i = start;
		int j = mid + 1;
		int k;
		int[] scratch = new int[input.length];

		for (k = start; k <= end; k++) {
			scratch[k] = input[k];
		}

		k = start;
		while (k <= end) {

			if (i <= mid && j <= end) {
				input[k] = Math.min(scratch[i], scratch[j]);

				if (input[k] == scratch[i]) {
					i++;
				} else {
					j++;
				}
			} else if (i <= mid && j > end) {
				input[k] = scratch[i];
				i++;
			} else {
				input[k] = scratch[j];
				j++;
			}
			k++;
		}
	}

}
