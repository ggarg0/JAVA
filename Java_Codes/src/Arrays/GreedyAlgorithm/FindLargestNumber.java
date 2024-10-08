package Arrays.GreedyAlgorithm;

import java.util.Arrays;

//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-find-the-largest-number

public class FindLargestNumber {

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
		int sumOfDigits = 17;
		int numberOfDigits = 3;
		findLargestNumber(numberOfDigits, sumOfDigits);
	}
}

