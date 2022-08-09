package array;

import java.util.Arrays;

public class FindSecondMaximum {
	public static void main(String args[]) {

		int[] arr = { 9, 2, 3, 2, 6, 8 };
		Arrays.sort(arr);
		System.out.println(arr[arr.length - 2]);

	}
}
