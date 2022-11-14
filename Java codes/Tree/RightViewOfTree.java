package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.MyBinaryTree.Node;

public class RightViewOfTree {

	public static List<Integer> rightSideView(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	public static void rightView(Node curr, List<Integer> result, int currDepth) {
		if (curr == null)
			return;

		if (currDepth == result.size())
			result.add(curr.data);

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}

	public static List<Integer> rightSideView1(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (i == size - 1)
					result.add(node.data);

				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(8);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(14);
		tree.root.right.right.left = new Node(15);
		tree.root.right.right.right = new Node(17);
		tree.printTree();
		System.out.println("Right view : " + rightSideView(tree.root));
		
		MyBinaryTree tree1 = new MyBinaryTree(5);
		tree1.insert(2);
		tree1.insert(1);
		tree1.insert(4);
		tree1.insert(7);
		tree1.insert(9);
		tree1.insert(6);
		tree1.printTree();
		System.out.println("Right view : " + rightSideView(tree1.root));
	}
}
