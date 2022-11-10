package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.MyBinaryTree.Node;

public class MergeTree {

	public static Node mergeTreesRec(Node t1, Node t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;

		Node node = new Node(t1.data + t2.data);
		node.left = mergeTreesRec(t1.left, t2.left);
		node.right = mergeTreesRec(t1.right, t2.right);
		return node;
	}

	public static MyBinaryTree mergeTrees(Node t1, Node t2) {
		if (t1 == null)
			return new MyBinaryTree(t2);
		if (t2 == null)
			return new MyBinaryTree(t1);

		return new MyBinaryTree(mergeTreesRec(t1, t2));
	}

	public static void main(String[] args) {
		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(100);
		input1.add(50);
		input1.add(200);
		input1.add(25);
		input1.add(125);
		input1.add(350);
		MyBinaryTree tree1 = new MyBinaryTree(input1);

		List<Integer> input2 = new ArrayList<Integer>();
		input2.add(4);
		input2.add(2);
		input2.add(6);
		input2.add(1);
		input2.add(5);
		input2.add(7);
		MyBinaryTree tree2 = new MyBinaryTree(input2);

		tree1.printTree();
		tree2.printTree();

		MyBinaryTree tree3 = mergeTrees(tree1.root, tree2.root);
		tree3.printTree();
	}

}
