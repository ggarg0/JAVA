package LinkedList;

import LinkedList.MyDoublyLinkedListWithTail.Node;

public class PalindromeChallenge {

	public static <T> boolean isPalindrome(MyDoublyLinkedListWithTail<T> list) {
		Node<T> start = list.head;
		Node<T> end = list.tail;

		if (start == null) {
			return true;
		}
		while (start != null) {
			if (start.data != end.data) {
				return false;
			}
			start = start.next;
			end = end.previous;
		}
		return true;
	}

	public static void main(String[] args) {
		MyDoublyLinkedListWithTail<Integer> list = new MyDoublyLinkedListWithTail<Integer>();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(2);
		list.insertAtEnd(1);
		System.out.println("Is palindrome?  " + isPalindrome(list));
	}
}
