package com.test;

public class SortSelection {
	public static void main(String a[]) {
		int[] arr = { 10, 34, 2, 56, 7, 67, 88, 42 };
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index]) {
					index = j;
				}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}