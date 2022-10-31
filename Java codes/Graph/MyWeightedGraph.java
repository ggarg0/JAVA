package Graph;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyWeightedGraph {

	static class Edge {
		int destination;
		int weight;

		public Edge(int destination, int weight) {
			this.destination = destination;
			this.weight = weight;
		}
	}

	public Map<Integer, List<Edge>> map = new LinkedHashMap<>();

	public void addVertex(int vertex) {
		map.put(vertex, new LinkedList<Edge>());
	}

	public void addEgde(int source, int destination, int weight) {
		if (!map.containsKey(source))
			addVertex(source);

		if (!map.containsKey(destination))
			addVertex(destination);

		map.get(source).add(new Edge(destination, weight));
		//map.get(destination).add(new Edge(source, weight));
	}

	public void printGraph() {
		for (int vertex : map.keySet()) {
			System.out.println("Vertex [" + vertex + "]");
			for (Edge w : map.get(vertex)) {
				System.out.println("connected to vertex [" + w.destination + "] with weight [" + w.weight + "]");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		MyWeightedGraph graph = new MyWeightedGraph();
		graph.addEgde(0, 1, 4);
		graph.addEgde(5, 2, 3);
		graph.addEgde(1, 3, 2);
		graph.addEgde(1, 2, 5);
		graph.addEgde(2, 3, 7);
		graph.addEgde(3, 4, 2);
		graph.addEgde(4, 0, 4);
		graph.addEgde(4, 1, 4);
		graph.addEgde(4, 5, 6);
		graph.addVertex(7);
		graph.printGraph();
	}
}
