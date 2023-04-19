package Recursion;

import java.util.Arrays;

public class DisplayArray {

	public static void display(int[] arr, int index) {
		if (index == arr.length)
			return;
		else {
			System.out.print(arr[index] + " ");
			display(arr, index + 1);			
		}
	}
	
	public static void displayReverse(int[] arr, int index) {
		if (index == arr.length)
			return;
		else {
			displayReverse(arr, index + 1);			
			System.out.print(arr[index] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 9, 2, 1 };

		System.out.println(Arrays.toString(arr));
		display(arr, 0);
		System.out.println();
		displayReverse(arr, 0);

	}
}
