package array;

public class BinarySearchRotated {
	public static void main(String[] args) {

		int[] arr = { 6, 7, 1, 2, 3, 4, 5 };
		int target = 5;

		int start = 0;
		int end = arr.length - 1;
		int mid = (start + end) / 2;
		int foundIndex = -1;

		while (start <= end) {
			if (arr[mid] == target) {
				foundIndex = mid;
				break;
			}

			if (arr[mid] < target && arr[end] >= target) {
				start = mid + 1;
			} else {
				end = mid;
			}
			mid = (start + end) / 2;
		}
		System.out.print("Found at " + foundIndex);
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}
