package Tree;

import Tree.MyBinaryTree.Node;

public class MirrorBinaryTree {
	public static void mirrorBinaryTree(Node node) {	
		if (node == null) 
			return;
		
		if (node.left != null) 
			mirrorBinaryTree(node.left);
		
		if (node.right != null) 
			mirrorBinaryTree(node.right);
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
	
	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(-3);
		tree.insert(-2);
		
		tree.printTree();
		mirrorBinaryTree(tree.root);
		tree.printTree();	
	}
}
