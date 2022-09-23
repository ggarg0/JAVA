package Arrays;

public class FindMaxSumSubArray {
	public static void main(String args[]) {

		int[] arr = {-1, -3, 4, -1, -2, 1, 5, -3};
		int currMax = arr[0];
		int max = arr[0];

		//The Kadane’s algorithm#
		for (int i = 1; i < arr.length; i++) {
			currMax = Math.max(arr[i], currMax + arr[i]);
			max = Math.max(max, currMax);
		}
		/*
		for (int i = 1; i < size; i++) {
			if (currMax < 0) {
				currMax = arr[i];
			} else {
				currMax = currMax + arr[i];
			}

			if (currMax > maxSoFar) {
				maxSoFar = currMax;
			}
		}
		*/
		System.out.println("Max Sum : " + max);
	}
}
