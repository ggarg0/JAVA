package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.MyBinaryTree.Node;

public class InorderIterator {

	Stack<Node> stack = new Stack<Node>();

	public InorderIterator(Node root) {
		populateStack(root);
	}

	public void populateStack(Node root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public Node getNext() {
		if (stack.isEmpty())
			return null;

		Node rVal = stack.pop();
		Node temp = rVal.right;
		populateStack(temp);
		return rVal;
	}

	public static String inorderUsingIterator(Node root) {
		InorderIterator iter = new InorderIterator(root);
		String result = "";
		while (iter.hasNext()) {
			result += iter.getNext().data;
			if (iter.hasNext()) {
				result += ", ";
			}
		}
		if (result == "") {
			result = "null";
		} else if (result.contains(", ")) {
			result.substring(0, result.length() - 2);
		}
		return result;
	}

	public static void main(String[] args) {
		// Creating a binary tree
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
		System.out.print("InorderUsingIterator: ");
		System.out.println(inorderUsingIterator(tree.root));
		System.out.print("---------------------------------------------------------------------\n");
	}
}
