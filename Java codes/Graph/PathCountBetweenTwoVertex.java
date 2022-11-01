package Graph;

public class PathCountBetweenTwoVertex {

	public static int countPathsUtil(int s, int d, MyGraph g, int pathCount) {
		if (s == d) {
			pathCount++;
		} else {
			for (int v: g.map.get(s))
				pathCount = countPathsUtil(v, d, g, pathCount);
		}
		return pathCount;
	}

	public static int countPaths(int s, int d, MyGraph g) {
		return countPathsUtil(s, d, g, 0);
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		boolean isDirected = true;
		g.addEdge(0, 1, isDirected);
		g.addEdge(0, 2, isDirected);
		g.addEdge(0, 3, isDirected);
		g.addEdge(1, 3, isDirected);
		g.addEdge(2, 3, isDirected);
		g.addEdge(1, 4, isDirected);
		g.addEdge(2, 4, isDirected);
		g.printGraph();
		System.out.println("No of paths : " + countPaths(0, 6, g));

		MyGraph g2 = new MyGraph();
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(0, 2);
		g2.printGraph();
        System.out.println("Path exists: " + countPaths(0, 2, g2));
	}
}
