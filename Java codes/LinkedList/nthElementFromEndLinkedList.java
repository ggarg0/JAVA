package LinkedList;

import LinkedList.MySinglyLinkedList.Node;

public class nthElementFromEndLinkedList {

	public static Object nthElementFromEnd(MySinglyLinkedList<Integer> list, int n) {
		int result = 0;
		int counter = (list.length() + 1) - n;

		if (counter <= 0) {
			list.printList("Length of list not valid for [" + n + "] element from end");
			return -1;
		}

		Node current = list.headNode;

		while (current != null) {
			if (++result == counter) {
				break;
			}
			current = current.nextNode;
		}

		list.printList("[" + n + "] element from end is (" + current.data + ") from list :");
		return current.data;
	}

	public static void main(String[] args) {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();

		nthElementFromEnd(list, 3);
		for (int i = 0; i < 15; i += 2) {
			list.insertAtHead(i);
		}

		nthElementFromEnd(list, 5);
		nthElementFromEnd(list, 10);
	}
}
