package Tree;

import Tree.MyBinaryTree.Node;

public class SumRootToLeafNumbers {

	public static int sumNumbers(Node root) {
		return sum(root, 0);
	}

	public static int sum(Node n, int s) {
		if (n == null)
			return 0;
		if (n.right == null && n.left == null)
			return s * 10 + n.data;

		return sum(n.left, s * 10 + n.data) + sum(n.right, s * 10 + n.data);
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(6);
		tree.insert(5);
		tree.insert(7);
		tree.insert(4);
	
		tree.printTree();
		System.out.println("Sum : " + sumNumbers(tree.root));
	}
}
