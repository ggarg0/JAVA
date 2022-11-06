package Graph;

import Graph.MyWeightedGraphWithList.Edge;
import Graph.MyWeightedGraphWithList.Vertex;

public class MinimumSpanningTree {

	public static MyWeightedGraphWithList findMinSpanningTree(MyWeightedGraphWithList graph) {
		MyWeightedGraphWithList mst = new MyWeightedGraphWithList();
		int vertexCount = 0;

		Vertex current = graph.vertexs.get(0);
		current.visited = true;
		vertexCount++;

		while (vertexCount < graph.vertexs.size()) {
			Edge smallest = null;
			for (int i = 0; i < graph.edges.size(); i++) {
				if (graph.edges.get(i).visited == false) {
					if (graph.edges.get(i).src.visited == true && graph.edges.get(i).dest.visited == false) {
						if (smallest == null || graph.edges.get(i).weight < smallest.weight) {
							smallest = graph.edges.get(i);
						}
					}
				}
			}
			vertexCount++;

			if (smallest != null) {
				smallest.visited = true;
				smallest.dest.visited = true;
				mst.edges.add(new Edge(smallest.weight, smallest.visited, smallest.src, smallest.dest));
			}
		}
		return mst;
	}

	public static void main(String[] args) {
		MyWeightedGraphWithList graph = new MyWeightedGraphWithList();
		graph.addEgde(1, 2, 2);
		graph.addEgde(1, 3, 1);
		graph.addEgde(1, 4, 2);
		graph.addEgde(2, 4, 3);
		graph.addEgde(3, 5, 2);
		graph.addEgde(3, 4, 1);
		graph.addEgde(5, 6, 1);
		graph.addEgde(5, 7, 2);
		graph.addEgde(4, 7, 2);
		graph.printGraph();
		graph.getTotalCost();

		System.out.println();
		MyWeightedGraphWithList mst = findMinSpanningTree(graph);
		mst.printGraph();
		mst.getTotalCostForMST();
	}

}
