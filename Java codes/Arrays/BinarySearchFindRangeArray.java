package Arrays;

public class BinarySearchFindRangeArray {

	public static int[] findRange(int[] arr, int key) {
		int[] result = new int[] { -1, -1 };
		result[0] = searchForKey(arr, key, true);
		result[1] = searchForKey(arr, key, false);
		return result;
	}

	public static int searchForKey(int[] arr, int key, boolean startingIndex) {
		int result = -1;
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] > key) {
				end = mid - 1;
			} else if (arr[mid] < key) {
				start = mid + 1;
			} else {
				result = mid;
				if (startingIndex) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = findRange(new int[] { 1, 3, 10, 10, 15 }, 10);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
	}
}
