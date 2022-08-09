package array;

public class FindMaxSumSubArray {
	public static void main(String args[]) {

		int[] arr = {1, 7, -2 };
		int max = 0;
		int globalMax =0;
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (max < 0) {
				max = arr[i];
			} else {
				max = max + arr[i];
			}

			if (max > globalMax) {
				globalMax = max;
			}
		}
		System.out.println("Last : " + globalMax);
		// display(arr);
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

}
