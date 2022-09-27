package Arrays;

import java.util.Arrays;

public class InversionCount {
	public static int InvCount(int[] arr) {
		int size = arr.length;
		int count = 0;
		for (int curr = 0; curr < size - 1; curr++)
			for (int right = curr + 1; right < size; right++)
				if (arr[curr] > arr[right])
					count++;

		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 8, 4 };
		System.out.println(Arrays.toString(arr) + "  --->  " + InvCount(arr));
	}
}
