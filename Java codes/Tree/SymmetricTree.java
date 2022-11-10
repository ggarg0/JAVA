package Tree;

import Tree.MyBinaryTree.Node;

public class SymmetricTree {

	public static boolean isSymmetric(Node root) {
		return root == null || isSymmetricHelp(root.left, root.right);
	}

	private static boolean isSymmetricHelp(Node left, Node right) {
		if (left == null || right == null)
			return left == right;
		if (left.data != right.data)
			return false;
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(1);
		tree.insert(2);
		tree.insertBT(2);
		tree.insertBT(3);
		tree.insertBT(4);
		tree.insert(3);
		tree.insertBT(4);
		tree.printTree();
		System.out.println("isSymmetric : " + isSymmetric(tree.root));
	}
}
