
public class BinarySearchExample {
	public static void binarySearch(int arr[], int key) {

		int start = 0;
		int last = arr.length - 1;
		int mid = (start + last) / 2;

		while (start <= last) {
			if (arr[mid] < key) {
				start = mid + 1;
			} else if (arr[mid] == key) {
				System.out.println("Element is found at index: " + mid);
				break;
			} else {
				last = mid - 1;
			}
			mid = (start + last) / 2;
		}
		if (start > last) {
			System.out.println("Element is not found!");
		}
	}

	public static void main(String args[]) {
		int arr[] = { -1, 5, 6, 8, 11, 15 };
		int key = -1;
		binarySearch(arr, key);
	}
}
