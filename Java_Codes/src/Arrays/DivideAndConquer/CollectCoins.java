package Arrays.DivideAndConquer;

import java.util.Arrays;

//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-collect-coins-in-minimum-steps

public class CollectCoins {
    // Utility method, called recursively to collect coins from `l` to `r` using the height array assuming that h height has already been collected
    public static int minimumStepsUtil(int left, int right, int h, int height[]) {

        if (left >= right) // base case: all coins already collected
            return 0;

        int min = left;
        for (int i = left; i < right; i++) // finding minimum height index
        {
            if (height[i] < height[min])
                min = i;
        }

        return Math.min(right - left, minimumStepsUtil(left, min, height[min], height) +
                minimumStepsUtil(min + 1, right, height[min], height) + height[min] - h);
    }

    // calls the recursive utility function and returns the minimum number of steps using height array
    public static int minimumSteps(int height[], int N) {

        return minimumStepsUtil(0, N, 0, height);
    }

    // driver program to test the above functions
    public static void main(String args[]) {
        int[][] inputs = {{3, 1, 1, 5, 1}, {4, 2, 1, 5, 2}}; // you can always play around with these input values to see changing outputs
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Min Steps for " + Arrays.toString(inputs[i]) + " ---> " + minimumSteps(inputs[i], inputs[i].length));
        }
    }
}
