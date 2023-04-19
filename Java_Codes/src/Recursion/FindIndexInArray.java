package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class FindIndexInArray {

	public static int findFirstIndex(int[] arr, int index, int key) {
		if (index == arr.length)
			return -1;

		if (key == arr[index])
			return index;
		else
			return findFirstIndex(arr, index + 1, key);
	}

	public static int findLastIndex(int[] arr, int index, int key) {
		if (index == arr.length)
			return -1;

		int result = findLastIndex(arr, index + 1, key);
		if (result == -1) {
			if (arr[index] == key)
				return index;
			else
				return -1;
		} else
			return result;
	}

	public static void findAllIndexes(int[] arr, int index, int key, ArrayList<Integer> list) {

		if (index == arr.length)
			return;
		else {
			findAllIndexes(arr, index + 1, key, list);
			if (arr[index] == key)
				list.add(index);
		}	
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 6, 8, 7 };
		System.out.println(Arrays.toString(arr));
		System.out.println("findFirstIndex : " + findFirstIndex(arr, 0, 7));
		System.out.println("findLastIndex : " + findLastIndex(arr, 0, 7));

		ArrayList<Integer> result = new ArrayList<Integer>();
		findAllIndexes(arr, 0, 7, result);
		System.out.println("findAllIndexes : " + result.toString());
	}
}
