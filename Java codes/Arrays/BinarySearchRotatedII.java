package Arrays;

public class BinarySearchRotatedII {

	public static boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return true;
			
			if (nums[mid] == nums[start])
				start++;
			else if (nums[mid] >= nums[start]) {
				if (nums[mid] > target && nums[start] <= target)
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (nums[mid] < target && nums[end] >= target)
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 1, 1 };
		int target = 0;
		System.out.println(search(arr, target));

	}

}
