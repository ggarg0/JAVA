package Array;

import java.util.HashSet;
import java.util.Set;

public class FindTwoSum {

	public static void main(String args[]) {
		int[] arr = { 1, 21, 3, 14, 5, 60, 7, 6 };
		int target = 19;

		int[] result = new int[2];

		Set<Integer> nums = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (nums.contains(target - arr[i])) {
				result[0] = target - arr[i];
				result[1] = arr[i];
			} else {
				nums.add(arr[i]);
			}
		}

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}

	}

}
