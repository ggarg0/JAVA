package Tree;

import java.util.Stack;

import Tree.MyBinaryTree.Node;

public class NthLargestNumberInBST {

	public static int nthLargest(Node root, int n) {
		if (root == null)
			return Integer.MAX_VALUE;

		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.right;
			} else {
				current = stack.pop();
				n = n - 1;
				if (n == 0)
					return current.data;

				current = current.left;
			}
		}
		return Integer.MAX_VALUE;
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
		System.out.println(nthLargest(tree.root, 3));

	}

}
