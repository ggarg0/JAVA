package Arrays;

public class BinarySearch {

    public static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        boolean ascending = arr[start] < arr[end];

        if (!ascending && (key > arr[start] || key < arr[end])) {
            return -1;
        } else if (ascending && (key < arr[start] || key > arr[end])) {
            return -1;
        }

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == key)
                return mid;

            if (ascending) {
				if (arr[mid] > key)
					end = mid;
				else
					start = mid + 1;
            } else {
				if (arr[mid] > key)
					start = mid + 1;
				else
					end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 8, 9};
		int[] arr1 = {10, 8, 7, 5, 4, 2, 1};
        int find = 5;
        System.out.println("Index found : " + search(arr, find));
		System.out.println("Index found : " + search(arr1, find));
    }
}
