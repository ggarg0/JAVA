package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort2 {

	public static List<Integer> topologicalSort(int[][] edges) {
		List<Integer> sortedOrder = new LinkedList<>();
		if (edges.length <= 0)
			return sortedOrder;

		HashMap<Integer, Integer> inDegree = new HashMap<>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < edges.length; i++) {
			if (!inDegree.containsKey(edges[i][0]))
				inDegree.put(edges[i][0], 0);

			if (!inDegree.containsKey(edges[i][1]))
				inDegree.put(edges[i][1], 0);

			if (!graph.containsKey(edges[i][0]))
				graph.put(edges[i][0], new LinkedList<Integer>());

			if (!graph.containsKey(edges[i][1]))
				graph.put(edges[i][1], new LinkedList<Integer>());
		}

		for (int i = 0; i < graph.size(); i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			graph.get(parent).add(child);
			inDegree.put(child, inDegree.get(child) + 1);
		}

		Queue<Integer> sources = new LinkedList<>();
		for (int key : inDegree.keySet()) {
			if (inDegree.get(key) == 0)
				sources.add(key);
		}

		while (!sources.isEmpty()) {
			int vertex = sources.poll();
			sortedOrder.add(vertex);
			List<Integer> children = graph.get(vertex);
			for (int child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if (inDegree.get(child) == 0)
					sources.add(child);
			}
		}

		if (sortedOrder.size() != graph.size())
			return new ArrayList<>();

		return sortedOrder;
	}

	public static void main(String[] args) {
		System.out.println(topologicalSort(
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } }));

		System.out.println(topologicalSort(new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } }));

	}
}
