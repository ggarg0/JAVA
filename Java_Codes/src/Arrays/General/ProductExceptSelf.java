package Arrays.General;

import java.util.Arrays;

//https://www.educative.io/courses/coderust-hacking-the-coding-interview/product-of-all-array-elements-except-self

public class ProductExceptSelf {
    public static void main(String args[]) {
        int[] arr = {1, 2, 6, 4};
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            int counter = 0;
            while (counter < arr.length) {
                if (counter != i)
                    product *= arr[counter];

                counter++;
            }
            result[i] = product;
        }
        System.out.println(Arrays.toString(result));

        // approach 2
        int n = arr.length;
        int i, temp = 1;
        int product[] = new int[n];

        for (i = 0; i < n; i++) {
            product[i] = temp;
            temp = temp * arr[i];
        }

        temp = 1;

        for (i = n - 1; i >= 0; i--) {
            product[i] = product[i] * temp;
            temp = temp * arr[i];
        }

        System.out.println(Arrays.toString(product));
    }
}
