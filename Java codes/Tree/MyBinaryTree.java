package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinaryTree {

	public static class Node {
		public int data;
		public Node left;
		public Node right;
		public Node next;
		public Node parent;
		public int count;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.next = null;
			this.parent = null;
			this.count = 0;
		}
	}

	public Node root;

	public MyBinaryTree() {
		this.root = null;
	}

	public MyBinaryTree(int nodeData) {
		this.root = new Node(nodeData);
	}

	public MyBinaryTree(List<Integer> nodeDataList) {
		this.root = null;
		for (Integer nodeData : nodeDataList) {
			insert(nodeData);
		}
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (this.root == null) {
			this.root = newNode;
		} else {
			Node parent = null;
			Node temp = this.root;
			while (temp != null) {
				parent = temp;
				if (data <= temp.data) {
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			}
			if (data <= parent.data) {
				parent.left = newNode;
			} else {
				parent.right = newNode;
			}
		}
	}

	public void insertBT(int key) {
		Queue<Node> tempQueue = new LinkedList<Node>();
		Node temp = this.root;
		tempQueue.add(temp);

		while (!tempQueue.isEmpty()) {
			temp = tempQueue.peek();
			tempQueue.remove();

			if (temp.left == null) {
				temp.left = new Node(key);
				break;
			} else {
				tempQueue.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = new Node(key);
				break;
			} else {
				tempQueue.add(temp.right);
			}
		}
	}

	private Node findInBSTRec(Node node, int nodeData) {
		if (node == null)
			return null;

		if (node.data == nodeData) {
			return node;
		} else if (node.data > nodeData) {
			return findInBSTRec(node.left, nodeData);
		} else {
			return findInBSTRec(node.right, nodeData);
		}
	}

	public Node findInBST(int nodeData) {
		return findInBSTRec(this.root, nodeData);
	}

	private void populateParentsRec(Node node, Node parent) {
		if (node != null) {
			node.parent = parent;
			populateParentsRec(node.left, node);
			populateParentsRec(node.right, node);
		}
	}

	public void populateParents() {
		populateParentsRec(this.root, null);
	}

	public int getSubTreeNodeCount(Node node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + getSubTreeNodeCount(node.left) + getSubTreeNodeCount(node.right);
		}
	}

	private void populateCountRec(Node node) {
		if (node != null) {
			node.count = getSubTreeNodeCount(node);
			populateCountRec(node.left);
			populateCountRec(node.right);
		}
	}

	public void populateCount() {
		populateCountRec(this.root);
	}

	private Node getTreeDeepCopyRec(Node node) {
		if (node != null) {
			Node newNode = new Node(node.data);
			newNode.left = getTreeDeepCopyRec(node.left);
			newNode.right = getTreeDeepCopyRec(node.right);
			return newNode;
		} else {
			return null;
		}
	}

	public MyBinaryTree getTreeDeepCopy() {
		if (this.root == null) {
			return null;
		} else {
			MyBinaryTree treeCopy = new MyBinaryTree();
			treeCopy.root = getTreeDeepCopyRec(root);
			return treeCopy;
		}
	}

	private Node findInBTRec(Node node, int nodeData) {
		if (node == null) {
			return null;
		}

		if (node.data == nodeData) {
			return node;
		}

		Node leftNode = findInBTRec(node.left, nodeData);
		if (leftNode != null) {
			return leftNode;
		}

		Node rightNode = findInBTRec(node.right, nodeData);
		return rightNode;
	}

	public Node findInBT(int nodeData) {
		return findInBTRec(this.root, nodeData);
	}

	public void printTree() {
		System.out.println("");
		printTree("", root);
		System.out.println("");
	}

	public void printTree(String prefix, Node node) {
		if (node != null) {
			printTree(prefix + "|    ", node.right);
			System.out.println(prefix + ("|----") + node.data);
			printTree(prefix + "|    ", node.left);
		}
	}

	public static void main(String[] args) {
		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(100);
		input1.add(50);
		input1.add(200);
		input1.add(25);
		input1.add(125);
		input1.add(350);
		input1.add(200);
		input1.add(25);
		input1.add(28);
		input1.add(26);
		MyBinaryTree tree1 = new MyBinaryTree(input1);
		tree1.printTree();


		MyBinaryTree tree2 = new MyBinaryTree();
		tree2.insert(25);
		tree2.insert(27);
		tree2.insertBT(24);
		tree2.insert(29);
		tree2.insertBT(28);
		tree2.insert(22);
		tree2.printTree();
		
		MyBinaryTree tree = new MyBinaryTree();
		tree.insert(25);
		tree.insert(27);
		tree.insert(24);
		tree.insert(29);
		tree.insert(28);
		tree.insert(22);
		tree.printTree();
	}

}
