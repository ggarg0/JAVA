package LinkedList;

import java.util.HashSet;

import LinkedList.MySinglyLinkedList.Node;

public class DetectLoopInLinkedList {

	public static boolean detectLoopUsingTwoPointers(MySinglyLinkedList<Integer> list) {
		boolean result = false;
		Node<Integer> current = list.headNode;
		Node<Integer> next = list.headNode;

		while (current != null && next != null && next.nextNode != null) {
			current = current.nextNode;
			next = next.nextNode.nextNode;

			if (current == next) {
				result = true;
				break;
			}
		}
		System.out.println("Detect loop using two pointers : " + result);
		return result;
	}

	public static boolean detectLoopUsingSet(MySinglyLinkedList<Integer> list) {
		boolean result = false;
		HashSet<Node<Integer>> set = new HashSet<Node<Integer>>();
		Node<Integer> node = list.headNode;

		while (node != null) {
			if (set.contains(node)) {
				result = true;
				break;
			}
			set.add(node);
			node = node.nextNode;
		}
		System.out.println("Detect loop using HashSet : " + result);
		return result;
	}

	public static void main(String[] args) {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
		list.length();
		list.insertAtHead(7);
		list.insertAtHead(14);
		list.insertAtHead(21);
		list.headNode.nextNode.nextNode = list.headNode;

		detectLoopUsingTwoPointers(list);
		detectLoopUsingSet(list);
	}
}
