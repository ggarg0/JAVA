package Tree;

import java.util.Stack;

import Tree.MyBinaryTree.Node;

public class TreeTraversalWithStack {
	// left - root - right
	static void inOrderTraversal(Node root) {
		if (root == null) {
			System.out.print("null");
		} else {
			Stack<Node> stack = new Stack<Node>();
			Node node = root;
			String result = "";
			while (!stack.isEmpty() || node != null) {
				if (node != null) {
					stack.push(node);
					node = node.left;
					continue;
				}
				result += stack.peek().data + " ";
				node = stack.pop().right;
			}
			System.out.println("inOrderTraversal : " + (result.isBlank() ? "null" : result));
		}
	}
	// root - left - right
	static void preOrderTraversal(Node root) {
		if (root == null) {
			System.out.print("null");
		} else {
			Stack<Node> stack = new Stack<Node>();
			Node node = root;
			String result = "";
			while (!stack.isEmpty() || node != null) {
				if (node != null) {
					stack.push(node);
					result += stack.peek().data + " ";
					node = node.left;
					continue;
				}
				node = stack.pop().right;
			}
			System.out.println("preOrderTraversal: " + (result.isBlank() ? "null" : result));
		}
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.insert(25);
		tree.insert(27);
		tree.insert(24);
		tree.insert(29);
		tree.insert(28);
		tree.insert(22);

		System.out.println("Binary Tree:");
		System.out.print("---------------------------------------------------------------------\n");
		tree.printTree();
		System.out.print("---------------------------------------------------------------------\n");
		inOrderTraversal(tree.root);
		preOrderTraversal(tree.root);
	}
}
