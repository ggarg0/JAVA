package Matrix;

public class TraverseMatrixUsingRecursion {

	private static int N = 0;
	private static int M = 0;

	private static void traverse(int[][] arr, int i, int j) {

		if (i == N - 1 && j == M - 1) {
			System.out.println(arr[i][j]);
			return;
		}

		System.out.print(arr[i][j] + ", ");

		if (j < M - 1)
			traverse(arr, i, j + 1);
		else
			traverse(arr, i + 1, 0);

	}

	public static void main(String[] args) {

		int[][] arr = { { 4, 5, 6 }, { 1, 2, 3 }, { 7, 8, 9 } };
		N = arr.length;
		M = arr[0].length;

		traverse(arr, 0, 0);
	}
}
