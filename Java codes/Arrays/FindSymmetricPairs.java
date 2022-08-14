package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FindSymmetricPairs {

	public static String findSymmetric(int[][] arr) {
		String result = "";
		Map<Integer, Integer> items = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			int first = arr[i][0];
			int second = arr[i][1];

			Integer value = items.get(second);
			if (value != null && value == first) {
				result += "{" + second + ", " + value + "}";
			} else {
				items.put(first, second);
			}

		}

		return result;
	}

	public static void main(String args[]) {

		int[][] arr = { { 1, 2 }, { 3, 4 }, { 5, 9 }, { 4, 3 }, { 9, 5 } };
		String symmetric = findSymmetric(arr);
		System.out.println(symmetric);

	}
}
