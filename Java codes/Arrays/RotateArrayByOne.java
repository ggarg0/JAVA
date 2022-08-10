package Arrays;

public class RotateArrayByOne {

	public static void main(String args[]) {

		int[] arr = { 3, 2, 7, 8, 4 };
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		// Approach 1
		int next = arr[0];
		int temp = 0;

		for (int i = 0; i < len - 1; i++) {
			temp = next;
			next = arr[i + 1];
			arr[i + 1] = temp;
		}

		arr[0] = next;

		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
		// Approach 2
		int last = arr[len - 1];
		for (int i = len - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = last;
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}
