package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] arr = { 7, 5, 4, 3, 11, 5, 11, 9, 3, 11 };
		System.out
				.println("Array : " + Arrays.toString(arr) + " and duplicates found " + findDuplicates(arr).toString());

	}

	public static List<Integer> findDuplicates(int[] arr) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				result.add(entry.getKey());
			}
		}
		return result;
	}
}
