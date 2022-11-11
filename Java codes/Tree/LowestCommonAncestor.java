package Tree;

import Tree.MyBinaryTree.Node;

public class LowestCommonAncestor {

	public static Node findLCA(Node node, int n1, int n2) {
		if (node == null)
			return null;

		if (node.data == n1 || node.data == n2)
			return node;

		Node left = findLCA(node.left, n1, n2);
		Node right = findLCA(node.right, n1, n2);

		if (left != null && right != null)
			return node;

		return (left != null) ? left : right;
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.printTree();
		System.out.println("LCA(4, 5) = " + findLCA(tree.root, 4, 5).data);
		System.out.println("LCA(4, 6) = " + findLCA(tree.root, 4, 6).data);
		System.out.println("LCA(3, 4) = " + findLCA(tree.root, 3, 4).data);
		System.out.println("LCA(2, 4) = " + findLCA(tree.root, 2, 4).data);
		System.out.println("LCA(7, 6) = " + findLCA(tree.root, 7, 6).data);
	}
}
