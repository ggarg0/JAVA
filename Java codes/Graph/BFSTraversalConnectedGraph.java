package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BFSTraversalConnectedGraph {

	public static void BFSUtil(int vertex, MyGraph g, Map<Integer, Boolean> visited) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		visited.put(vertex, true);
		list.add(vertex);

		while (!list.isEmpty()) {
			vertex = list.poll();
			if (g.map.containsKey(vertex)) {
				System.out.print(vertex + " ");
				for (int v : g.map.get(vertex)) {
					if (!visited.get(v)) {
						visited.put(v, true);
						list.add(v);
					}
				}
			}
		}
	}

	public static void BFS(int vertex, MyGraph g) {
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i : g.map.keySet())
			visited.put(i, false);

		if (!visited.isEmpty())
			BFSUtil(vertex, g, visited);
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();

		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(4, 6);
		g.addEdge(3, 5); // disconnected nodes
		g.addEdge(6, 7);
		g.printGraph();
		System.out.println("BFS for connected graph ");
		BFS(1, g);
	}
}
