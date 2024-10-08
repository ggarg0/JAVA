package Arrays.General;

//https://www.educative.io/courses/coderust-hacking-the-coding-interview/first-missing-positive-integer

import java.util.Arrays;
import java.util.HashSet;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int contains = 0;
        for (int i = 0; i < length; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        for (int i = 0; i < length; i++)
            if ((nums[i] <= 0) || (nums[i] > length))
                nums[i] = 1;

        for (int i = 0; i < length; i++) {
            int a = Math.abs(nums[i]);

            if (a == length)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }

        for (int i = 1; i < length; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return length;

        return length + 1;
    }


    public static int firstMissingPositiveNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Driver code
        int[] nums = {5, 8, 2, 7, 1, 6, 3};
        System.out.print("1. The smallest missing positive integer in " + Arrays.toString(nums) + " is: ");
        //  System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositiveNumber(nums));
        System.out.println("---------------------------------------------------------------------------------------------------\n");

        int[] nums2 = {0, 5, 1, 3, 2, 4};
        System.out.print("2. The smallest missing positive integer in " + Arrays.toString(nums2) + " is: ");
       // System.out.println(firstMissingPositive(nums2));
        System.out.println(firstMissingPositiveNumber(nums2));
        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }
}
