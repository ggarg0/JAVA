package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class FindSymmetricPairs {

	public static List<List<Integer>> findSymmetric(int[][] arr) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> items = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			int first = arr[i][0];
			int second = arr[i][1];
			Integer value = items.get(second);
			if (value != null && value == first) {
				result.add(Arrays.asList(second, value));
				result.add(Arrays.asList(first, second));
			} else {
				items.put(first, second);
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int[][] arr = { { 1, 2 }, { 3, 4 }, { 5, 9 }, { 4, 3 }, { 9, 5 } };
		System.out.println(findSymmetric(arr));
	}
}
