package Graph;

public class CloneGraph {

	public static MyGraph getClone(MyGraph g) {
		MyGraph copy = new MyGraph();
		for (int v = 0; v < g.getVertexCount(); v++) {
			for (int i : g.map.get(v)) 
				copy.addEdge(v, i);			
		}
		return copy;
	}
	
	public static void main(String[] args) {
		MyGraph g1 = new MyGraph();
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 0);
		g1.addEdge(2, 4);
		g1.addEdge(4, 2);
		g1.printGraph();
		System.out.println("Transpose of given Graph: ");
		getClone(g1).printGraph();

	}

}
