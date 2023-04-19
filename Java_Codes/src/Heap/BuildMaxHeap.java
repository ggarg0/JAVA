package Heap;

import java.util.Arrays;

public class BuildMaxHeap {
	private static void buildMaxHeap(int[] arr, int index) {
		System.out.println("Iteration for index : " + index);
		int current = index;
		while (current < arr.length / 2) {
			int left = (2 * index) + 1;
			int right = (2 * index) + 2;

			if (left < arr.length && arr[left] > arr[current])
				current = left;

			if (right < arr.length && arr[right] > arr[current])
				current = right;

			System.out.print("Index: " + index + ", left: " + left + " and right: " + right);
			if (current != index) {
				int temp = arr[index];
				arr[index] = arr[current];
				arr[current] = temp;
				index = current;
				System.out.println(" => Array: " + Arrays.toString(arr));
			} else 				
				break;			
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
		System.out.println("Before heapify(max): " + Arrays.toString(arr));
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			buildMaxHeap(arr, i);
		}
		System.out.println("After heapify(max): " + Arrays.toString(arr));
	}
}
