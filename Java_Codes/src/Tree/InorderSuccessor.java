package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.MyBinaryTree.Node;

public class InorderSuccessor {
	static Node treeMin(Node node) {
		while (node.left != null)
			node = node.left;

		return node;
	}

	static Node findInorderSuccessor(Node node, int nodeValue) {
		if (node == null)
			return null;

		Node successor = null;
		while (node != null) {
			if (nodeValue > node.data) {
				node = node.right;
			} else if (nodeValue < node.data) {
				successor = node;
				node = node.left;
			} else {
				if (node.right != null) {
					successor = treeMin(node.right);
				}
				break;
			}

			if (node == null) {
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
		int data = 50;
		Node successor = findInorderSuccessor(tree.root, data);
		System.out.println(successor == null ? "Successor not found for [" + data + "]"
				: "Successor [" + successor.data + "] found for [" + data + "]");

	}

}
