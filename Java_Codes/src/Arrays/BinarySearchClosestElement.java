package Arrays;

//Find the Closest Number
//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-find-the-closest-number

import java.util.Arrays;

public class BinarySearchClosestElement {

    public static int searchClosestElement(int[] arr, int key) {
        System.out.println("Array : " + Arrays.toString(arr) + " & key : " + key);
        if (arr[0] > key) {
            return arr[0];
        }

        if (arr[arr.length - 1] < key) {
            return arr[arr.length - 1];
        }

        int start = 0, end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                return arr[mid];
            }
        }

        return ((key - arr[end]) > (arr[start] - key) ? arr[start] : arr[end]);
    }

    public static void main(String[] args) {
        System.out.println(searchClosestElement(new int[]{3, 5, 7, 8, 11, 17}, 10));
        System.out.println(searchClosestElement(new int[]{4, 6, 10}, 4));
        System.out.println(searchClosestElement(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(searchClosestElement(new int[]{4, 6, 10}, 17));
    }

}
