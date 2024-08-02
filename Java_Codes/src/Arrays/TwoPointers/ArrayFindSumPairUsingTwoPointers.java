package Arrays.TwoPointers;

import java.util.Arrays;

public class ArrayFindSumPairUsingTwoPointers {

    public static void main(String[] args) {
        int[] arr = {12, 34, 60, 45, 40};
        int target = 105;

        int start = 0;
        int end = arr.length - 1;
        int sum = Integer.MIN_VALUE;
        Arrays.sort(arr);

        while (start < end) {
            sum = arr[start] + arr[end];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println("Pair with given sum " + sum
                + " is (" + arr[start] + ", " + arr[end] + ")");
    }
}

