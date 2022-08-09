package array;

import java.util.Arrays;

public class ReArrangePositiveAndNegative {
	public static void main(String args[]) {

		int[] arr = { 2, 4, -6, 8, -5, -10 };
		int len = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + ", ");
		}

	}
}
