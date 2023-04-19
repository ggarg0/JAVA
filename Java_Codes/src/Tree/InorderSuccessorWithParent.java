package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.MyBinaryTree.Node;

public class InorderSuccessorWithParent {

	static Node findSuccessor(Node node, int nodeValue) {
		if (node == null)
			return null;

		if (node.right != null) {
			Node temp = node.right;
			while (temp.left != null)
				temp = temp.left;

			return temp;
		} else {
			if (node.parent.left == node)
				return node.parent;

			return null;
		}
	}

	static Node findInorderSuccessor(Node node, int nodeValue) {
		while (node != null) {
			if (nodeValue < node.data) {
				node = node.left;
			} else if (nodeValue > node.data) {
				node = node.right;
			} else {
				return findSuccessor(node, nodeValue);
			}

			if (node == null) {
				Node temp = new Node(-1);
				return temp;
			}
		}
		return null;
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

		MyBinaryTree tree = new MyBinaryTree(input);
		tree.populateParents();

		System.out.println("Binary Tree:");
		System.out.print("---------------------------------------------------------------------\n");
		tree.printTree();
		System.out.print("---------------------------------------------------------------------\n");
		System.out.print("findInorderSuccessor: ");
		int data = 66;
		Node successor = findInorderSuccessor(tree.root, data);
		System.out.println(successor == null ? "Successor not found for [" + data + "]"
				: "Successor [" + successor.data + "] found for [" + data + "]");

	}

}
