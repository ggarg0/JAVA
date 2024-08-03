package Arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RankArrayElements {
	public static void main(String[] args) {
		int[] arr = { 40, 10, 10, 30 };

		int[] result = new int[arr.length];
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int num : arr) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			result[i] = map.get(arr[i]);
		}
		System.out.println(Arrays.toString(result));

	}

}
