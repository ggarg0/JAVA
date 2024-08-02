package Arrays.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum {

	public static void searchTriplets(int[] arr, int target) {
		int count = 0;
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {

			int left = i + 1;
			int right = arr.length - 1;

			while (left < right) {
				int tripletSum = arr[i] + arr[left] + arr[right];

				if (tripletSum < target) {
					int counter = right;
					while (left < counter) {
						triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
						count++;
						counter--;
					}
					left++;
				} else {
					right--;
				}
			}
		}
		System.out.println("Triplet : " + triplets + " with count as " + count);
	}

	public static void main(String[] args) {
		searchTriplets(new int[] { -1, 0, 2, 3 }, 3);
		searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5);
	}

}
