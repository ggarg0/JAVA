package Tree;

import Tree.MyBinaryTree.Node;

public class BalancedBinaryTree {

	public static boolean isBalanced(Node node) {
		if (node == null)
			return true;

		int leftSubTreeHeight = height(node.left);
		int rightSubTreeHeight = height(node.right);

		if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) <= 1)
			return true;

		return false;
	}

	public static int height(Node node) {
		if (node == null)
			return 0;
	
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(8);
		tree.insert(3);
		tree.insert(9);		
		tree.insert(-3);
		tree.insert(-2);		
		tree.printTree();	
		
		if (isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
