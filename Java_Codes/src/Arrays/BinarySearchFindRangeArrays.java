package Arrays;

//https://www.educative.io/courses/coderust-hacking-the-coding-interview/find-low-high-index-of-a-key-in-a-sorted-array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchFindRangeArrays {

    public static int findIndexes(int[] arr, int key, boolean firstIndex) {
        int result = -1;

        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == key) {
                result = mid;
                if (firstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9};
        int key = 1;
        System.out.println("First index : " + findIndexes(arr, key, true)
                + " & last index : " + findIndexes(arr, key, false));
    }
}
