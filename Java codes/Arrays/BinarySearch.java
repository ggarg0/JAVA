package Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 6, 7, 8, 9 };
		int find = 8;
		int indexFound = -1;

		int start = 0;
		int end = arr.length;
		int mid = 0;
		
		while (start < end) {
			mid = (start + end)/2;
			if(arr[mid] == find) {
				indexFound = mid;
				break;
			}
			
			if(arr[mid] > find)
				end = mid;
			else
				start = mid + 1;			
		}		
		System.out.println("Index found : " + indexFound);
	}
}
