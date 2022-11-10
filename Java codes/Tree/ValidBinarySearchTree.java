package Tree;

import Tree.MyBinaryTree.Node;

public class ValidBinarySearchTree {

	public static boolean isBSTValidRec(Node node, int min_value, int max_value) {
		if (node == null)
			return true;

		if (node.data < min_value || node.data > max_value)
			return false;

		return isBSTValidRec(node.left, min_value, node.data) && isBSTValidRec(node.right, node.data, max_value);
	}

	public static boolean isBSTValid(Node root) {
		return isBSTValidRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(25);
		tree.insert(75);
		tree.insert(110);
	//	tree.insertBT(90);
		tree.insert(125);

		System.out.println("Binary Tree:");
		System.out.print("-----------------------------------------------------------------------------------------");
		tree.printTree();
		System.out.print("-----------------------------------------------------------------------------------------\n");
		System.out.println(isBSTValid(tree.root));
		System.out.print("-----------------------------------------------------------------------------------------");
	}
}
