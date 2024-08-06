package Arrays.DivideAndConquer;

import java.util.Arrays;

//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-shuffle-integers

public class ShuffleInteger {

	public static void shuffleArray(int arr[]) {
		int size = arr.length;
		if (size == 2 || size % 2 != 0) {
			System.out.println("After: " + Arrays.toString(arr));
		} else {
			int[] result = new int[size];
			for (int i = 0, j = 0; j < size / 2; j++) {
				result[i] = arr[j];
				result[i + 1] = arr[j + size / 2];
				i = i + 2;
			}
			System.out.println("After: " + Arrays.toString(result));
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 7, 9, 11, 13};
		System.out.println(Arrays.toString(arr));
		shuffleArray(arr);
	}
}
