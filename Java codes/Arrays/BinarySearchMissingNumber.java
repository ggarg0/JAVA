package Arrays;

import java.util.Arrays;

public class BinarySearchMissingNumber {

	public static int missingNumber(int arr[], int size) {
		int start = 0;
		int mid = 0;
		int end = arr.length - 1;

		if (arr[start] != 1)
			return 1;

		while (start <= end) {
			mid = (start + end) / 2;

			if (arr[mid] != mid + 1 && arr[mid - 1] == mid) {
				return mid + 1;
			}

			if (arr[mid] == (mid + 1)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] input1 = { 1, 2, 4 };
		int[] input2 = { 1, 2, 3, 4, 6 };
		int[] input3 = { 2, 3, 4, 5, 6 };
		int[] input4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println("Find the Missing Number!");
		System.out.println(Arrays.toString(input1) + " --> " + missingNumber(input1, input1.length));
		System.out.println(Arrays.toString(input2) + " --> " + missingNumber(input2, input2.length));
		System.out.println(Arrays.toString(input3) + " --> " + missingNumber(input3, input3.length));
		System.out.println(Arrays.toString(input4) + " --> " + missingNumber(input4, input4.length));

	}

}
