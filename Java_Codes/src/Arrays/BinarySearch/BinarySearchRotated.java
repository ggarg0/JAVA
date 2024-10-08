package Arrays.BinarySearch;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/search-in-rotated-sorted-array

public class BinarySearchRotated {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;

		int start = 0;
		int end = nums.length - 1;
		int mid;
		int foundIndex = -1;

		while (start <= end) {
			mid = (start + end) / 2;
			if (nums[mid] == target) {
				foundIndex = mid;
				break;
			}

			if (nums[start] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		System.out.print("Found at " + foundIndex);
	}
}
