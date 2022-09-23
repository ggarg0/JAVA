package Core;

import java.util.Arrays;

public class Test {
	public static int findFloor(int[] arr, int key) {
		int start = 0;
		int mid = 0;
		int end = arr.length - 1;
	
		while (start < end) {
			mid = (start + end) / 2;

			if (arr[mid] == key) {
				return arr[mid];
			}

			if (arr[mid] > key) {
				end = mid -1 ;				
			} else {
				start = mid;
			}
		}
		return arr[start];
	}

	public static int findCeiling(int[] arr, int key) {
		int start = 0;
		int mid = 0;
		int end = arr.length - 1;
		
		while (start < end) {
			mid = (start + end) / 2;

			if (arr[mid] == key) {
				return arr[mid];
			}

			if (arr[mid] > key) {
				end = mid ;				
			} else {
				start = mid + 1;
			}
		}
		return arr[end];
	}

	public static void main(String[] args) {
		int[] inputs = { 1, 2, 3, 5, 7 };
		System.out.println("Array : " + Arrays.toString(inputs) + " => Floor : " + findFloor(inputs, 4)
				+ " and Ceiling : " + findCeiling(inputs, 4));

	}
}
