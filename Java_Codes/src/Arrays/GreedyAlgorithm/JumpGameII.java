package Arrays.GreedyAlgorithm;

// https://leetcode.com/problems/jump-game-ii/description/

public class JumpGameII {
    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int current = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == current) {
                jumps++;
                current = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,0,1,4};
        System.out.println(jump(arr));
    }
}