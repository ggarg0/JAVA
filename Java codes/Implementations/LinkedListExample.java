package com.test;

import java.util.*;

public class LinkedListExample {
	public static void main(String args[]) {

		List<String> list = createList();
		System.out.println("List : " + list);
		findDuplicateUsingCounter(list);
		findDuplicatesUsingSet(list);
	}

	public static void findDuplicateUsingCounter(List<String> list) {
		List<String> duplicateList = new ArrayList<String>();
		Collections.sort(list);
		int counter = 1;
		System.out.println("Sorted List : " + list);

		for (int i = counter; i < list.size(); i++) {
			if ((list.get(counter - 1).equalsIgnoreCase((list.get(counter))))) {
				duplicateList.add(list.get(counter));
			}
			counter++;
		}
		System.out.println("Duplicate using findDuplicateUsingCounter: " + duplicateList);
	}

	public static void findDuplicatesUsingSet(List<String> list) {
		 
		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();
 
		for (int i=0; i < list.size(); i++) {
			if (!set1.add(list.get(i))) {
				setToReturn.add(list.get(i));
			}
		}
		System.out.println("Duplicate using findDuplicatesUsingSet: " + setToReturn);
	}
	public static List<String> createList() {
		List<String> list = new LinkedList<String>();
		int noOfItems = 5;
		for (int i = 0; i < noOfItems; i++)
			list.add("item" + i);

		list.add("item" + 2);
		list.add("item" + 4);
		return list;
	}
}