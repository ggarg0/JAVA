package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairWithTargetSum {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 9, 11};
		int target =11;
		int[] result = new int[2];

		Map<Integer, Integer> index = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (index.containsKey(target - arr[i])) {
				result[0] = index.get(target - arr[i]);
				result[1] = i;
			} else {
				index.put(arr[i], i);
			}
		}
		System.out.println(Arrays.toString(result));

	}

}
