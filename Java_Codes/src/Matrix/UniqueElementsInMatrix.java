package Matrix;

import java.util.HashMap;
import java.util.Map;

public class UniqueElementsInMatrix {

	public static void unique(int mat[][]) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (map.containsKey(mat[i][j])) {
					map.put(mat[i][j], 1 + map.get(mat[i][j]));
				} else {
					map.put(mat[i][j], 1);
				}
			}
		}

		int flag = 0;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == 1) {
				System.out.print(e.getKey() + " ");
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("No unique element in the matrix");
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 20 }, { 5, 6, 20, 25 }, { 1, 3, 5, 6 }, { 6, 7, 8, 15 } };
		unique(mat);
	}
}
