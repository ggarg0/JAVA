package Arrays;

import java.util.Arrays;

public class MaxNumber {

	public static void findLargestNumber(int number_of_digits, int sum_of_digits) {
		int[] result = new int[number_of_digits];
		int count = 0;

		if (number_of_digits == 0) {
			System.out.print("None");
			return;
		}
		
		if (number_of_digits * 9 < sum_of_digits) {
			System.out.print("None");
			return;
		}

		while (count < number_of_digits) {
			if (sum_of_digits > 9) {
				result[count++] = 9;
				sum_of_digits -= 9;
			} else {
				result[count++] = sum_of_digits;
				sum_of_digits -= sum_of_digits;
			}
		}
		System.out.println(Arrays.toString(result));
	}

	public static void main(String[] args) {
		int sumOfDigits = 20;
		int numberOfDigits = 2;
		findLargestNumber(numberOfDigits, sumOfDigits);
	}
}
