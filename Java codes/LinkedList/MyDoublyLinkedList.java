package LinkedList;

public class MyDoublyLinkedList<T> {

	public static class Node<T> {
		T data;
		Node<T> next;
		Node<T> previous;
	}

	int size;
	Node<T> head;

	public MyDoublyLinkedList() {
		this.size = 0;
		this.head = null;
	}

	public void printList() {
		printList("List :");
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public void printList(String operation) {
		if (isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}

		Node<T> current = head;
		System.out.print(operation + " null <-");
		while (current != null) {
			System.out.print(" |" + current.data + "| <->");
			current = current.next;
		}
		System.out.println(" null");
	}

	public void insertAtHead(T data) {
		Node<T> temp = new Node<T>();
		temp.data = data;
		temp.next = head;
		temp.previous = null;

		if (head != null)
			head.previous = temp;

		head = temp;
		size++;
		printList("Insert At Head (" + data + ") :");
	}

	public void insertAtEnd(T data) {
		if (isEmpty()) {
			insertAtHead(data);
			return;
		}

		Node<T> temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;
		node.previous = temp;

		temp.next = node;
		size++;
		printList("Insert At End (" + data + ") :");
	}

	public void insertAfter(T data, T previous) {
		if (isEmpty()) {
			insertAtHead(data);
			return;
		}

		Node<T> current = head;
		while (current != null) {
			if (current.data == previous) {
				Node<T> newNode = new Node<T>();
				newNode.data = data;
				newNode.previous = current;
				newNode.next = current.next;
				if (current.next != null)
					current.next.previous = newNode;
				current.next = newNode;
				break;
			}
			current = current.next;
		}

		if (current == null) {
			insertAtEnd(data);
			return;
		}
		size++;
		printList("Insert after (" + previous + ") value (" + data + ") :");

	}

	public boolean searchNode(T data) {
		boolean result = false;
		Node<T> current = head;

		while (current != null && !result) {
			if (current.data == data) {
				result = true;
			}
			current = current.next;
		}
		System.out.println("Search list for (" + data + ") : " + result);
		return result;
	}

	public void deleteAtHead() {
		if (isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}

		Node<T> temp = head.next;
		temp.previous = null;
		head = temp;
		size--;
		printList("Delete at head :");
	}

	public void deleteAtEnd() {
		if (isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}

		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.previous.next = null;
		size--;
		printList("Delete at end :");
	}

	public void deleteByValue(T data) {
		if (isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}

		Node<T> current = head;

		if (current.data == data) {
			deleteAtHead();
			return;
		}

		while (current != null) {
			if (current.data == data) {
				current.previous.next = current.next;
				current.next.previous = current.previous;
				break;
			}
			current = current.next;
		}
		size--;
		printList("Delete value (" + data + ") from list :");
	}

	public void deleteByNode(Node<T> node) {

	}

	public static void main(String[] args) {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<Integer>();
		list.insertAfter(22, 1);
		list.insertAtHead(5);
		list.insertAtHead(2);
		list.insertAtEnd(7);
		list.insertAfter(2, 7);
		list.insertAtHead(4);
		list.insertAfter(12, 11);
		list.searchNode(7);
		list.deleteAtHead();
		list.deleteAtEnd();
		list.insertAtEnd(2);
		list.deleteByValue(2);
		list.deleteByValue(22);
	}
}
