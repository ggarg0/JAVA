package Arrays;

import java.util.Arrays;

public class RotateArrayByOne {

	public static void main(String args[]) {

		int[] arr = { 3, 2, 7, 8, 4 };
		int len = arr.length;
		System.out.println(Arrays.toString(arr));
	
		// Approach 1
		int next = arr[0];
		int temp = 0;

		for (int i = 0; i < len - 1; i++) {
			temp = next;
			next = arr[i + 1];
			arr[i + 1] = temp;
		}

		arr[0] = next;
		System.out.println(Arrays.toString(arr));


		// Approach 2
		int last = arr[len - 1];
		for (int i = len - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = last;
		System.out.println(Arrays.toString(arr));
	}
}
