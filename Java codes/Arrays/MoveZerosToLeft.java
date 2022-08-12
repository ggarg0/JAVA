package Arrays;

import java.util.Arrays;

public class MoveZerosToLeft {

	static void moveZerosToLeft(int[] arr) {
		int read = arr.length - 1;
		int write = arr.length - 1;

		while (read >= 0) {

			if (arr[read] != 0) {
				arr[write] = arr[read];
				write--;
			}
			read--;
		}

		while (write >= 0) {
			arr[write] = 0;
			write--;
		}

	}

	public static void main(String[] args) {
		int[][] numsList = {{1, 10, 20, 0, 59, 63, 0, 88, 0}, {1, 0, 2, 3, 0}, {0},
				{-1, 0, 0, -2, 9}, {1, 2, 3, 4, 5}, {2}};

		for (int i = 0; i < numsList.length; i++) {
			System.out.println((i + 1) + ". Before list:\t" + Arrays.toString(numsList[i]));
			moveZerosToLeft(numsList[i]);
			System.out.println("   After list:\t" + Arrays.toString(numsList[i]));
			System.out.println(
					"----------------------------------------------------------------------------------------------------\n");
		}
	}

}
