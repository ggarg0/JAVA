package Graph;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph {

	public Map<Integer, List<Integer>> map = new LinkedHashMap<>();

	public void addVertex(int vertex) {
		map.put(vertex, new LinkedList<Integer>());
	}

	public void addEdge(int source, int destination) {
		addEdge(source, destination, true);
	}

	public void addEdge(int source, int destination, boolean directed) {
		if (!map.containsKey(source))
			addVertex(source);

		if (!map.containsKey(destination))
			addVertex(destination);

		map.get(source).add(destination);
		if (!directed)
			map.get(destination).add(source);

	}

	public int getVertexCount() {
		return map.keySet().size();
	}

	public int getEdgesCount(boolean directed) {
		int count = 0;
		for (int v : map.keySet())
			count += map.get(v).size();

		if (directed)
			count = count / 2;

		return count;
	}

	public void hasVertex(int source) {
		System.out.println("Vertex found : " + map.containsKey(source));
	}

	public void hasEdge(int source, int destination) {
		System.out.println("Edge found : " + map.get(source).contains(destination) + " between " + source + " and "
				+ destination + ".");
	}

	public void printGraph() {
		for (int vertex : map.keySet()) {
			System.out.print("Vertex [" + vertex + "] : ");
			for (int w : map.get(vertex)) 
				System.out.print("|" + w + "| -> ");
			System.out.print("null\n");
		}
	}

	public static void main(String args[]) {

		MyGraph g = new MyGraph();
		boolean isDirected = true;
		g.addEdge(1, 2);
		g.addEdge(0, 5);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(5, 3);
		g.addEdge(5, 6);
		g.addEdge(3, 6);
		g.addEdge(6, 7);
		g.addEdge(6, 8);
		g.addEdge(6, 4);
		g.addEdge(7, 8);
		g.printGraph();
		System.out.println("The graph has " + g.getVertexCount() + " vertex.");
		System.out.println("The graph has " + g.getEdgesCount(isDirected) + " edges.");
		g.hasEdge(0, 7);
		g.hasVertex(5);
	}
}
