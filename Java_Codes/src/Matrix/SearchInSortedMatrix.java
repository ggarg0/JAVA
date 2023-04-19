package Matrix;

public class SearchInSortedMatrix {

	public static boolean findKey(int[][] matrix, int target) {
		int start = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int end = (rows * cols) - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			int row = mid / cols;
			int col = mid % cols;

			if (matrix[row][col] < target) {
				start = mid + 1;
			} else if (matrix[row][col] > target) {
				end = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.out.println("Search for 1 returned: " + findKey(matrix, 1));
		System.out.println("Search for 15 returned: " + findKey(matrix, 18));
	}
}
