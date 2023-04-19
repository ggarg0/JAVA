package Arrays;

import java.util.Arrays;

public class ProductExceptSelf {
	public static void main(String args[]) {
		int[] arr = { 1, 2, 6, 4 };
		int[] result = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int product = 1;
			int counter = 0;
			while (counter < arr.length) {
				if (counter != i) 
					product *= arr[counter];
				
				counter++;
			}
			result[i] = product;
		}
		System.out.println(Arrays.toString(result));
	}
}
