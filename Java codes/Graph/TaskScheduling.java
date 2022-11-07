package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskScheduling {
	public static void isSchedulingPossible(int[][] prerequisites) {
		List<Integer> sortedOrder = new ArrayList<>();
		boolean result = false;
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

		result = sortedOrder.size() == graph.size();
		System.out.println("is Scheduling Possible : " + result + " and order : " + sortedOrder);
	}

	public static void main(String[] args) {
		isSchedulingPossible(new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
		isSchedulingPossible(new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
		isSchedulingPossible(new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
				new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
	}
}
