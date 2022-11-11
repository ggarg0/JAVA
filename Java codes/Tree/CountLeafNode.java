package Tree;

import Tree.MyBinaryTree.Node;

public class CountLeafNode {
	public static int getLeafCount(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(5);
		tree.insert(2);
		tree.insert(2);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);
		tree.insert(6);
		tree.printTree();
		System.out.println("The leaf count of binary tree is : " + getLeafCount(tree.root));
	}
}
