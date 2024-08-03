package Arrays;

//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-maximum-subarray-sum

//https://www.educative.io/courses/coderust-hacking-the-coding-interview/largest-sum-subarray

public class FindMaxSumSubArray {
    public static void main(String args[]) {

        int[] arr = {-4, 2, -5, 1, 2, 3, 6, -5, 1};
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
