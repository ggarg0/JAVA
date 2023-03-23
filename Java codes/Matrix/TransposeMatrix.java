package Matrix;

public class TransposeMatrix {
	static int len = 0;
	static void printMatrix(int arr[][]) {
		System.out.println("Matrix\n===========================");
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++)
				System.out.print(arr[i][j] + "	");
			System.out.println();
		}
		System.out.println("===========================\n");
	}

	static void transpose(int mat[][]) {
		// Transpose of matrix
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
	}

	// Driver code
	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		len = mat.length;
		printMatrix(mat);
		transpose(mat);
		printMatrix(mat);
	}
}
