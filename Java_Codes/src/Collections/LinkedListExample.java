package Collections;

import java.util.*;

public class LinkedListExample {
	public static void main(String args[]) {

		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add("Item1");
		linkedlist.add("Item5");
		linkedlist.add("Item3");
		linkedlist.add("Item6");
		linkedlist.add("Item2");
		System.out.println("Linked List Content: " + linkedlist);

		linkedlist.addFirst("First Item");
		linkedlist.addLast("Last Item");
		System.out.println("LinkedList Content after update: " + linkedlist);

		System.out.println("First element: " +  linkedlist.get(0));
		linkedlist.set(0, "Changed first item");
		System.out.println("LinkedList Content after update by set method: " + linkedlist);

		linkedlist.removeFirst();
		linkedlist.removeLast();
		System.out.println("LinkedList after deletion of first and last element: " + linkedlist);

		linkedlist.add(0, "Newly added item");
		linkedlist.remove(2);
		System.out.println("Final Content: " + linkedlist);
		System.out.println("List contains : " + linkedlist.contains("Item5"));
		System.out.println("List Size : " + linkedlist.size());
		linkedlist.clear();
		System.out.println("List Size after clear(): " + linkedlist.size());
		System.out.println("List Size : " + linkedlist.isEmpty());
	}
}