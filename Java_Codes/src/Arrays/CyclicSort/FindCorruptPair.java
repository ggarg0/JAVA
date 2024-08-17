package Arrays.CyclicSort;

import java.util.Arrays;

public class FindCorruptPair {
    public static int[] findCorruptPair(int[] arr) {
        int[] pair = {0, 0};
        int start = 0;
        int end = arr.length;
        int value = 0;

        System.out.println("Array : " + Arrays.toString(arr));
        while (start < end) {
            value = arr[start];

            if (value > 0 && value <= end && arr[value - 1] != value) {
                int temp = arr[value - 1];
                arr[value - 1] = value;
                arr[start] = temp;
            } else {
                start++;
            }
        }

        System.out.println("Sorted Array : " + Arrays.toString(arr));

        for (int i = 0; i < end; i++) {
            if (i + 1 != arr[i]) {
                pair[0] = i + 1;
                pair[1] = arr[i];
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        //  int[] arr = {3, 1, 2, 3, 6, 4};
        //  int[] arr =  {4, 1, 2, 1, 6, 3};
        int[] arr = {5, 3, 5, 6, 2, 1};
        //int[] arr = {3, 1, 2, 5, 2};
        System.out.println("Missing number: " + Arrays.toString(findCorruptPair(arr)));
    }
}
