package Tree;

import Tree.MyBinaryTree.Node;

public class DeleteZeroSumSubTree {

	public static int deleteZeroSumTreeRec(Node node) {
		if (node == null)
			return 0;

		int sumLeft = deleteZeroSumTreeRec(node.left);
		int sumRight = deleteZeroSumTreeRec(node.right);

		if (sumLeft == 0)
			node.left = null;

		if (sumRight == 0)
			node.right = null;

		return node.data + sumLeft + sumRight;
	}

	public static void deleteZeroSumTree(MyBinaryTree tree) {
		if (tree == null || tree.root == null)
			return;

		int treeSum = deleteZeroSumTreeRec(tree.root);

		if (treeSum == 0)
			tree.root = null;
	}

	public static void main(String[] args) {		
		MyBinaryTree tree = new MyBinaryTree();
		tree.root = new Node(7);
		tree.root.left = new Node(5);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(-3);
		tree.root.left.right = new Node(-2);
	
		tree.printTree();
		deleteZeroSumTree(tree);
		tree.printTree();
	}
}
