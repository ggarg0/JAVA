package Heap;

import java.util.Arrays;

public class FindKSmallestElementArray {
	public static void buildMinHeap(int[] arr, int index) {
		int current = index;
		while (current < arr.length/2) {
			int left = (2 * index) + 1;
			int right = (2 * index) + 2;

			if (left < arr.length && arr[left] < arr[current])
				current = left;

			if (right < arr.length && arr[right] < arr[current])
				current = right;
			if (current != index) {
				int temp = arr[index];
				arr[index] = arr[current];
				arr[current] = temp;
				index = current;
			} else
				break;
			
		}
	}

	public static int removeMin(int[] arr, int heapSize) {
		System.out.print("Array before minify(): " + Arrays.toString(arr) + " and size : " + heapSize);
		for (int i = (heapSize - 1) / 2; i >= 0; i--) {
			buildMinHeap(arr, i);
		}
		System.out.print(" => Array after minify(): " + Arrays.toString(arr));
		int min = arr[0];
		arr[0] = arr[heapSize - 1];
		System.out.println(" => Array after adjustment: " + Arrays.toString(arr));
		return min;
	}

	public static int[] findKSmallest(int[] arr, int k) {
		int len = arr.length;
		if (k <= len) {
			int[] result = new int[k];
			for (int i = 0; i < k; i++) {
				result[i] = removeMin(arr, len);
				--len;
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
		int[] output = findKSmallest(input, k);
		System.out.println("Smallest " + k + " elements : " + Arrays.toString(output));
	}
}
