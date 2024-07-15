package LinkedList;

import java.util.HashSet;

import LinkedList.MySinglyLinkedList.Node;

public class DetectLoopInLinkedList {

    public static boolean detectLoopUsingTwoPointers(MySinglyLinkedList<Integer> list) {
        boolean result = false;
        Node<Integer> current = list.getHeadNode();
        Node<Integer> next = list.getHeadNode();

        while (current != null && next != null && next.nextNode != null) {
            current = current.nextNode;
            next = next.nextNode.nextNode;

            if (current == next) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean detectCycleUsingTwoPointers(MySinglyLinkedList<Integer> list) {
        if (list.getHeadNode() == null || list.getHeadNode().nextNode == null) {
            return false;
        }
        Node<Integer> current = list.getHeadNode();
        Node<Integer> next = list.getHeadNode().nextNode;
        while (current != next) {
            if (current.nextNode == null || next.nextNode.nextNode == null) {
                return false;
            }
            current = current.nextNode;
            next = next.nextNode.nextNode;
        }
        return true;
    }


    public static boolean detectLoopUsingSet(MySinglyLinkedList<Integer> list) {
        boolean result = false;
        HashSet<Node<Integer>> set = new HashSet<Node<Integer>>();
        Node<Integer> node = list.getHeadNode();

        while (node != null) {
            if (set.contains(node)) {
                result = true;
                break;
            }
            set.add(node);
            node = node.nextNode;
        }
        return result;
    }

    public static void main(String[] args) {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
        list.length();
        list.insertAtHead(7);
        list.insertAtHead(14);
        list.insertAtHead(21);
        list.getHeadNode().nextNode.nextNode = list.getHeadNode();

        System.out.println("Detect loop using two pointers : " + detectLoopUsingTwoPointers(list));
        System.out.println("Detect loop using HashSet : " + detectLoopUsingSet(list));
        System.out.println("Detect cycle using two pointers : " + detectCycleUsingTwoPointers(list));
    }
}
