package Graph;

import java.util.HashMap;
import java.util.Map;

public class DetectCycleUndirectedGraph {

	private static boolean isCyclicUtil(int vertex, MyGraph g, Map<Integer, Boolean> visited, int parent) {
		visited.put(vertex, true);
		for (int v : g.map.get(vertex)) {
			if (!visited.get(v)) {
				if (isCyclicUtil(v, g, visited, vertex))
					return true;
			} else if (v != parent)
				return true;
		}
		return false;
	}

	private static boolean isCyclic(MyGraph g) {
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i : g.map.keySet())
			visited.put(i, false);

		for (int v : g.map.keySet()) {
			if (!visited.get(v))
				if (isCyclicUtil(v, g, visited, -1))
					return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		System.out.println("Graph contains cycle : " + isCyclic(g));

		MyGraph g2 = new MyGraph();
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		System.out.println("Graph contains cycle : " + isCyclic(g2));
	}
}
