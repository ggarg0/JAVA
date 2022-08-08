package Array;

import java.util.HashMap;
import java.util.Map;

public class FindFirstUnique {
	public static void main(String args[]) {

		int[] arr = { 2, 9, 54, 2, 6, 54 };
		Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
		int result = -1;
		for (int i = 0; i < arr.length; i++) {
			if (nums.containsKey(arr[i])) {
				nums.put(arr[i], nums.get(arr[i]) + 1);
			} else {
				nums.put(arr[i], 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (nums.get(arr[i]) == 1) {
				System.out.println(arr[i]);
				break;
			}

		}

	}
}
