package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFirstUniqueArray {
	public static void main(String args[]) {

		// Using MAP
		int[] arr = { 2, 54, 7, 2, 6, 54 };
		Map<Integer, Integer> nums = new HashMap<Integer, Integer>();

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

		// Using list
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (list.contains(arr[i])) {
				list.remove(new Integer(arr[i]));
			} else {
				list.add(arr[i]);
			}
		}

		System.out.println(list.get(0));

	}
}
