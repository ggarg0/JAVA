package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchFindRangeArrays {

	public static int search(int[] nums, int target, boolean startingIndex) {
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		int result = -1;

		while (start <= end) {
			mid = (start + end) / 2;
			if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				result = mid;
				if (startingIndex) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return result;
	}

	public static List<Integer> targetIndices(int[] nums, int target) {
		int smaller = 0;
		int equal = 0;
		for (int num : nums) {
			if (num < target) {
				smaller++;
			} else if (num == target) {
				equal++;
			}
		}
		List<Integer> indices = new ArrayList<>(equal);
		for (int i = smaller; i < smaller + equal; i++) {
			indices.add(i);
		}
		return indices;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 5, 2, 3 };
		int target = 2;
		
		System.out.println(targetIndices(nums, target));
		
		Arrays.sort(nums);
		int startIndex = search(nums, target, true);
		int endIndex = search(nums, target, false);
		List<Integer> result = new ArrayList<Integer>();

		if (startIndex >= 0 && endIndex - startIndex >= 0) {
			for (int i = startIndex; i <= endIndex; i++)
				result.add(i);
		}
		System.out.println(result.toString());
		
	}

}
