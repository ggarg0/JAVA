package Graph;

import java.util.HashMap;
import java.util.Map;

public class StronglyConnectedGraph {

	public static void markVisitedNode(MyGraph g, int vertex, Map<Integer, Boolean> visited) {
		visited.put(vertex, true);
		if (g.map.containsKey(vertex)) {
			for (int v : g.map.get(vertex)) {
				if (!visited.get(v)) {
					markVisitedNode(g, v, visited);
				}
			}
		}
	}

	public static Object isStronglyConnected(int vertex, MyGraph g) {
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

		for (int i : g.map.keySet())
			visited.put(i, false);

		markVisitedNode(g, vertex, visited);

		if (visited.containsValue(false))
			return false;

		MyGraph g1 = g.getTranspose(g);

		for (int i : g.map.keySet())
			visited.put(i, false);

		markVisitedNode(g1, vertex, visited);

		if (visited.containsValue(false))
			return false;

		return true;
	}

	public static void main(String[] args) {

		MyGraph g = new MyGraph();
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		System.out.println("Graph g is strongly connected? " + isStronglyConnected(0, g));

		MyGraph g1 = new MyGraph();
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 0);
		g1.addEdge(2, 4);
		g1.addEdge(4, 2);
		System.out.println("Graph g1 is strongly connected? " + isStronglyConnected(0, g1));

		MyGraph g2 = new MyGraph();
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		System.out.println("Graph g2 is strongly connected? " + isStronglyConnected(0, g2));
	}
}
