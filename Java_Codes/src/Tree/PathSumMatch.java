package Tree;

import Tree.MyBinaryTree.Node;

public class PathSumMatch {

	public static boolean hasPathSum(Node root, int targetSum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return targetSum == root.data;

		return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(1);
		tree.insert(2);
		tree.insert(2);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);
		tree.insert(6);
		tree.printTree();
		System.out.println("Target sum matched : " + hasPathSum(tree.root, 10));

	}

}
