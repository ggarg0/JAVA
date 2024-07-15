package LinkedList;

import LinkedList.MySinglyLinkedList.Node;

public class ReverseKNodesLinkedList {

	static void reverseKNodes(MySinglyLinkedList<Integer> list, int k) {

		if (list.isEmpty() || k <= 0) {
			return;
		}

		Node<Integer> head = list.getHeadNode();
		Node<Integer> reversed = null;
		Node<Integer> previousNode = null;

		while (head != null && k > 0) {
			Node<Integer> previous = null;
			Node<Integer> currentHead = head;
			int counter = k;

			// loop for iterating each sub-list
			while (head != null && counter > 0) {
				Node<Integer> next = head.nextNode;
				head.nextNode = previous;
				previous = head;
				head = next;
				counter--;
			}

			if (reversed == null) {
				reversed = previous;
			}

			if (previousNode != null) {
				previousNode.nextNode = previous;
			}
			previousNode = currentHead;
		}

		list.setHeadNode(reversed);

	}

	public static void main(String[] args) {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
		list.length();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(8);
		reverseKNodes(list, 3);
		list.printList();
		list.length();

	}

}
