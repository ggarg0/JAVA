package Matrix;

public class MaximumElementInRow {

	static void printMatrix(String str, int[][] mat) {
		System.out.println(str + "Matrix\n===========================");
		for (int[] ints : mat) {
			for (int j = 0; j < mat.length; j++)
				System.out.print(ints[j] + "	");
			System.out.println();
		}
		System.out.println("===========================\n");
	}

	public static void maxelement(int no_of_rows, int[][] mat) {
		int i = 0;
		int max = 0;
		while (i < no_of_rows) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] > max) {
					max = mat[i][j];
				}
			}
			System.out.println("Max element in row " + i + " is " + max);
			max = 0;
			i++;
		}
	}

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 3, 4, 11, 8 }, { 1, 4, 9, 11 }, { 76, 34, 21, 1 }, { 2, 1, 4, 5 } };
		printMatrix("Before ", mat);
		maxelement(4, mat);
	}
}
