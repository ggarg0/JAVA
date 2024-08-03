package Arrays.TwoPointers;

import java.util.*;

public class TripletSumWithGivenTarget {

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 2, 8, 4, 5, 6};
        int target = 10;
        System.out.println(Arrays.toString(arr));
        System.out.println("*********************************************");
        System.out.println(findSumThree(arr, target));
        System.out.println("*********************************************");
        System.out.println(findSumOfThree(arr, target));
        System.out.println("*********************************************");
    }

    public static boolean findSumThree(int nums[], int target) {
        boolean flag = false;
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int mid = nums.length / 2;
        int sum = Integer.MIN_VALUE;

        while (low < high) {
            sum = nums[mid] + nums[low] + nums[high];
            if (sum == target) {
                System.out.println("Found :  [" + nums[low] + ", " + nums[mid] + ", " + nums[high] + "]");
                low++;
                high--;
                flag = true;
            } else if (sum < target)
                low++;
            else
                high--;
        }
        return flag;
    }

    public static boolean findSumOfThree(int nums[], int target) {
        boolean flag = false;
        Arrays.sort(nums);
        int low, high, triples;

        for (int i = 0; i < nums.length - 2; i++) {
            low = i + 1;
            high = nums.length - 1;

            while (low < high) {
                triples = nums[i] + nums[low] + nums[high];
                if (triples == target) {
                    System.out.println("Found :  [" + nums[i] + ", " + nums[low] + ", " + nums[high] + "]");
                    low++;
                    high--;
                    flag = true;
                } else if (triples < target)
                    low++;
                else
                    high--;
            }
        }
        return flag;
    }
}
