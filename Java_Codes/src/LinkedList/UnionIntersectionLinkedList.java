package LinkedList;

import java.util.HashSet;
import java.util.Set;

import LinkedList.MySinglyLinkedList.Node;

public class UnionIntersectionLinkedList {

	public static MySinglyLinkedList<Object> unionWithHashing(MySinglyLinkedList<Object> list1,
			MySinglyLinkedList<Object> list2) {
		MySinglyLinkedList<Object> result = new MySinglyLinkedList<Object>();
		Set<Object> set = new HashSet<Object>();

		Node<Object> current = list1.headNode;
		while (current != null) {

			if (set.add(current.data)) 
				result.insertAtHead(current.data);
	
			current = current.nextNode;
		}

		current = list2.headNode;
		while (current != null) {

			if (set.add(current.data)) 
				result.insertAtEnd(current.data);
	
			current = current.nextNode;
		}
		
		result.printList("After Union :");
		return result;
	}

	public static MySinglyLinkedList<Object> intersectionWithHashing(MySinglyLinkedList<Object> list1,
			MySinglyLinkedList<Object> list2) {
		MySinglyLinkedList<Object> result = new MySinglyLinkedList<Object>();

		Set<Object> set = new HashSet<Object>();
		Node<Object> current = list1.headNode;

		while (current != null) {
			if (!set.add(current.data)) 
				result.insertAtEnd(current.data);
			
			current = current.nextNode;
		}

		current = list2.headNode;
		while (current != null) {
			if (!set.add(current.data)) 
				result.insertAtEnd(current.data);
			
			current = current.nextNode;
		}

		result.printList("After Intersection :");
		return result;
	}

	public static void main(String[] args) {

		MySinglyLinkedList<Object> list1 = new MySinglyLinkedList<Object>();
		for (int i = 9; i > 2; i--) {
			list1.insertAtHead(i);
		}
		list1.printList("List 1 :");

		MySinglyLinkedList<Object> list2 = new MySinglyLinkedList<Object>();
		for (int i = 0; i < 5; i++) {
			list2.insertAtHead(i);
		}
		list2.printList("List 2 :");

		System.out.println("Calling Intersection ");
		intersectionWithHashing(list1, list2);

		System.out.println("Calling Union ");
		unionWithHashing(list1, list2);
	}

}
