package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithSameSum {

	public static String findPair(int[] arr) {
		String result = "";
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((map.containsKey(arr[i] + arr[j]))) {
					result += "{" + Arrays.toString(map.get(arr[i] + arr[j])) + " and [" + arr[i] + ", " + arr[j]
							+ "]} ";
				//	return result;
				} else {
					map.put((arr[i] + arr[j]), new int[] { arr[i], arr[j] });
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 7, 1, 12, 9 };
		System.out.println(findPair(arr));

	}

}
