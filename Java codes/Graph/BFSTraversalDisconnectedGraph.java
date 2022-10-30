package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BFSTraversalDisconnectedGraph {

	public static void BFSUtil(int v, MyGraph g, ArrayList<Boolean> visited) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited.set(v, true);

		while (!queue.isEmpty()) {
			int s = queue.poll();
			System.out.print(s + " ");

			if (g.map.containsKey(s)) {
				Iterator<Integer> i = g.map.get(s).listIterator();
				while (i.hasNext()) {
					int n = i.next();
					if (!visited.get(n)) {
						visited.set(n, true);
						queue.add(n);
					}
				}
			}
		}
	}

	public static void BFS(MyGraph g) {
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		for (int i = 0; i < g.getVertexCount(); i++)
			visited.add(i, false);

		for (int i = 0; i < g.getVertexCount(); i++) {
			if (!visited.get(i))
				BFSUtil(i, g, visited);
		}
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		boolean isDirected = true;
		g.addEdge(0, 1, isDirected);
		g.addEdge(0, 4, isDirected);
		g.addEdge(1, 2, isDirected);
		g.addEdge(4, 3, isDirected);
		g.printGraph();
		System.out.println("Following is Breadth First Traversal ");
		BFS(g);
	}
}
