package Arrays.TwoPointers;

import java.util.Arrays;

//https://www.educative.io/module/page/Z4JLg2tDQPVv6QjgO/10370001/5849282476507136/4688843308793856

public class FindMedianSortedArrays {

	public static double getMedian(int array1[], int array2[]) {
		int sizeOfArray1 = array1.length;
		int sizeOfArray2 = array2.length;
		int arraySize = sizeOfArray1 + sizeOfArray2;
		int arraySizeMid = arraySize / 2;

		int i = 0;
		int j = 0;

		double current = -1;
		double previous = -1;

		for (int k = 0; k <= arraySizeMid; k++) {
			previous = current;
			if (i < sizeOfArray1 && j < sizeOfArray2) {
				if (array1[i] < array2[j]) {
					current = array1[i];
					i++;
				} else {
					current = array2[j];
					j++;
				}
			} else if (i < sizeOfArray1) {
				current = array1[i];
				i++;
			} else {
				current = array2[j];
				j++;
			}
		}
		return (arraySize % 2 == 0 ? (current + previous) / 2 : current);
	}

	public static void main(String[] args) {
		int array1[] = { 4, 5 , 6};
		int array2[] = { 12, 13, 15, 18 };
		System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is "
				+ getMedian(array1, array2));
	}
}
