package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Tree.MyBinaryTree.Node;

public class LevelOrderTraversal {

	public static void levelOrderTraversal(Node root) {

		if (root == null) {
			System.out.print("null");
		} else {
			Queue<Node> queue = new ArrayDeque<Node>();
			Node dummy = new Node(1);
			queue.add(root);
			queue.add(dummy);

			while (!queue.isEmpty()) {
				Node temp = queue.poll();
				System.out.print(temp.data);

				if (temp.left != null) 
					queue.add(temp.left);
				
				if (temp.right != null) 
					queue.add(temp.right);
			
				if (queue.peek() == dummy) {
					queue.remove();
					if (!queue.isEmpty()) {
						System.out.print(" : ");
						queue.add(dummy);
					}
				} else {
					System.out.print(", ");
				}
			}
		}
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
		levelOrderTraversal(tree.root);
		System.out.print("\n-----------------------------------------------------------------------------------------");
	}
}
