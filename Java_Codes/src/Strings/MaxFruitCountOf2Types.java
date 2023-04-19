package Strings;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

	public static int findLength(char[] arr) {
		int start = 0;
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

			while (map.size() > 2) {
				map.put(arr[start], map.get(arr[start]) - 1);
				if (map.get(arr[start]) == 0) {
					map.remove(arr[start]);
				}
				start++;
			}
			maxLength = Math.max(maxLength, i - start + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println("Maximum number of fruits: "
				+ MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'B', 'A', 'C' }));
		System.out.println("Maximum number of fruits: "
				+ MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

	}

}
