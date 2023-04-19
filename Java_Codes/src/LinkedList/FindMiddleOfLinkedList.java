package LinkedList;

import LinkedList.MySinglyLinkedList.Node;

public class FindMiddleOfLinkedList {

	public static Object findMiddleElementUsingTwoPointer(MySinglyLinkedList<Integer> list) {

		Node<Integer> current = list.headNode;
		Node<Integer> mid = list.headNode;

		while (current != null && mid != null && current.nextNode != null) {
			current = current.nextNode.nextNode;
			if (current != null) {
				mid = mid.nextNode;
			}
		}
		list.printList("Using two pointers -> Middle element is [" + mid.data + "] for list : ");
		return mid.data;
	}

	public static Object findMiddleElementUsingListLength(MySinglyLinkedList<Integer> list) {

		int length = list.length() / 2;
		Node<Integer> current = list.headNode;

		for (int i = 0; i < length - 1; i++) {
			current = current.nextNode;
		}

		list.printList("Using list length -> Middle element is [" + current.data + "] for list : ");
		return current.data;
	}

	public static void main(String[] args) {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
		list.length();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);

		findMiddleElementUsingTwoPointer(list);
		findMiddleElementUsingListLength(list);
	}

}
