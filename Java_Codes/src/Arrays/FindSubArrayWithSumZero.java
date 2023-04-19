package Arrays;

import java.util.HashMap;

public class FindSubArrayWithSumZero {

	public static boolean findSubZero(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] == 0 || sum == 0 || map.get(sum) != null)
				return true;

			map.put(sum, i);
		}
		return false;
	}

	public static void main(String args[]) {
		int[] arr = { 6, 4, -7, 3, 12, 9 };
		System.out.println(findSubZero(arr));
	}
}
