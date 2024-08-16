package Arrays.TwoPointers;

//https://www.educative.io/courses/coderust-hacking-the-coding-interview/container-with-most-water

import java.util.Arrays;

public class WaterContainer {
    public static int maxWaterAreaContainer(int[] height) {
        int maxArea = Integer.MIN_VALUE, left = 0, right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] inputList = {{1, 8, 6, 2, 5, 4, 8, 3, 7}, {20, 30, 9, 69}, {13, 18, 12, 8},
                {45, 32, 56, 99}, {23, 20}};
        int index = 0;
        for (int[] input : inputList) {
            System.out.println((++index) + ". maxWaterAreaContainer(" + Arrays.toString(input) + "): "
                    + maxWaterAreaContainer(input));
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }
}
