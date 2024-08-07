package Core.generic;

import java.util.Arrays;

public class GenericMethod {

	public static <E> void printArray(E[] inputArray) {
		System.out.println(Arrays.toString(inputArray));
	}

	public static void main(String[] args) {
		// Create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		printArray(intArray);

		System.out.println("\nArray doubleArray contains:");
		printArray(doubleArray);

		System.out.println("\nArray characterArray contains:");
		printArray(charArray);
	}

}
