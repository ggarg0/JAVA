package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {

	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		double product = 1;
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			product *= arr[right];
			while (product >= target && left < arr.length)
				product /= arr[left++];

			List<Integer> tempList = new LinkedList<>();
			for (int i = right; i >= left; i--) {
				tempList.add(0, arr[i]);
				result.add(new ArrayList<>(tempList));
			}
		}
		return result;
	}

	public static int countSubArraysProudctLessThanK(int[] arr, int k) {
		int start = 0;
		int end = 1;
		long product = arr[0];
		int count = 0;
		while (start <= end && end <= arr.length) {
			if (product < k) {
				count += end - start;
				if (end < arr.length)
					product *= arr[end];
				end++;
			} else {
				product /= arr[start++];
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findSubarrays(new int[] { 2, 2, 5, 3, 10 }, 30));
		System.out.println(countSubArraysProudctLessThanK(new int[] { 2, 2, 5, 3, 10 }, 30));
	}
}
