package Arrays.TwoPointers;

//https://www.educative.io/courses/data-structures-coding-interviews-java/solution-find-two-numbers-that-add-up-to-k

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSumPair {

    public static void main(String[] args) {
        int[] arr = {12, 34, 60, 45, 40};
        int target = 100;
        usingBinarySearch(arr, target);
        usingHashSet(arr, target);
    }

    public static void usingBinarySearch(int[] arr, int target) {
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

        if (sum == target) {
            System.out.println("Pair with given sum " + target
                    + " is (" + arr[start] + ", " + arr[end] + ")");
        } else {
            System.out.println("Pair with given sum " + target
                    + " not found.");
        }
    }

    public static void usingHashSet(int[] arr, int target) {
        boolean found = false;
        Set<Integer> values = new HashSet<>();
        for (int arrayValue : arr) {
            int secondNum = target - arrayValue;
            if (values.contains(secondNum)) {
                System.out.println(arrayValue + " & " + secondNum + " sum is equal to " + target);
                found = true;
                break;
            } else {
                values.add(arrayValue);
            }
        }

        if (!found) {
            System.out.println("No pair found with the given sum.");
        }
    }
}

