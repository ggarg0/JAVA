package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort2 {

	public static List<Integer> topologicalSort(int vertices, int[][] edges) {
		List<Integer> sortedOrder = new ArrayList<>();
		if (vertices <= 0)
			return sortedOrder;

		HashMap<Integer, Integer> inDegree = new HashMap<>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		
		for (int i = 0; i < vertices; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			graph.get(parent).add(child);
			inDegree.put(child, inDegree.get(child) + 1);
		}

		Queue<Integer> sources = new LinkedList<>();
		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0)
				sources.add(entry.getKey());
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

		if (sortedOrder.size() != vertices)
			return new ArrayList<>();

		return sortedOrder;
	}

	public static void main(String[] args) {
		List<Integer> result = topologicalSort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

	}
}
