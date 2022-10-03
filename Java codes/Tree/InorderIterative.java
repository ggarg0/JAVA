package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import Tree.MyBinaryTree.Node;

public class InorderIterative {

	static void iterativeInorder(Node root) {
		if (root == null) {
			System.out.print("null");
		} else {
			Stack<Node> stack = new Stack<Node>();
			Node currNode = root;
			while (!stack.empty() || currNode != null) {
				if (currNode != null) {
					stack.push(currNode);
					currNode = currNode.left;
					continue;
				}
				System.out.print(stack.peek().data);
				currNode = stack.pop().right;
				if (!(stack.empty() && currNode == null)) {
					System.out.print(", ");
				}
			}
		}
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
		//Collections.sort(input);
		// Collections.sort(input, Collections.reverseOrder());

		MyBinaryTree tree = new MyBinaryTree(input);

		System.out.println("Binary Tree:");
		System.out.print("---------------------------------------------------------------------\n");
		tree.printTree();
		System.out.print("---------------------------------------------------------------------\n");
		System.out.print("InorderUsingIterator: ");
		iterativeInorder(tree.root);
	}
}
