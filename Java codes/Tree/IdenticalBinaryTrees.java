package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.MyBinaryTree.Node;

public class IdenticalBinaryTrees {

	public static boolean areIdentical(Node tree1, Node tree2) {
		if (tree1 == null && tree2 == null) 
			return true;
	
		if (tree1 != null && tree2 != null) {
			return (areIdentical(tree1.left, tree2.left) && areIdentical(tree1.right, tree2.right)
					&& (tree1.data == tree2.data));
		}
		return false;
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

		List<Integer> input3 = new ArrayList<Integer>();
		input3.add(100);
		input3.add(50);
		input3.add(200);
		input3.add(25);
		input3.add(125);
		input3.add(350);
		MyBinaryTree tree3 = new MyBinaryTree(input3);

		System.out.println("First binary tree:  ");
		tree1.printTree();
		System.out.println("\nSecond binary tree: ");
		tree2.printTree();
		System.out.println("\nThird binary tree: ");
		tree3.printTree();
		System.out.print(
				"\n----------------------------------------------------------------------------------------------------");
		System.out.print("\n\tIdentical Tree: " + areIdentical(tree1.root, tree3.root));
		System.out.print(
				"\n----------------------------------------------------------------------------------------------------");

	}
}
