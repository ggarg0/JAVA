package Tree;

import Tree.MyBinaryTree.Node;

public class PrintTreePerimeter {

	public static void printLeftPerimeter(Node root, StringBuilder result) {
		if (root == null) 
			return;
		
		if (root.left != null) {
			result.append(String.valueOf(root.data) + " ");
			printLeftPerimeter(root.left, result);
		} else if (root.right != null) {
			result.append(String.valueOf(root.data) + " ");
			printLeftPerimeter(root.right, result);
		}
	}

	public static void printRightPerimeter(Node root, StringBuilder result) {
		if (root == null) 
			return;

		if (root.right != null) {		
			printRightPerimeter(root.right, result);			
			result.append(String.valueOf(root.data) + " ");
		} else if (root.left != null) {
			printRightPerimeter(root.left, result);
			result.append(String.valueOf(root.data) + " ");
		}
	}

	
	public static void printLeafNodes(Node root, StringBuilder result) {
		if (root == null) 
			return;
		
		printLeafNodes(root.left, result);
	
		if (root.left == null && root.right == null) 
			result.append(String.valueOf(root.data) + " ");
		
		printLeafNodes(root.right, result);
	}

	public static void displayTreePerimeter(Node root) {
		StringBuilder result = new StringBuilder();
		if (root != null) {			
			result.append(String.valueOf(root.data) + " ");
			printLeftPerimeter(root.left, result);
			printLeafNodes(root.left, result);
			printLeafNodes(root.right, result);
			printRightPerimeter(root.right, result);
		}		
		System.out.print(result.toString());
	}

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(100);
		tree.insert(50);
		tree.insert(200);
		tree.insert(25);
		tree.insert(125);
		tree.insert(750);
		tree.insert(12);
		tree.insert(35);

		System.out.println("Binary Tree:");
		System.out.print("-----------------------------------------------------------------------------------------");
		tree.printTree();
		System.out.print("-----------------------------------------------------------------------------------------\n");
		displayTreePerimeter(tree.root);
		System.out.print("\n-----------------------------------------------------------------------------------------");
	}

}
