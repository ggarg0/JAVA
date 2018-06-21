import java.util.ArrayList;
import java.util.List;

class LinkedListImplementation {
	// Class variables for the Linked List
	private static Node head;
	private static int numNodes;

	public static void main(String[] args) {
		
		LinkedListImplementation list = new LinkedListImplementation();
		
		list.add(10);
		list.add(11);
		list.add(17);
		list.add(16);
		list.addAtHead(12);
		list.deleteFromMiddle();
		list.addAtTail(8);
		list.addAtIndex(4, 9);
		list.deleteAtIndex(3);
		list.reverse();
		
		System.out.println("Size : " + getSize());
		System.out.println("Find by index : " + list.findByIndex(2).data);
	}

    public void reverse() {
    	Node temp = head;
        Node prev = null;
        Node next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
        printListDetails(head);
    }
	
	public void add(Object data) {
		if (head == null) {
			head = new Node(data);
			numNodes++;
			printListDetails(head);
			return;
		}

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = new Node(data);
		numNodes++;
		printListDetails(head);
	}

	public void addAtHead(Object dat) {
		Node temp = head;
		head = new Node(dat);
		head.next = temp;
		numNodes++;
		printListDetails(head);
	}

	public void addAtTail(Object dat) {
		Node temp = head;
		
		while (temp.next != null) 
			temp = temp.next;		

		temp.next = new Node(dat);
		numNodes++;
		printListDetails(head);
	}

	public void addAtIndex(int index, Object dat) {
		Node temp = head;
		Node holder;
		
		for (int i = 0; i < index - 1 && temp.next != null; i++) 
			temp = temp.next;
		
		holder = temp.next;
		temp.next = new Node(dat);
		temp.next.next = holder;
		numNodes++;
		printListDetails(head);
	}

	public void deleteAtIndex(int index) {
		Node temp = head;
		
		for (int i = 0; i < index - 1 && temp.next != null; i++) 
			temp = temp.next;
		
		temp.next = temp.next.next;
		numNodes--;
		printListDetails(head);
	}

	public void deleteFromMiddle() {
		int index = getSize() / 2;
		System.out.println("Middle of List : " + index);
		deleteAtIndex(index);
	}

	public int findByNode(Node n) {
		Node temp = head;
		int index = 0;
		while (temp != n) {
			index++;
			temp = temp.next;
		}
		return index;
	}

	public static Node findByIndex(int index) {
		Node temp = head;
		
		for (int i = 0; i < index; i++) 
			temp = temp.next;
		
		return temp;
	}
	
	public void printListDetails(Node node) {
		Node temp = node;
	        while (temp != null) {
	            System.out.print(temp.data + " ");
	            temp = temp.next;
	        }
	        System.out.println();
	    }


	public static int getSize() {
		return numNodes;
	}

	class Node {

		private Node next;
		private Object data;

		public Node(Object dat) {
			data = dat;
		}

		public Object getData() {
			return data;
		}
	}
}