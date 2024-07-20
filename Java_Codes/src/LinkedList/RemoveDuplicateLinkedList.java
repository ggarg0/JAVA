package LinkedList;

import java.util.HashSet;

import LinkedList.MySinglyLinkedList.Node;

public class RemoveDuplicateLinkedList {

	public static Object removeDuplicateUsingSet(MySinglyLinkedList<Integer> list) {
		Object result = null;
		HashSet<Integer> set = new HashSet<Integer>();
		Node<Integer> current = list.getHeadNode();
		
		while(current != null) {
			if(!set.add(current.data)) {
				list.deleteByNode(current);
				break;
			}
			current = current.nextNode;
		}

		list.printList("Removed duplicate [" + current.data + "] using HashSet from list :");
		return result;
	}

	public static void main(String[] args) {
		MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
	
		list.insertAtHead(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(2);
		list.insertAtEnd(4);

		removeDuplicateUsingSet(list);

	}

}
