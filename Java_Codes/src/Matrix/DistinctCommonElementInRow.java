package Matrix;

import java.util.HashMap;
import java.util.Map;

public class DistinctCommonElementInRow {

	static void distinct(int matrix[][], int N) {
	
		Map<Integer, Integer> ans = new HashMap<>();
		for (int j = 0; j < N; j++) {
			ans.put(matrix[0][j], 1);
		}

		// Traverse the matrix from 2nd row
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (ans.get(matrix[i][j]) != null && ans.get(matrix[i][j]) == i) {
					ans.put(matrix[i][j], i + 1);
					if (i == N - 1) {
						System.out.print(matrix[i][j] + " ");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 2, 1, 4, 3 }, { 1, 2, 3, 2 }, { 3, 6, 2, 3 }, { 5, 2, 5, 3 } };
		int n = 4;
		distinct(matrix, n);
	}
}

//Time Complexity: O(n2) 
//Space Complexity: O(n)