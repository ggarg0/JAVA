package Tree;

import java.util.Stack;

import Tree.MyBinaryTree.Node;

public class NthSmallestNumberInBST {

	public static int nthSmallest(Node root, int k) {
		Stack<Node> st = new Stack<>();
		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			Node n = st.pop();
			k--;
			if (k == 0)
				return n.data;
			Node right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}
		return -1; 
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(5);
		tree.insert(2);
		tree.insert(1);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);
		tree.insert(6);
		tree.printTree();
		System.out.println(nthSmallest(tree.root, 3));
	}
}
