package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NodeCountAtLevels {
	public static int numberOfNodesInGivenLevel(MyGraph g, int vertex, int l) {

		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		Map<Integer, Integer> level = new HashMap<Integer, Integer>();

		for (int i : g.map.keySet()) {
			level.put(i, 0);
			visited.put(i, false);
		}

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);

		level.put(vertex, 0);
		visited.put(vertex, true);
		int count = 0;

		while (!queue.isEmpty()) {
			vertex = queue.poll();

			for (int v : g.map.get(vertex)) {
				if (!visited.get(v)) {
					level.put(v, level.get(vertex) + 1);
					visited.put(v, true);
					queue.add(v);
				}
			}
		}

		for (int v : level.keySet()) {
			if (level.get(v) == l)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
		g.addEdge(2, 4);

		for (int v : g.map.keySet())
			System.out.println("Nodes at level " + v + " : [" + numberOfNodesInGivenLevel(g, 0, v) + "]");
	}
}
