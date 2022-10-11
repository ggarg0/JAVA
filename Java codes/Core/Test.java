package Core;

import java.util.Arrays;

public class Test {

public static void buildMaxHeap(int[] arr, int index){
	int largest = index;
	while(largest < (arr.length/2)){
		int left = (2 * index) + 1;
		int right = (2 * index) + 2;

		if(left < arr.length && arr[left] > arr[largest])
			largest = left;

		if(right < arr.length && arr[right] > arr[largest])
			largest = right;

		if(index != largest){
			int temp = arr[largest];
			arr[largest] = arr[index];
			arr[index] = temp;
			index = largest;
		}else
			break;
	}
}


public static void main(String[] args) {
	int[] arr = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
	System.out.println("Before heapify: " + Arrays.toString(arr));
	for(int i = (arr.length -1)/2; i>=0 ; i--){
		buildMaxHeap(arr, i);
	}
	System.out.println("After heapify: " + Arrays.toString(arr));
	}
}
