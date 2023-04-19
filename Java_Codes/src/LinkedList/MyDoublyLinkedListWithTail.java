package LinkedList;

public class MyDoublyLinkedListWithTail<T> {

	public static class Node<T> {
		T data;
		Node<T> next;
		Node<T> previous;
	}

	Node<T> head;
	Node<T> tail;
	int size;

	public MyDoublyLinkedListWithTail() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	public void printList() {
		printList("List :");
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

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public void insertAtHead(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = head;
		node.previous = null;
		if (head != null) {
			head.previous = node;
		} else
			tail = node;
		head = node;
		size++;
		printList("Insert At Head (" + data + ") :");
	}

	public void insertAtEnd(T data) {
		if (isEmpty()) {
			insertAtHead(data);
			return;
		}
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;
		node.previous = tail;
		tail.next = node;
		tail = node;
		size++;
		printList("Insert At End (" + data + ") :");
	}

	public void deleteAtEnd() {
		if (isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}

		tail = tail.previous;
		if (tail == null)
			head = null;
		else
			head.next = null;

		size--;
		printList("Delete at end :");
	}

	public static void main(String[] args) {
		MyDoublyLinkedListWithTail<Integer> list = new MyDoublyLinkedListWithTail<Integer>();
		list.insertAtHead(5);
		list.insertAtHead(2);
		list.insertAtEnd(7);
		list.insertAtEnd(2);
		list.deleteAtEnd();
		list.insertAtEnd(7);
		list.insertAtEnd(2);
	}
}
