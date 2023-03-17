package Matrix;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SortMatrix {

	static void sortMat(int mat[][], int n) {
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				set.add(mat[i][j]);

		Iterator<Integer> ite = set.iterator();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				mat[i][j] = ite.next();
	}

	static void printMat(int mat[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		int mat[][] = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
		int n = 3;

		System.out.println("Original Matrix:");
		printMat(mat, n);

		sortMat(mat, n);

		System.out.println("Matrix After Sorting:");
		printMat(mat, n);

	}

}
