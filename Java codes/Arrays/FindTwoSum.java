package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTwoSum {

	public static void main(String args[]) {
		int[] arr = { 2, 4, 5, 7, 8};
		int target = 9;

		int[] result = new int[] { -1, -1 };

		Set<Integer> nums = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (nums.contains(target - arr[i])) {
				result[0] = target - arr[i];
				result[1] = arr[i];
			} else {
				nums.add(arr[i]);
			}
		}
		System.out.println(Arrays.toString(result));
	}
}
