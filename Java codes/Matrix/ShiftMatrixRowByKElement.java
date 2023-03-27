package Matrix;

public class ShiftMatrixRowByKElement {
	static void printMatrix(String str, int mat[][]) {
		System.out.println(str + "Matrix\n===========================");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++)
				System.out.print(mat[i][j] + "	");
			System.out.println();
		}
		System.out.println("===========================\n");
	}
	
	static void shiftMatrixByK(int[][] mat, int k) {
		if (k > mat.length) {
			System.out.print("Shifting is" + " not possible");
			return;
		}

		int j = 0;
		while (j < mat.length) {
			for (int i = k; i < mat.length; i++)
				System.out.print(mat[j][i] + "	");

			for (int i = 0; i < k; i++)
				System.out.print(mat[j][i] + "	");

			System.out.println();
			j++;
		}
	}

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix("", mat);
		shiftMatrixByK(mat, 2);
	}
}
