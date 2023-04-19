package Matrix;

public class RotateMatrix90Degree {

	// Transpose of matrix
	static void transpose(int mat[][]) {
		for (int i = 0; i < mat.length; i++)
			for (int j = i + 1; j < mat.length; j++) {
				int t = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = t;
			}
	}

	static void rotateAntiClockwise(int mat[][]) {
		transpose(mat);
		for (int i = 0; i < mat.length; i++) {
			int left = 0;
			int right = mat.length - 1;
			while (left < right) {
				int temp = mat[left][i];
				mat[left][i] = mat[right][i];
				mat[right][i] = temp;
				left++;
				right--;
			}
		}
	}

	static void rotateClockwise(int mat[][]) {
		transpose(mat);
		for (int i = 0; i < mat.length; i++) {
			int left = 0;
			int right = mat.length - 1;
			while (left < right) {
				int temp = mat[i][left];
				mat[i][left] = mat[i][right];
				mat[i][right] = temp;
				left++;
				right--;
			}
		}
	}

	static void printMatrix(String str, int mat[][]) {
		System.out.println(str + "Matrix\n===========================");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++)
				System.out.print(mat[i][j] + "	");
			System.out.println();
		}
		System.out.println("===========================\n");
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix("Before ", mat);

		rotateClockwise(mat);
		printMatrix("After rotateClockwise ", mat);

		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotateAntiClockwise(matrix);
		printMatrix("After rotateAntiClockwise ", matrix);
	}
}
