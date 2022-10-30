package Graph;

import java.util.Iterator;

public class DFSTraversalGraph {

	public static void DFSUtil(int s, MyGraph g, boolean visited[]) {
		visited[s] = true;
		System.out.print(s + " ");

		if (g.map.containsKey(s)) {
			Iterator<Integer> i = g.map.get(s).listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					DFSUtil(n, g, visited);
				}
			}
		}
	}

	public static void DFS(MyGraph g) {
		boolean visited[] = new boolean[g.getVertexCount()];

		for (int i = 0; i < g.getVertexCount(); ++i)
			if (visited[i] == false)
				DFSUtil(i, g, visited);

	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addEdge(1, 0);
		g.addEdge(3, 1);
		g.addEdge(2, 7);
		g.addEdge(2, 4);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(6, 5);
		g.printGraph();
		System.out.println("Following is Depth First Traversal ");
		DFS(g);

	}

}
