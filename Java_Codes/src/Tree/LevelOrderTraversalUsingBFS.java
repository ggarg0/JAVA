package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Tree.MyBinaryTree.Node;

public class LevelOrderTraversalUsingBFS {

	public static List<List<Integer>> levelOrderBFS(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		} else {
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.add(root);
			while (queue.size() > 0) {
				List<Integer> level = new ArrayList<>();
				int levelNumber = queue.size();

				for (int i = 0; i < levelNumber; i++) {
					Node node = queue.poll();
					level.add(node.data);

					if (node.left != null)
						queue.add(node.left);

					if (node.right != null)
						queue.add(node.right);

				}
				result.add(level);
			}
		}
		return result;
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
		System.out.println(levelOrderBFS(tree.root));
		System.out.print("\n-----------------------------------------------------------------------------------------");
	}
}
