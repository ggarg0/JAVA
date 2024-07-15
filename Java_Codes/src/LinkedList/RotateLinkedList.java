package LinkedList;

import LinkedList.MySinglyLinkedList.Node;

public class RotateLinkedList {
	public static void rotate(MySinglyLinkedList<Object> list, int n) {
		if (list.isEmpty() || n == 0) {
			return;
		}

		if (n < 0) {
			n = n + list.length();
		}		

		int rotationsCount = list.length() - n;
		Node<Object> current = list.getHeadNode();
		Node<Object> previous = null;	
		while (rotationsCount != 0) {
			rotationsCount--;
			previous = current;
			current = current.nextNode;
		}				
		previous.nextNode = null;			
		Node<Object> temp = list.getHeadNode();
		list.setHeadNode(current);
		
		while(current.nextNode != null) {
			current = current.nextNode;
		}
		current.nextNode = temp;

	}

	public static void main(String[] args) {
		MySinglyLinkedList<Object> list = new MySinglyLinkedList<Object>();
		list.length();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		rotate(list, -2);
		list.printList("After rotate by -2 : ");
		list.length();

	}

}
