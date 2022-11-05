package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FindShortestPath {

	public static int findPath(MyGraph g, int source, int destination) {
		if (source == destination) {
			return 0;
		}

		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		Map<Integer, Integer> distance = new HashMap<Integer, Integer>();
		for (int i : g.map.keySet()) {
			visited.put(i, false);
			distance.put(i, 0);
		}

		LinkedList<Integer> list = new LinkedList<Integer>();
		visited.put(source, true);
		list.add(source);

		while (!list.isEmpty()) {
			int vertex = list.poll();

			for (int v : g.map.get(vertex)) {
				if (!visited.get(v)) {
					visited.put(v, true);
					list.add(v);
					distance.put(v, distance.get(vertex) + 1);

				}
				if (v == destination) {
					return distance.get(destination);
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(1, 4);
		int source = 0;
		int destination = 2;
		System.out.println(
				"Shortest path between " + source + " and " + destination + " : " + findPath(g, source, destination));

	}

}
