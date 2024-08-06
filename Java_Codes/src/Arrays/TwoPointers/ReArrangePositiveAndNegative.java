package Arrays.TwoPointers;

// https://www.educative.io/courses/data-structures-coding-interviews-java/challenge-rearrange-positive-negative-values

import java.util.Arrays;

public class ReArrangePositiveAndNegative {
    public static void main(String[] args) {
        int[] arr = {2, 4, -6, 0, -5, -10};
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[right] < 0) {
                swap(arr, left, right);
                left++;
            } else {
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
