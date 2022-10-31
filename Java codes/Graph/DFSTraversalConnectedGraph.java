package Graph;

import java.util.HashMap;
import java.util.Map;

public class DFSTraversalConnectedGraph {

	public static void DFSUtil(int vertex, MyGraph g, Map<Integer, Boolean> visited) {
		visited.put(vertex, true);		
		if (g.map.containsKey(vertex)) {
			System.out.print(vertex + " ");
			for (int v : g.map.get(vertex)) {
				if (!visited.get(v))
					DFSUtil(v, g, visited);
			}
		}
	}

	public static void DFS(int vertex, MyGraph g) {
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i : g.map.keySet())
			visited.put(i, false);

		if (!visited.isEmpty())
			DFSUtil(vertex, g, visited);
	}

	public static void main(String[] args) {
		MyGraph g1 = new MyGraph();

		g1.addEdge(0, 1);
		g1.addEdge(0, 4);
		g1.addEdge(1, 2);
		g1.addEdge(4, 6);
		g1.addEdge(3, 5); // disconnected nodes
		g1.addEdge(6, 9);

		g1.printGraph();
		System.out.println("Following is Depth First Traversal ");
		DFS(0, g1);
	}

}
