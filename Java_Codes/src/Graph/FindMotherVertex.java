package Graph;

import java.util.HashMap;
import java.util.Map;

public class FindMotherVertex {

	public static int findMotherVertex(MyGraph g) {
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int vertex : g.map.keySet())
			visited.put(vertex, false);

		int lastV = 0;
		for (int vertex : g.map.keySet()) {
			if (!visited.get(vertex)) {
				DFSTraversal(vertex, g, visited);
				lastV = vertex;
			}
		}

		for (int vertex : g.map.keySet())
			visited.put(vertex, false);

		DFSTraversal(lastV, g, visited);

		for (int i : visited.keySet()) {
			if (!visited.get(i)) {
				return -1;
			}
		}

		return lastV;
	}

	public static void DFSTraversal(int vertex, MyGraph g, Map<Integer, Boolean> visited) {
		visited.put(vertex, true);
		if (g.map.containsKey(vertex)) {
			for (int v : g.map.get(vertex)) {
				if (!visited.get(v))
					DFSTraversal(v, g, visited);
			}
		}
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(3, 0);
		g.addEdge(3, 1);
		g.printGraph();
		System.out.println("Mother Vertex is: " + findMotherVertex(g));
	}
}
