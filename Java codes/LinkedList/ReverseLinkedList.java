package LinkedList;

import LinkedList.MySinglyLinkedList.Node;

public class ReverseLinkedList {

	public static void reverse(MySinglyLinkedList<Object> list) {
		Node<Object> previous = null;
		Node<Object> current = list.headNode;
		Node<Object> next = null;
		while (current != null) {
			next = current.nextNode;
			current.nextNode = previous;
			previous = current;
			current = next;
		}
		list.headNode = previous;
		list.printList("Reversed list : ");
	}

	public static void main(String[] args) {
		MySinglyLinkedList<Object> list = new MySinglyLinkedList<Object>();
		list.length();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		reverse(list);
	}
}
