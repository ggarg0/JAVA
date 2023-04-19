package Heap;

import java.util.Arrays;

public class FindKLargestElementArray {

	public static void buildMaxHeap(int[] arr, int index, int heapSize) {
		int current = index;
		while (current < heapSize / 2) {
			int left = (2 * index) + 1;
			int right = (2 * index) + 2;

			if (left < heapSize && arr[left] > arr[current])
				current = left;

			if (right < heapSize && arr[right] > arr[current])
				current = right;

			if (index != current) {
				int temp = arr[current];
				arr[current] = arr[index];
				arr[index] = temp;
				index = current;
			} else
				break;
		}
	}

	public static int[] findKLargest(int[] arr, int k) {
		int len = arr.length;
		if (k <= len) {
			int[] result = new int[k];
			for (int i = 0; i < k; i++) {
				for (int j = (len - 1) / 2; j >= 0; j--) {
					buildMaxHeap(arr, j, len);
				}
				result[i] = arr[0];
				arr[0] = arr[--len];
			}
			return result;
		}
		System.out.println("Value of k = " + k + " out of bounds for given array!");
		return arr;
	}

	public static void main(String[] args) {
		int[] input = { 9, 4, 7, 1, -2, 6, 5 };
		int k = 3;

		System.out.println("Input array : " + Arrays.toString(input));
		int[] output = findKLargest(input, k);
		System.out.println("Largest " + k + " elements : " + Arrays.toString(output));

	}

}
