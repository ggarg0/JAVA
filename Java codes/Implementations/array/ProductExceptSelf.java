package Array;

public class ProductExceptSelf {
	public static void main(String args[]) {
		int[] arr = { 1,2,3,4};
		int[] result = new int[arr.length];
		int size = arr.length;

		for (int i = 0; i < size; i++) {
			int temp = 1;
			int n = 0;
			while (n < size) {
				if (i != n) {
					temp = temp * arr[n];
				}
				n++;
			}
			result[i] = temp;
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}
}
