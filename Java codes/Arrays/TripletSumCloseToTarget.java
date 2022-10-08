package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {

	public static void searchTriplet(int[] arr, int targetSum) {
		Arrays.sort(arr);
		int smallestSum = Integer.MAX_VALUE;
		List<List<Integer>> triplets = new ArrayList<>();
		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1;
			int right = arr.length - 1;

			while (left < right) {
				int tripletSum = arr[i] + arr[left] + arr[right];
				//System.out.println("Checking " + arr[i] + ", " + arr[left] + ", " + arr[right]);
				if (tripletSum < smallestSum || (tripletSum > smallestSum && tripletSum < targetSum)) {
					smallestSum = tripletSum;
					if (triplets.isEmpty()) {
						triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
					} else {
						triplets.remove(0);
						triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
					}
					//System.out.println("Triplet : " + triplets + " with sum as " + smallestSum);
				}

				if (targetSum == smallestSum)
					break;

				if (smallestSum > targetSum)
					right--;
				else
					left++;

			}
		}
		System.out.println("Triplet : " + triplets + " with sum as " + smallestSum);
	}

	public static void main(String[] args) {
		searchTriplet(new int[] { -2, 0, 1, 2, -1 }, 0);
		searchTriplet(new int[] { -3, -1, 1, 2 }, 1);
		searchTriplet(new int[] { 1, 0, 1, 1 }, 1);
	}
}
