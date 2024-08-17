package Arrays.CyclicSort;

import java.util.Arrays;

public class FirstMissingPositiveInteger {

    public static int firstMissingPositiveInteger(int[] arr) {
        int start = 0;
        int end = arr.length;
        int value = 0;
        System.out.println("Array : " + Arrays.toString(arr));
        while (start < end) {
            value = arr[start];
            if (value > 0 && value < end && arr[value - 1] != value) {
                int temp = arr[value - 1];
                arr[value - 1] = value;
                arr[start] = temp;
            } else {
                start++;
            }

        }
        System.out.println("Sorted Array : " + Arrays.toString(arr));
        for (int i = 1; i <= end; i++) {
            if (i != arr[i - 1]) {
                return i;
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {
         int[] arr = {1};
        //  int[] arr =  {-1, 3, 5, 7, 1};
         // int[] arr = {-1, 0, 2, 1, 4};
      //  int[] arr = {3, -1, 8, 2, 5};
        System.out.println("Missing number: " + firstMissingPositiveInteger(arr));
    }
}
