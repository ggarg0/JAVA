package Tree;

import java.util.Stack;

import Tree.MyBinaryTree.Node;

public class NthSmallestNumberInBST {

	public static int nthSmallest(Node root, int n) {
		if (root == null)
			return Integer.MIN_VALUE;

		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				n = n - 1;
				if (n == 0)
					return current.data;

				current = current.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(5);
		tree.insert(2);
		tree.insert(1);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);
		tree.insert(6);
		tree.printTree();
		System.out.println(nthSmallest(tree.root, 4));
	}
}
