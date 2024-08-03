package Arrays.SlidingWindow;

public class MaxSumSubArrayOfSizeK {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 8, 3, 2 };
		int key = 3;
		int maxSum = 0;
		int len = arr.length;

		// Approach 1
		for (int i = 0; i < len; i++) {
			int sum = 0;
			int start = i;
			int end = i + key;
			while (start < end && end <= len) {
				sum = sum + arr[start];
				start++;
			}

			maxSum = Math.max(maxSum, sum);
		}
		System.out.println(maxSum);

		// Approach 2: Sliding window
		int add = 0;
		int maxAdd = 0;
		int start = 0;

		for (int i = 0; i < len; i++) {
			add = add + arr[i];

			if (i >= key) {
				add = add - arr[start];
				start++;
				maxAdd = Math.max(maxAdd, add);
			} else {
				maxAdd = add;
			}
		}
		System.out.println(maxAdd);
	}

}
