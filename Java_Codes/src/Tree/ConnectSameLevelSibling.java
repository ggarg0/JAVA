package Tree;

import Tree.MyBinaryTree.Node;

public class ConnectSameLevelSibling {

	public static void connect(Node root) {
		if (root == null)
			return;

		if (root.left != null) {
			root.next = root.left;
			root.left.next = root.right;
			if (root.next != null) {
				root.right.next = root.next.left;
			}
		}

		connect(root.left);
		connect(root.right);
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
		connect(tree.root);
		tree.printTree();
	}

}
