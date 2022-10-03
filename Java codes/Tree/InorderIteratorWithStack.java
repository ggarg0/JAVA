package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.MyBinaryTree.Node;

public class InorderIteratorWithStack {

	Stack<Node> stack = new Stack<Node>();

	public InorderIteratorWithStack(Node node) {
		populateStack(node);
	}

	public void populateStack(Node node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public Node getNext() {
		if (stack.isEmpty())
			return null;

		Node node = stack.pop();

		// We now populate the stack again from root till the left-most node in the
		// sub-tree of the right child of the node we just extracted
		populateStack(node.right);
		return node;
	}

	public static void inOrderUsingIterator(Node node) {
		InorderIteratorWithStack iterator = new InorderIteratorWithStack(node);
		String result = "";
		while (iterator.hasNext()) {
			result += iterator.getNext().data + ", ";
		}
		System.out.println(result.isBlank() ? "null" : result.substring(0, result.length() - 2));
	}

	public static void main(String[] args) {
		// Creating a binary tree
		List<Integer> input = new ArrayList<Integer>();
		input.add(40);
		input.add(50);
		input.add(25);
		input.add(75);
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
		System.out.print("InorderUsingIterator: ");
		inOrderUsingIterator(tree.root);
		System.out.print("---------------------------------------------------------------------\n");
	}
}
