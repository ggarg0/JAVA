package Arrays;

/*
A Bitonic Sequence is a sequence of numbers that is first strictly increasing then after a point decreasing.
*/

public class BinarySearchMaxInBitonicArray {

	public static int findMax(int[] arr) {
		int start = 0, end = arr.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] > arr[mid + 1]) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		return arr[start];
	}

	public static void main(String[] args) {
		System.out.println(findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
		System.out.println(findMax(new int[] { 3, 8, 3, 1 }));
		System.out.println(findMax(new int[] { 1, 3, 8, 12 }));
		System.out.println(findMax(new int[] { 10, 9, 8 }));
	}

}
