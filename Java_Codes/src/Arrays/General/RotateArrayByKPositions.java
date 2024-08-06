package Arrays.General;

import java.util.Arrays;

//https://www.educative.io/courses/data-structures-coding-interviews-java/solution-rotate-array

public class RotateArrayByKPositions {

    public static int[] rotateArrayRight(int[] arr, int key) {
        int[] result = new int[arr.length];

        if (arr.length == 0)
            key = 0;
        else
            key = key % arr.length;

        for (int i = 0; i < arr.length && i <= (arr.length - key); i++)
            result[i] = arr[i + (key - 1)];

        for (int i = key; i < arr.length; i++)
            result[i] = arr[i - key];

        return result;
    }

    public static void main(String args[]) {
        int[] arr = {-1, 90, -90, 4, 6}; // {-90 ,4 ,6 , -1, 90}
        System.out.println("Rotated Array : " + Arrays.toString(rotateArrayRight(arr, 3)));
    }
}
