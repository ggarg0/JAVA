package Graph;

import java.util.LinkedList;
import java.util.List;

public class MyWeightedGraphWithList {

	static class Vertex {
		public int id;
		public boolean visited;

		public Vertex(int id, boolean visited) {
			this.id = id;
			this.visited = visited;
		}
	}

	static class Edge {
		int weight;
		boolean visited;
		Vertex source;
		Vertex destination;

		public Edge(int weight, boolean visited, Vertex source, Vertex destination) {
			this.weight = weight;
			this.visited = visited;
			this.source = source;
			this.destination = destination;
		}
	}

	public List<Vertex> vertexs = new LinkedList<>();
	public List<Edge> edges = new LinkedList<>();

	Vertex vertexExists(int id) {
		for (int i = 0; i < vertexs.size(); i++) {
			if (vertexs.get(i).id == id)
				return vertexs.get(i);

		}
		return null;
	}

	public void addEgde(int source, int destination, int weight) {
		Vertex src = vertexExists(source);
		Vertex dest = vertexExists(destination);

		if (src == null) {
			src = new Vertex(source, false);
			vertexs.add(src);
		}

		if (dest == null) {
			dest = new Vertex(destination, false);
			vertexs.add(dest);
		}

		edges.add(new Edge(weight, false, src, dest));
		//edges.add(new Edge(weight, false, dest, src));
	}

	int getTotalUndirectedCost() {
		int totalCost = 0;
		for (Edge edge : edges) {
			totalCost += edge.weight;
		}
		System.out.print("TotalCost : " + totalCost/2);
		return totalCost;
	}
	
	int getTotalDirectedCost() {
		int totalCost = 0;
		for (Edge edge : edges) {
			totalCost += edge.weight;
		}
		System.out.print("TotalCost : " + totalCost);
		return totalCost;
	}

	public void printGraph() {
		for (int i = 0; i < this.edges.size(); i++) {
			System.out.println("Edge : " + this.edges.get(i).source.id + "--(" + this.edges.get(i).weight + ")--"
					+ this.edges.get(i).destination.id);
		}
	}

	public static void main(String[] args) {
		MyWeightedGraphWithList graph = new MyWeightedGraphWithList();
		graph.addEgde(0, 1, 4);
		graph.addEgde(1, 3, 2);
		graph.addEgde(5, 2, 3);
		graph.addEgde(1, 2, 5);
		graph.addEgde(2, 3, 7);
		graph.addEgde(3, 4, 2);
		graph.printGraph();
		graph.getTotalDirectedCost();
	}
}
