package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZeroArray {

	public static List<List<Integer>> searchTriplets(int[] arr) {
		Arrays.sort(arr);
		System.out.println("Sorted List " + Arrays.toString(arr));
		List<List<Integer>> triplets = new ArrayList<>();

		for (int i = 0; i < arr.length - 1; i++) 
			searchPair(arr, -arr[i], i + 1, triplets);
		
		return triplets;
	}

	private static void searchPair(int[] arr, int targetSum, int start, List<List<Integer>> triplets) {
		int end = arr.length - 1;
		while (start < end) {
		//	System.out.println(-targetSum + ", " + arr[start] + ", " + arr[end]);
			int currentSum = arr[start] + arr[end];
			if (currentSum == targetSum && !triplets.contains(Arrays.asList(-targetSum, arr[start], arr[end]))) {
				triplets.add(Arrays.asList(-targetSum, arr[start], arr[end]));
				start++;
				end--;
			} else if (currentSum > targetSum) {
				end--;
			} else {
				start++;
			}
		}
	}

	public static void main(String[] args) {
		//System.out.println("Triplets found : " + searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		System.out.println("Triplets found : " + searchTriplets(new int[] { 2, -1, -1, -2, 3, 3 }));
	}
}
