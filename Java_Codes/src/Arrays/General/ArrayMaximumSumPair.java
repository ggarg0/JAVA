package Arrays.General;

import java.util.Arrays;

class ArrayMaximumSumPair {
    public static void main(String[] args) {
        int[] arr = {4, -1, -9, 1, -7};
        if (arr.length < 2) {
            System.out.println("Array must contain at least two elements.");
            return;
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        int firstIndex = -1, secondIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                secondIndex = firstIndex;
                first = arr[i];
                firstIndex = i;
            } else if (arr[i] > second) {
                second = arr[i];
                secondIndex = i;
            }
        }
        System.out.println("Pair with given sum " + (first + second) +
                " is (" + first + ", " + second + ") and indexes : " +
                Arrays.toString(new int[]{firstIndex, secondIndex}));
    }
}