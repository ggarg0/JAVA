package Arrays;

public class BinarySearchCeilingArray {

	public static int searchCeilingOfANumber(int[] arr, int key) {

		if (key > arr[arr.length - 1])
			return -1;

		int start = 0, end = arr.length-1, mid = 0;

		while(start <= end) {
			mid = (start + end) /2;
			if(arr[mid] == key) {
				return mid;
			}else if (arr[mid] < key){
				start = mid + 1;
			} else {
				end = mid -1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
		System.out.println(searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
		System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
	}
}
