package Arrays.CyclicSort;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int end = nums.length;
        int start = 0;
        int value = 0;

        while (start < end) {
            value = nums[start];
            if (value < end && value != nums[value]) {
                int temp = nums[start];
                nums[start] = nums[value];
                nums[value] = temp;
            } else {
                start += 1;
            }
        }

        for (int x = 0; x < end; x++) {
            if (x != nums[x]) {
                return x;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 2, 4, 6, 0, 1};
        System.out.println("\n\tMissing number: " + findMissingNumber(arr));
    }
}
