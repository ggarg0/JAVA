package Recursion;

import java.util.Arrays;

public class ReverseArray {
    public static int[] reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static int[] reverseRecursion(int[] arr, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseRecursion(arr, start + 1, end - 1);
        }
        return arr;
    }


    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        System.out.println("Array input : " + Arrays.toString(arr));
        reverse(arr, 0, arr.length - 1);
        System.out.println("reverse : " + Arrays.toString(arr));
        reverseRecursion(arr, 0, arr.length - 1);
        System.out.println("reverseRecursion : " + Arrays.toString(arr));
    }
}
