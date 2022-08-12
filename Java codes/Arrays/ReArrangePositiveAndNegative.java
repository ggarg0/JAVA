package Arrays;

import java.util.Arrays;

public class ReArrangePositiveAndNegative {
	public static void main(String args[]) {

		int[] arr = { 2, 4, -6, 8, -5, -10 };
		int len = arr.length;
		int j = 0;
		int temp = 0;

		for (int i = 0; i < len; i++) {
			if (arr[i] < 0 && i != j) {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
