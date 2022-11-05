package Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {

	public static void topologicalSortUtil(int vertex, MyGraph g, Map<Integer, Boolean> visited, Stack<Integer> stack) {
		visited.put(vertex, true);
		if (g.map.containsKey(vertex)) {
			for (int v : g.map.get(vertex)) {
				System.out.println("Vertex " + v);
				if (!visited.get(v))
					topologicalSortUtil(v, g, visited, stack);
			}
		}
		stack.push(vertex);
	}

	public static void topologicalSort(MyGraph g) {
		Stack<Integer> stack = new Stack<Integer>();

		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i : g.map.keySet())
			visited.put(i, false);

		for (int i : g.map.keySet())
			if (!visited.get(i)) 
				topologicalSortUtil(i, g, visited, stack);

		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();

		g.addEdge(3, 2);
		  g.addEdge(3, 0);
		  g.addEdge(2, 0);
		  g.addEdge(2, 1);
		g.printGraph();
		System.out.println("TopologicalSort ");
		topologicalSort(g);

	}

}
