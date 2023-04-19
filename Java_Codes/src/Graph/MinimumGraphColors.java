package Graph;

import java.util.Arrays;

public class MinimumGraphColors {

	public static void greedyColoring(MyGraph g) {
		int numofVertices = g.getVertexCount();
		int[] result = new int[g.getVertexCount()];
		Arrays.fill(result, -1);
		result[0] = 0;

		boolean[] available = new boolean[numofVertices];
		Arrays.fill(available, true);

		for (int i = 1; i < numofVertices; i++) {
			for (int v : g.map.get(i)) {
				if (result[v] != -1) {
					available[result[v]] = false;
				}
			}
			int j;
			for (j = 0; j < numofVertices; j++) {
				if (available[j]) {
					break;
				}
			}

			result[i] = j;
			Arrays.fill(available, true);
		}

		for (int i = 0; i < numofVertices; i++) {
			System.out.println("Vertex: " + i + " , " + "Color: " + result[i]);
		}
	}

	public static void main(String[] args) {
		MyGraph g1 = new MyGraph();
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);

		greedyColoring(g1);
		System.out.println();
	}
}
