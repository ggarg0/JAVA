package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.MyBinaryTree.Node;

public class CheckForSubTreeInBST {
	static List<Node> nodes = new ArrayList<Node>();

	static int height_of_tree(Node root) {
		if (root == null)
			return 0;

		int left = height_of_tree(root.left);
		int right = height_of_tree(root.right);
		return 1 + Math.max(left, right);
	}

	static boolean CheckSubTree(Node T, Node S) {
		if (S == null && T == null)
			return true;

		if (T == null || S == null)
			return false;

		if (T.data != S.data)
			return false;

		return CheckSubTree(T.left, S.left) && CheckSubTree(T.right, S.right);
	}

	static int subtree_height(Node root, int h) {
		if (root == null)
			return 0;
		else {
			int left = subtree_height(root.left, h);
			int right = subtree_height(root.right, h);
			int height = Math.max(left, right) + 1;

			if (height == h)
				nodes.add(root);

			return height;
		}
	}

	static boolean isSubTree(Node T, Node S) {
		if (T == null && S == null)
			return true;

		if (T == null || S == null)
			return false;

		int h = height_of_tree(S);
		int h1 = subtree_height(T, h);
		boolean result = false;
		int n = nodes.size();

		for (int i = 0; i < n; i++) {
			if (nodes.get(i).data == S.data)
				result = CheckSubTree(nodes.get(i), S);
			if (result)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		Node T = new Node(1);
		T.left = new Node(2);
		T.right = new Node(3);
		T.left.left = new Node(4);
		T.left.right = new Node(5);
		T.right.left = new Node(6);
		tree.root = T;
		
		MyBinaryTree tree1 = new MyBinaryTree();
		Node S = new Node(3);
		S.left = new Node(6);
		tree1.root = S;
		
		tree.printTree();
		tree1.printTree();
		
		if (isSubTree(T, S))
			System.out.print("Yes" + "\n");
		else
			System.out.print("No" + "\n");
	}
}
