package Graph;

import java.util.HashMap;
import java.util.Map;

public class DetectCycleDirectedGraph {

	private static boolean isCyclicUtil(int vertex, MyGraph g, Map<Integer, Boolean> visited,
			Map<Integer, Boolean> recStack) {
		if (recStack.get(vertex))
			return true;

		if (visited.get(vertex))
			return false;

		visited.put(vertex, true);
		recStack.put(vertex, true);

		for (int v : g.map.get(vertex)) {
			if (isCyclicUtil(v, g, visited, recStack))
				return true;
		}

		recStack.put(vertex, false);
		return false;
	}

	private static boolean isCyclic(MyGraph g) {

		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		Map<Integer, Boolean> recStack = new HashMap<Integer, Boolean>();
		for (int i : g.map.keySet()) {
			visited.put(i, false);
			recStack.put(i, false);
		}

		for (int i : g.map.keySet()) {
			if (isCyclicUtil(i, g, visited, recStack))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyGraph graph = new MyGraph();
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
	//	graph.addEdge(2, 0);
		graph.addEdge(2, 3);
	//	graph.addEdge(3, 3);
		graph.printGraph();
		System.out.println("Graph contains cycle : " + isCyclic(graph));
	}
}