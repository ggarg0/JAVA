package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.MyBinaryTree.Node;

public class InorderSuccessor {
	static Node treeMin(Node root) {
		while (root.left != null)
			root = root.left;

		return root;
	}

	static Node findInorderSuccessor(Node root, int nodeValue) {
		if (root == null)
			return null;

		Node successor = null;
		while (root != null) {
			if (root.data < nodeValue) {
				root = root.right;
			} else if (root.data > nodeValue) {
				successor = root;
				root = root.left;
			} else {
				if (root.right != null) {
					successor = treeMin(root.right);
				}
				break;
			}

			if (root == null) {
				Node temp = new Node(-1);
				return temp;
			}
		}
		return successor;
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(100);
		input.add(50);
		input.add(200);
		input.add(25);
		input.add(75);
		input.add(125);
		input.add(300);
		input.add(12);
		input.add(35);
		input.add(60);
		// Collections.sort(input);
		// Collections.sort(input, Collections.reverseOrder());

		MyBinaryTree tree = new MyBinaryTree(input);

		System.out.println("Binary Tree:");
		System.out.print("---------------------------------------------------------------------\n");
		tree.printTree();
		System.out.print("---------------------------------------------------------------------\n");
		System.out.print("findInorderSuccessor: ");
		int data = 25;
		Node successor = findInorderSuccessor(tree.root, data);
		System.out.println(successor == null ? "Successor not found for [" + data + "]"
				: successor.data + " found for [" + data + "]");

	}

}
