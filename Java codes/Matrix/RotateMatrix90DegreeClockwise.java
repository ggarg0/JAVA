package Matrix;

public class RotateMatrix90DegreeClockwise {
	static int len = 0;
	static int height = 0;

	static void rotate90Clockwise(int mat[][]) {
		 // Transpose of matrix
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        printMatrix("After Transpose ", mat);
        // Reverse individual rows
        for (int i = 0; i < len; i++) {
            int low = 0, high = len - 1;
            while (low < high) {
                int t = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = t;
                low++;
                high--;
            }
        }
	}
	
	static void printMatrix(String str, int arr[][]) {
		System.out.println(str + "Matrix\n===========================");
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < height; j++)
				System.out.print(arr[i][j] + "	");
			System.out.println();
		}
		System.out.println("===========================\n");
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		len = arr.length;
		height = arr[0].length;
		printMatrix("Before ", arr);
		rotate90Clockwise(arr);
		printMatrix("After RotateMatrix90Degree ",arr);
	}
}
