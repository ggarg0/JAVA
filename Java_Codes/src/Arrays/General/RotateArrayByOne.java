package Arrays.General;

import java.util.Arrays;

public class RotateArrayByOne {

    public static void main(String args[]) {

        int[] arr = {3, 2, 7, 8, 4};
        int len = arr.length;
        System.out.println(Arrays.toString(arr));

        // Approach 1
        int next = arr[0];
        int temp = 0;

        for (int i = 0; i < len - 1; i++) {
            temp = next;
            next = arr[i + 1];
            arr[i + 1] = temp;
        }

        arr[0] = next;
        System.out.println(Arrays.toString(arr));


        // Approach 2
        int right = arr.length - 2;
        int last = arr[arr.length - 1];

        while (right >= 0) {
            arr[right + 1] = arr[right];
            if (right == 0) {
                arr[right] = last;
            }
            right--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
