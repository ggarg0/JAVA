package Graph;

public class BipartiteGraph {
	public static boolean isBipartite(MyGraph g, int source, boolean visited[], boolean color[]) {

		for (int u : g.map.get(source)) {
			if (visited[u] == false) {
				visited[u] = true;
				color[u] = !color[source];
				if (!isBipartite(g, u, visited, color))
					return false;
			} else if (color[source] == color[u]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		boolean isDirected = false;
		MyGraph g = new MyGraph();
		g.addEdge(1, 2, isDirected);
		g.addEdge(2, 3, isDirected);
		g.addEdge(3, 4, isDirected);
		g.addEdge(4, 5, isDirected);
		g.addEdge(5, 6, isDirected);
		g.addEdge(6, 1, isDirected);

		MyGraph g2 = new MyGraph();
		g2.addEdge(3, 2, isDirected);
		g2.addEdge(1, 4, isDirected);
		g2.addEdge(2, 1, isDirected);
		g2.addEdge(5, 3, isDirected);
		g2.addEdge(6, 2, isDirected);
		g2.addEdge(3, 1, isDirected);

		boolean[] discovered = new boolean[8];
		boolean[] color = new boolean[8];
		discovered[1] = true;
		color[1] = false;

		System.out.println("Graph1 is bipartite: " + isBipartite(g, 1, discovered, color));
		System.out.println("Graph2 is bipartite: " + isBipartite(g2, 1, discovered, color));
	}
}
