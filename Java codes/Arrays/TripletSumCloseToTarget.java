package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {

	public static void searchTriplet(int[] arr, int target) {
		Arrays.sort(arr);
		int smallestSum = Integer.MAX_VALUE;
		int result = 0;
		List<List<Integer>> triplets = new ArrayList<>();
		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1;
			int right = arr.length - 1;
			System.out.println("Array " + Arrays.toString(arr));
			while (left < right) {
				int tripletSum = arr[i] + arr[left] + arr[right];
				System.out.println("Checking : " + arr[i] + ", " + arr[left] + ", " + arr[right]);
				if (Math.abs(target - tripletSum) < smallestSum) {
					result = tripletSum;
					smallestSum = Math.abs(target - tripletSum);
					if (triplets.isEmpty()) {
						triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
					} else {
						triplets.remove(0);
						triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
					}
					System.out.println("Triplet : " + triplets + " with sum as " + result);
				}

				if (target == tripletSum)
					break;

				if (tripletSum > target)
					right--;
				else
					left++;

			}
		}
		System.out.println("Triplet : " + triplets + " with sum as " + result);
	}

	public static void main(String[] args) {
		//searchTriplet(new int[] { -1, 2, 1, -4 }, 1);
	//	searchTriplet(new int[] { -3, -1, 1, 2 }, 1);
		searchTriplet(new int[] { 4,5,-5,3,0,-4}, -2);

	}
}
