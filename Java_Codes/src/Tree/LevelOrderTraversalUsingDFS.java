package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Tree.MyBinaryTree.Node;

public class LevelOrderTraversalUsingDFS {
	public static List<List<Integer>> levelOrderDFS(Node root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		levelHelper(res, root, 0);
		return res;
	}

	public static void levelHelper(List<List<Integer>> res, Node root, int height) {
		if (root == null)
			return;
		if (height >= res.size()) {
			res.add(new LinkedList<Integer>());
		}
		res.get(height).add(root.data);
		levelHelper(res, root.left, height + 1);
		levelHelper(res, root.right, height + 1);
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(100);
		input.add(50);
		input.add(200);
		input.add(25);
		input.add(75);
		input.add(350);
		MyBinaryTree tree = new MyBinaryTree(input);

		System.out.println("Binary Tree:");
		System.out.print("-----------------------------------------------------------------------------------------");
		tree.printTree();
		System.out.print("-----------------------------------------------------------------------------------------\n");
		System.out.println(levelOrderDFS(tree.root));
		System.out.print("\n-----------------------------------------------------------------------------------------");

	}

}
