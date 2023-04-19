package Tree;

import java.util.Arrays;

import Tree.MyBinaryTree.Node;

public class BinaryTreeToBST {
	static int index;

	static void storeInorder(Node node, int inorder[]) {
		if (node == null)
			return;

		storeInorder(node.left, inorder);
		inorder[index] = node.data;
		index++;
		storeInorder(node.right, inorder);
	}

	static void arrayToBST(int[] arr, Node root) {
		if (root == null)
			return;

		arrayToBST(arr, root.left);
		root.data = arr[index];
		index++;
		arrayToBST(arr, root.right);
	}

	static void binaryTreeToBST(MyBinaryTree tree) {
		if (tree.root == null)
			return;

		int n = tree.getSubTreeNodeCount(tree.root);
		int arr[] = new int[n];
		storeInorder(tree.root, arr);
		Arrays.sort(arr);
		index = 0;
		arrayToBST(arr, tree.root);
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(30);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(20);
		tree.root.right.right = new Node(5);
		tree.printTree();
		binaryTreeToBST(tree);
		System.out.println("Following is Inorder Traversal of the converted BST: ");
		tree.printTree();
	}
}
