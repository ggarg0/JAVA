package Tree;

import Tree.MyBinaryTree.Node;

public class CheckForSubTreeInBST1 {

	public static boolean areIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return (root1.data == root2.data && areIdentical(root1.left, root2.left)
				&& areIdentical(root1.right, root2.right));
	}

	public static boolean isSubtree(Node T, Node S) {
		if (S == null)
			return true;

		if (T == null)
			return false;

		if (areIdentical(T, S))
			return true;

		return isSubtree(T.left, S) || isSubtree(T.right, S);
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.root = new Node(26);
		tree.root.right = new Node(3);
		tree.root.right.right = new Node(3);
		tree.root.left = new Node(10);
		tree.root.left.left = new Node(4);
		tree.root.left.left.right = new Node(30);
		tree.root.left.right = new Node(6);
		tree.printTree();
		
		MyBinaryTree tree1 = new MyBinaryTree();
		tree1.root = new Node(10);
		tree1.root.right = new Node(6);
		tree1.root.left = new Node(4);
		tree1.root.left.right = new Node(30);
		tree1.printTree();
		
		if (isSubtree(tree.root, tree1.root))
			System.out.println("Tree 2 is subtree of Tree 1 ");
		else
			System.out.println("Tree 2 is not a subtree of Tree 1");
	}
}
