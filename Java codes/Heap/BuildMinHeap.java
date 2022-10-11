package Heap;

import java.util.Arrays;

public class BuildMinHeap {

	public static void buildMinHeap(int[] arr, int index) {
		int current = index;
		while(current < arr.length) {
			int left = (index * 2) + 1;
			int right = (index * 2) + 2;
			
			if(left < arr.length && arr[left] < arr[current]) 
				current = left;
			
			if(right < arr.length && arr[right] < arr[current]) 
				current = right;
			
			if(current != index) {
				int temp = arr[index];
				arr[index] = arr[current];
				arr[current] = temp;
				index = current;
			}else
				break;
		}
		
	}

	public static void main(String[] args) {
		int[] arr = { 16, 15, 14, 12, 4, 7, 9, 2, 3, 1 };
		System.out.println("Before heapify(min): " + Arrays.toString(arr));
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			buildMinHeap(arr, i);
		}
		System.out.println("After heapify(min): " + Arrays.toString(arr));

	}

}
