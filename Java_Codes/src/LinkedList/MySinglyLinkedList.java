package LinkedList;

import java.util.Objects;

public class MySinglyLinkedList<V> {

    public static class Node<V> {
        public V data;
        public Node<V> nextNode;
    }

    private int size;
    private Node<V> headNode;

    public MySinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    public int size() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return 0;
        }
        System.out.println("Size of list is [" + size + "]");
        return size;
    }

    public Node<V> getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node<V> head) {
        headNode = head;
    }

    public boolean isEmpty() {
        return Objects.isNull(headNode);
    }

    public int length() {
        int count = 0;
        if (isEmpty()) {
            System.out.println("List is empty");
            return 0;
        }

        Node<V> currentNode = headNode;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.nextNode;
        }
        System.out.println("Length of list is [" + count + "]");
        return count;
    }

    public void printList() {
        printList("List :");
    }

    public void printList(String operation) {
        if (isEmpty()) {
            System.out.println("List is empty");
        }

        System.out.print(operation);
        Node<V> currentNode = headNode;
        while (currentNode != null) {
            System.out.print(" |" + currentNode.data + "| ->");
            currentNode = currentNode.nextNode;
        }
        System.out.println(" null");
    }

    public void insertAtHead(V data) {
        Node<V> currentNode = new Node<V>();
        currentNode.data = data;
        currentNode.nextNode = headNode;
        headNode = currentNode;
        size++;
        printList("Insert At Head (" + data + ") :");
    }

    public void insertAtEnd(V data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node<V> newNode = new Node<V>();
        newNode.data = data;
        newNode.nextNode = null;

        Node<V> lastNode = headNode;

        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }
        lastNode.nextNode = newNode;
        size++;
        printList("Insert At End (" + data + ") :");
    }

    public void insertAfter(V data, V previous) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node<V> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data.equals(previous)) {
                Node<V> newNode = new Node<V>();
                newNode.data = data;
                newNode.nextNode = currentNode.nextNode;
                currentNode.nextNode = newNode;
                size++;
                break;
            }
            currentNode = currentNode.nextNode;
        }

        if (currentNode == null) {
            insertAtEnd(data);
            return;
        }

        printList("Insert after (" + previous + ") value (" + data + ") :");
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        headNode = headNode.nextNode;
        size--;
        printList("Delete at head :");
    }

    public void deleteByValue(V data) {
        while (searchNode(data)) {
            Node<V> deleteNode = getHeadNode();
            Node<V> prevNode = new Node<V>();

			if (deleteNode.data.equals(data)) {
                deleteAtHead();
                return;
            }

            while (deleteNode != null) {
                if (deleteNode.data.equals(data)) {
                    prevNode.nextNode = deleteNode.nextNode;
                    break;
                }
                prevNode = deleteNode;
                deleteNode = deleteNode.nextNode;
            }
            size--;
            printList("Delete value (" + data + ") from list :");
        }
    }

    public void deleteByNode(Node<V> node) {
        Node<V> deleteNode = headNode;
        Node<V> prevNode = null;

        if (deleteNode == node) {
            deleteAtHead();
            return;
        }

        while (deleteNode != null) {
            if (deleteNode == node) {
                prevNode.nextNode = deleteNode.nextNode;
                break;
            }
            prevNode = deleteNode;
            deleteNode = deleteNode.nextNode;
        }
        size--;
        printList("Delete node (" + node.data + ") from list :");
    }

    public boolean searchNode(V data) {
        boolean result = false;
        if (isEmpty()) {
            System.out.println("List is Empty");
            return false;
        }
        Node<V> currentNode = getHeadNode();
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                result = true;
                break;
            }
            currentNode = currentNode.nextNode;
        }
        System.out.println("Search list for (" + data + ") : " + result);
        return result;
    }

    public void reverse(MySinglyLinkedList<V> list) {
        Node<V> previous = null;
        Node<V> current = getHeadNode();
        Node<V> next = null;

        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        list.headNode = previous;
        printList("Reversed list :");
    }

    public Node<V> findMiddleElement() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return null;
        }

        Node<V> temp = getHeadNode();
        Node<V> mid = getHeadNode();

        while (temp != null && temp.nextNode != null) {
            temp = temp.nextNode.nextNode;
            if (temp != null)
                mid = mid.nextNode;
        }
        System.out.println("Middle node is : " + mid.data);
        return mid;
    }

    public static void main(String args[]) {
        MySinglyLinkedList<Object> list = new MySinglyLinkedList<Object>();

        list.length();
        list.size();
        list.insertAtHead(1);
        list.insertAtHead("One");
        list.insertAtHead(true);
        list.deleteByValue(1);
        list.insertAtHead(new String());
        list.deleteAtHead();
        list.insertAtHead(9);
        list.searchNode(11);
        list.insertAtEnd(11);
        list.findMiddleElement();
        list.searchNode(11);
        list.insertAfter(99, 9);
        list.insertAtEnd("Eleven");
        list.findMiddleElement();
        list.length();
        list.size();
        list.deleteAtHead();
        list.findMiddleElement();
        list.deleteByValue(99);
        list.reverse(list);
		list.insertAtEnd(11);
		list.deleteByValue(11);
		list.printList();
    }

}
