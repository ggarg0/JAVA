package Matrix;

public class TransposeMatrix {

	static void printMatrix(String str, int mat[][]) {
		System.out.println(str + "Matrix\n===========================");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++)
				System.out.print(mat[i][j] + "	");
			System.out.println();
		}
		System.out.println("===========================\n");
	}

	public static void transpose(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = i + 1; j < mat.length; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
	}

	// Driver code
	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix("Before Transpose ", mat);
		transpose(mat);
		printMatrix("After Transpose ", mat);
	}
}
