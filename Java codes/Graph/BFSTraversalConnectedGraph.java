package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSTraversalConnectedGraph {

	public static void BFS(int s, MyGraph g) {
		boolean visited[] = new boolean[g.getVertexCount()];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			if (g.map.containsKey(s)) {
				Iterator<Integer> i = g.map.get(s).listIterator();
				while (i.hasNext()) {
					int n = i.next();
					if (!visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.printGraph();
		System.out.println("Following is Breadth First Traversal ");
		BFS(3, g);
	}
}
