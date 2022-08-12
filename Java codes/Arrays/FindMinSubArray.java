package Arrays;

public class FindMinSubArray {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5 };
		int key = 7;
		int sum = 0;
		int count = 0;
		int maxCount = arr.length;
		int start = 0;
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			sum = sum + arr[i];
			count++;
			if (sum >= key) {
				maxCount = Math.min(count, maxCount);
				sum = sum - arr[start];
				start++;
				count = 1;
			}
		}
		System.out.println(maxCount = Math.min(count, maxCount));
	}
}
