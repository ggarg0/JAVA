package array;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 4, 6, 7, 8, 9 };
		int find = 9;
		int indexFound = -1;

		int start = 0;
		int end = arr.length;
		int mid = (start + end) / 2;

		for (; start < end;) {
			if (arr[mid] == find) {
				indexFound = mid;
				break;
			}

			if (find < arr[mid])
				end = mid;
			else
				start = mid + 1;

			mid = (start + end) / 2;
		}

		System.out.println("Found at index : " + indexFound);
	}

}
