package LinkedList;

//https://leetcode.com/problems/reorder-list/description/?envType=problem-list-v2&envId=5ju0l817

import LinkedList.MySinglyLinkedList.Node;

public class ReorderList {

    public void reorderList(Node<Integer> head) {
        Node<Integer> mid = findMid(head);
        Node<Integer> midReversed = reverse(mid, null);
        reorder(head, mid, midReversed);

    }

    private Node<Integer> findMid(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        return slow;
    }

    private Node<Integer> reverse(Node<Integer> head, Node<Integer> prev) {
        if (head == null) {
            return head;
        }

        if (head.nextNode == null) {
            head.nextNode = prev;
            return head;
        }

        Node<Integer> next = head.nextNode;
        head.nextNode = prev;
        return reverse(next, head);
    }

    private void reorder(Node<Integer> left, Node<Integer> midPoint, Node<Integer> right) {
        while (left != null && right != null && right != midPoint) {
            Node<Integer> leftNext = left.nextNode;
            Node<Integer> rightNext = right.nextNode;
            left.nextNode = right;
            right.nextNode = leftNext;
            left = leftNext;
            right = rightNext;
        }
    }

    public static void main(String[] args) {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
        list.length();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.printList("List input : ");
        new ReorderList().reorderList(list.getHeadNode());
        list.printList("Reordered list : ");
    }
}
