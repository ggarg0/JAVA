package Arrays;

public class MaxInBitonicArray {

	public static int findMax(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = (start + end) / 2;

		while (start <= end) {
			if (arr[mid] < arr[mid + 1]) {
				start = mid;
			} else {
				end = mid + 1;
			}
			mid = (start + end) / 2;

		}

		return start;
	}

	public static void main(String[] args) {
		System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 8, 12, 4 }));
	//	System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
	//	System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
	//	System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));

	}

}
