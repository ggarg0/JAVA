package Arrays;

import java.util.Arrays;

public class SortedArraySquares {

	public static int[] makeSquares(int[] arr) {
		int[] squares = new int[arr.length];
		int left = 0;
		int right = arr.length - 1;
		int highestSquareIdx = arr.length - 1;

		while (left <= right) {
			int leftSquare = arr[left] * arr[left];
			int rightSquare = arr[right] * arr[right];
			if (leftSquare > rightSquare) {
				squares[highestSquareIdx--] = leftSquare;
				left++;
			} else {
				squares[highestSquareIdx--] = rightSquare;
				right--;
			}
		}
		return squares;
	}

	public static void main(String[] args) {
		int[] arr = { -4, -1, 0, 3, 10 };
		System.out.println(Arrays.toString(makeSquares(arr)));

	}

}
