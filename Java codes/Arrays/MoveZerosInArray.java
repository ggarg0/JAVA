package Arrays;

import java.util.Arrays;

public class MoveZerosInArray {

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

	static void moveZerosToLeftSide(int[] arr) {
		int read = 0;
		int write = 0;
		int len = arr.length - 1;

		while (read <= len) {
			if (arr[read] == 0) {
				arr[read] = arr[write];
				arr[write] = 0;
				read++;
				write++;
			} else {
				read++;
			}
		}
	}

	static void moveZerosToRightSide(int[] arr) {
		int read = arr.length - 1;
		int write = arr.length - 1;

		while (read >= 0) {
			if (arr[read] == 0) {
				arr[read] = arr[write];
				arr[write] = 0;
				read--;
				write--;
			} else {
				read--;
			}
		}
	}

	static void moveZerosToRight(int[] arr) {
		int read = 0;
		int write = 0;
		while (read < arr.length) {
			if (arr[read] != 0) {
				arr[write] = arr[read];
				write++;
			}
			read++;
		}
		while (write < arr.length)
			arr[write++] = 0;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 10, 20, 0, 59, 63, 0, 88, 0 };
		System.out.println("Before move list:\t" + Arrays.toString(nums));
		moveZerosToLeft(nums);
		System.out.println("moveZerosToLeft:\t" + Arrays.toString(nums));
		moveZerosToRightSide(nums);
		System.out.println("moveZerosToRightSide:\t" + Arrays.toString(nums));
		moveZerosToLeftSide(nums);
		System.out.println("moveZerosToLeftSide:\t" + Arrays.toString(nums));
		moveZerosToRight(nums);
		System.out.println("moveZerosToRight:\t" + Arrays.toString(nums));
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
	}
}
