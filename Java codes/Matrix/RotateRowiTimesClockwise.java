package Matrix;

public class RotateRowiTimesClockwise {
	static void printMatrix(String str, int mat[][]) {
		System.out.println(str + "Matrix\n===========================");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++)
				System.out.print(mat[i][j] + "	");
			System.out.println();
		}
		System.out.println("===========================\n");
	}

	static void reverse(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	static void rotateMatrix(int mat[][]) {
		int i = 0;
		for (int rows[] : mat) {
			reverse(rows, 0, rows.length - 1);
			reverse(rows, 0, i - 1);
			reverse(rows, i, rows.length - 1);
			i++;
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printMatrix("Before ", mat);
		rotateMatrix(mat);
		printMatrix("After ", mat);
	}
}
