package Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {

	public static void topologicalSortUtil(int vertex, MyGraph graph, Map<Integer, Boolean> visited, Stack<Integer> stack) {
		visited.put(vertex, true);
		for (int v : graph.map.get(vertex)) {
			if (!visited.get(v))
				topologicalSortUtil(v, graph, visited, stack);
		}
		stack.push(vertex);
	}

	public static void topologicalSort(MyGraph graph) {
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i : graph.map.keySet())
			visited.put(i, false);

		for (int i : graph.map.keySet())
			if (!visited.get(i))
				topologicalSortUtil(i, graph, visited, stack);

		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		g.addEdge(4, 2);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.printGraph();
		System.out.println("TopologicalSort ");
		topologicalSort(g);
		/*

		MyGraph g1 = new MyGraph();
		g1.addEdge(3, 2);
		g1.addEdge(3, 0);
		g1.addEdge(2, 0);
		g1.addEdge(2, 1);
		
		g1.printGraph();
		System.out.println("TopologicalSort ");
		topologicalSort(g1);
	*/}

}
