package Recursion;

import LinkedList.MySinglyLinkedList;
import LinkedList.MySinglyLinkedList.Node;

public class SearchInLinkedList {

	public static boolean search(Node<Integer> head, int num) {
		if (head == null)
			return false;

		if (head.data == num)
			return true;
		else
			return search(head.nextNode, num);
	}

	public static void main(String[] args) {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
		list.insertAtHead(0);
		list.insertAtHead(3);
		list.insertAtHead(1);
		list.insertAtHead(6);
		list.insertAtHead(4);

		int searchFor = 8;
		boolean result = search(list.getHeadNode(), searchFor);
		System.out.println("Is " + searchFor + " present in the list? : " + result);
	}

}
