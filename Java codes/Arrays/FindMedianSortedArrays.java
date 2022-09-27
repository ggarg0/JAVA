package Arrays;

import java.util.Arrays;

public class FindMedianSortedArrays {

	public static double getMedian(int array1[], int array2[]) {
		int sizeOfArray1 = array1.length;
		int sizeOfArray2 = array2.length;
		int arraySize = sizeOfArray1 + sizeOfArray2;
		int arraySizeMid = arraySize / 2;

		int i = 0;
		int j = 0;

		double median = -1;
		double previousMedian = -1;

		for (int k = 0; k <= arraySizeMid; k++) {
			previousMedian = median;
			if (i < sizeOfArray1 && j < sizeOfArray2) {
				if (array1[i] < array2[j]) {
					median = array1[i];
					i++;
				} else {
					median = array1[j];
					j++;
				}
			} else if (i < sizeOfArray1) {
				median = array1[i];
				i++;
			} else {
				median = array2[j];
				j++;
			}
		}
		return (arraySize % 2 == 0 ? (median + previousMedian) / 2 : median);
	}

	public static void main(String[] args) {
		int array1[] = { 4, 5 };
		int array2[] = { 12, 13, 15, 18 };
		System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is "
				+ getMedian(array1, array2));
	}
}
