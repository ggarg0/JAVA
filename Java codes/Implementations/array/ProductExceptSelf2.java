package array;

public class ProductExceptSelf2 {
	public static void main(String args[]) {
		int[] arr = { 2, 3, 5 };
		int n = arr.length;
		int i, temp = 1;

		int result[] = new int[n];

		for (i = 0; i < n; i++) {
			result[i] = temp;
			temp = temp * arr[i];
		}

		temp = 1;

		for (i = n - 1; i >= 0; i--) {
			result[i] = result[i] * temp;
			temp = temp * arr[i];
		}

		for (int j = 0; j < n; j++) {
			System.out.print(result[j] + ", ");
		}
	}
}
