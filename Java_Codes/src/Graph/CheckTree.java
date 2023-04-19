package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CheckTree {

	public static boolean isTree(MyGraph g) {
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();		
		int root = Integer.MIN_VALUE;
		
		for (int vertex : g.map.keySet()) {
			if (root == Integer.MIN_VALUE)
				root = vertex;
			visited.put(vertex, false);
		}		
	
		LinkedList<Integer> list = new LinkedList<Integer>();
		visited.put(root, true);
		list.add(root);
		int numberOfVisited = 1;

		while (!list.isEmpty()) {
			int vertex = list.poll();
			if (g.map.containsKey(vertex)) {
				for (int v : g.map.get(vertex)) {
					if (!visited.get(v)) {
						visited.put(v, true);
						list.add(v);
						numberOfVisited++;
					} else
						return false;
				}
			}
		}

		if (numberOfVisited == g.getVertexCount())
			return true;

		return false;
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.printGraph();
		System.out.println("isTree : " + isTree(g));

		MyGraph g2 = new MyGraph();
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(0, 3);
		g2.addEdge(3, 2);
		g2.printGraph();
		System.out.println("isTree : " + isTree(g2));

		MyGraph g3 = new MyGraph();
		g3.addEdge(0, 1);
		g3.addEdge(0, 2);
		g3.addEdge(0, 3);
		g3.addEdge(4, 5);
		g3.printGraph();
		System.out.println("isTree : " + isTree(g3));

	}

}
