package Arrays;

import java.util.Arrays;

class ArrayMaximumSumPair {
    public static void main(String[] args) {
        int[] arr = {-4, -1, -9, 1, -7};
        int first, second;
        int[] indexes = {-1, -1};
        int sum;

        if (arr[0] > arr[1]) {
            first = arr[0];
            second = arr[1];
            indexes[0] = 0;
            indexes[1] = 1;
        } else {
            first = arr[1];
            second = arr[0];
            indexes[0] = 1;
            indexes[1] = 0;
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
                indexes[1] = indexes[0];
                indexes[0] = i;
            } else if (arr[i] > second) {
                second = arr[i];
                indexes[1] = i;
            }
        }
        sum = first + second;

        System.out.println("Pair with given sum " + sum
                + " is (" + first + ", " + second + ") and indexes : " + Arrays.toString(indexes));
    }
}