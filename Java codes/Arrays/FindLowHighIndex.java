package Arrays;

public class FindLowHighIndex {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6 };
		int target = 5;

		System.out.println("Low : " + findLowIndex(arr, target) + " and high : " + findHighIndex(arr, target));
	}

	static int findLowIndex(int[] nums, int target) {
		int low = 0;
		int high = nums.length;
		int mid = (low + high) / 2;

		while (low <= high && high >= mid) {
			int midElem = nums[mid];
			if (midElem < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			mid = (low + high) / 2 + 1;
		}
		//System.out.println("Low : " + low + ", mid : " + mid + " and high " + high);
		if (nums[mid] == target)
			return low;
		else
			return -1;
	}

	static int findHighIndex(int[] nums, int target) {
		int low = 0;
		int high = nums.length;
		int mid = (low + high) / 2;

		while (low <= high && high >= mid) {
			int midElem = nums[mid];
			if (midElem > target ) {
				high = mid - 1;
			} else {
				low = mid - 1;
			}
			mid = (low + high) / 2 + 1;
		}

		//System.out.println("Low : " + low + ", mid : " + mid + " and high " + high);
		if (nums[high] == target)
			return high;
		else
			return -1;
	}

}
