package Arrays;

public class BinarySearchFloorArray {

	public static int searchFloorOfANumber(int[] arr, int key) {

		if (key < arr[0])
			return -1;

		int start = 0;
		int end = arr.length - 1;
		int mid = 0;

		while (start < end) {
			mid = (start + end) / 2;
			
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}			
		}
		return end;
	}

	public static void main(String[] args) {
	//	System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));
		System.out.println(searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
	//	System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 17));
	//	System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));
	//	System.out.println(searchFloorOfANumber(new int[] { -1, 0 ,4, 5, 6, 8, 10, 16}, 3));
	}
}
