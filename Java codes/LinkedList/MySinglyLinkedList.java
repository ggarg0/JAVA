package LinkedList;

public class MySinglyLinkedList<V> {

	public class Node<V> {
		public V data;
		public Node<V> nextNode;

	}

	public Node<V> headNode;
	public int size;

	public MySinglyLinkedList() {
		headNode = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (headNode == null ? true : false);
	}

	public void insertAtHead(V data) {
		Node<V> newNode = new Node<V>();
		newNode.data = data;
		newNode.nextNode = headNode;
		headNode = newNode;
		size++;
		printList("Insert At Head (" + data + ") : ");
	}

	public void insertAtEnd(V data) {
		if (isEmpty()) {
			insertAtHead(data);
			return;
		}

		Node<V> newNode = new Node<V>();
		newNode.data = data;
		newNode.nextNode = null;

		Node<V> last = headNode;
		while (last.nextNode != null) {
			last = last.nextNode;
		}
		
		last.nextNode = newNode;
		size++;
		printList("Insert At End (" + data + ") : ");
	}

	public int length() {
		int counter = 0;
		if (!isEmpty()) {
			Node<V> newNode = new Node<V>();
			newNode.nextNode = headNode;

			while (newNode.nextNode != null) {
				newNode = newNode.nextNode;
				counter++;
			}
		}
		printList("Length of list is [" + counter + "] : ");
		return counter;
	}
	
	public boolean searchNode(V data) {
		boolean result = false;
		if (isEmpty()) {
			System.out.println("List is Empty");
			return result;
		}
		
		Node<V> current = headNode;
		while(current != null) {
			if(current.data.equals(data)) {
				result = true;
				break;
			}
			current = current.nextNode;
		}
		System.out.println("Search list for (" + data + ") : " + result);
		return result;
	}

	public void printList(String opertaion) {
		if (isEmpty()) {
			System.out.println("List is Empty");
			return;
		}

		Node<V> nextNode = headNode;
		System.out.print(opertaion);
		while (nextNode != null) {
			System.out.print("|" + nextNode.data.toString() + "| ");
			nextNode = nextNode.nextNode;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		MySinglyLinkedList<Object> list = new MySinglyLinkedList<Object>();
		list.length();
		list.insertAtHead(1);
		list.insertAtHead("One");
		list.insertAtHead(true);
		list.insertAtHead(new String());		
		list.insertAtHead(9);		
		list.searchNode(11);
		list.insertAtEnd(11);
		list.searchNode(11);		
		list.insertAtEnd("Eleven");
		list.length();		
	}

}
