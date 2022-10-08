package Arrays;

import java.util.Arrays;

public class MergeTwoSortedArray {

	public static void mergeWithNewArray(int[] arr1, int s1, int[] arr2, int s2) {
		int[] result = new int[s1 + s2];

		int i = 0;
		int j = 0;
		int n = 0;
		while (i < s1 && j < s2) {
			if (arr1[i] < arr2[j])
				result[n++] = arr1[i++];
			else
				result[n++] = arr2[j++];
		}

		while (i < s1)
			result[n++] = arr1[i++];

		while (j < s2)
			result[n++] = arr2[j++];

		System.out.println(Arrays.toString(result));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1, p2 = n - 1, i = m + n - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[i--] = nums1[p1--];
			} else {
				nums1[i--] = nums2[p2--];
			}
		}
		System.out.println(Arrays.toString(nums1));
	}

	public static void main(String[] args) {

		int[] arr1 = { 1, 3, 4, 5, 17, 18, 20 };
		int[] arr2 = { 2, 6, 7, 8, 9 };
		mergeWithNewArray(arr1, arr1.length, arr2, arr2.length);

		int[] arr3 = { 1, 2, 3, 0, 0, 0 };
		int[] arr4 = { 2, 5, 6 };

		merge(arr3, 3, arr4, 3);
	}
}
