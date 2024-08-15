package Arrays.GreedyAlgorithm;

import java.util.Arrays;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-jump-game-i

public class JumpGame {
    public static boolean jumpGame(int[] jumps) {
        int index = jumps.length - 1;
        for (int current = jumps.length - 2; current >= 0; current--) {
            if ((current + jumps[current]) >= index) {
                index = current;
            }
        }
        return index == 0;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 2, 2, 0, 1, 4},
                {2, 3, 1, 1, 9},
                {3, 2, 1, 0, 4},
                {0},
                {1},
                {4, 3, 2, 1, 0},
                {1, 1, 1, 1, 1},
                {4, 0, 0, 0, 1},
                {3, 3, 3, 3, 3},
                {1, 2, 3, 4, 5, 6, 7}
        };
        for (int i = 0; i < nums.length; i++) {
            System.out.println((i + 1) + ".\tInput array: " + Arrays.toString(nums[i]));
            if (jumpGame(nums[i]))
                System.out.println("\tCan we reach the very last index? True");
            else
                System.out.println("\tCan we reach the very last index? False");

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
