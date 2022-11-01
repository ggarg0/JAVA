package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BFSTraversalDisconnectedGraph {

	public static void BFSUtil(int vertex, MyGraph g, Map<Integer, Boolean> visited) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		visited.put(vertex, true);
		list.add(vertex);

		while (!list.isEmpty()) {
			vertex = list.poll();
			System.out.print(vertex + " ");

			if (g.map.containsKey(vertex)) {
				for (int v : g.map.get(vertex)) {
					if (!visited.get(v)) {
						visited.put(v, true);
						list.add(v);
					}
				}
			}
		}

	}

	public static void BFS(MyGraph g) {
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i : g.map.keySet())
			visited.put(i, false);

		for (int i : g.map.keySet()) {
			if (!visited.get(i)) {
				System.out.println("\nGraph\n======");
				BFSUtil(i, g, visited);
			}
		}
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
		System.out.println("BFS for disconnected graph ");
		BFS(g);
	}
}
