package Graph;

import java.util.HashMap;
import java.util.Map;

public class RemoveEdgeAndCheckForDisconnectedGraph {

	public static void DFSTraversal(MyGraph g, int vertex, Map<Integer, Boolean> visited) {
		visited.put(vertex, true);
		for (int v : g.map.get(vertex)) {
			if (!visited.get(v))
				DFSTraversal(g, v, visited);
		}
	}

	public static boolean isConnected(MyGraph g, int source, int destination) {

		g.map.get(source).remove(new Integer(destination));
		g.map.get(destination).remove(new Integer(source));
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

		int vertex = Integer.MIN_VALUE;
		for (int v : g.map.keySet()) {
			if (vertex == Integer.MIN_VALUE)
				vertex = v;
			visited.put(v, false);
		}

		DFSTraversal(g, vertex, visited);

		for (int i : g.map.keySet())
			if (!visited.get(i))
				return false;

		return true;
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		boolean isDirected = false;
		g.addEdge(0, 1, isDirected);
		g.addEdge(1, 2, isDirected);
		g.addEdge(2, 3, isDirected);
		g.addEdge(3, 4, isDirected);
		g.addEdge(0, 4, isDirected);
		g.printGraph();
		// remove edge 3 -> 4
		System.out.println("Is graph connected after deletion of edge 3 -> 4? " + isConnected(g, 3, 4));

		// remove edge 1 -> 2
		System.out.println("Is graph connected after deletion of edge 1 -> 2? " + isConnected(g, 1, 2));
	}
}
