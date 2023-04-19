package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TaskSchedulingAll {
	public static void taskScheduling(int[][] prerequisites) {
		List<Integer> sortedOrder = new ArrayList<>();

		if (prerequisites.length <= 0) {
			System.out.println("Scheduling possible not possible");
			return;
		}

		HashMap<Integer, Integer> inDegree = new HashMap<>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < prerequisites.length; i++) {
			if (!inDegree.containsKey(prerequisites[i][0]))
				inDegree.put(prerequisites[i][0], 0);

			if (!inDegree.containsKey(prerequisites[i][1]))
				inDegree.put(prerequisites[i][1], 0);

			if (!graph.containsKey(prerequisites[i][0]))
				graph.put(prerequisites[i][0], new ArrayList<Integer>());

			if (!graph.containsKey(prerequisites[i][1]))
				graph.put(prerequisites[i][1], new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int parent = prerequisites[i][0], child = prerequisites[i][1];
			graph.get(parent).add(child);
			inDegree.put(child, inDegree.get(child) + 1);
		}

		List<Integer> sources = new LinkedList<>();
		for (int key : inDegree.keySet()) {
			if (inDegree.get(key) == 0)
				sources.add(key);
		}
		printAllTopologicalSorts(graph, inDegree, sources, sortedOrder);
	}

	private static void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graph,
			HashMap<Integer, Integer> inDegree, List<Integer> sources, List<Integer> sortedOrder) {
		if (!sources.isEmpty()) {
			for (Integer vertex : sources) {
				sortedOrder.add(vertex);
				List<Integer> sourcesForNextCall = new LinkedList<>(sources);
				sourcesForNextCall.remove(vertex);
				List<Integer> children = graph.get(vertex); 
				for (int child : children) {
					inDegree.put(child, inDegree.get(child) - 1);
					if (inDegree.get(child) == 0)
						sourcesForNextCall.add(child); 
				}

				printAllTopologicalSorts(graph, inDegree, sourcesForNextCall, sortedOrder);
				sortedOrder.remove(vertex);
				for (int child : children)
					inDegree.put(child, inDegree.get(child) + 1);
			}
		}

		if (sortedOrder.size() == inDegree.size())
			System.out.println(sortedOrder);
	}

	public static void main(String[] args) {
		taskScheduling(new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
	}
}
