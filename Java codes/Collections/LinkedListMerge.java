package Collections;

import java.util.*;

class LinkedListMerge{
	public static void main(String arg[])	{
		List list1 = new LinkedList();
		List list2 = new LinkedList();

		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(7);

		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);

		System.out.println("Sorted List : " + list1);
		System.out.println("Sorted List : " + list2);

		List list3 = new LinkedList();
		list3.addAll(list1);
		list3.addAll(list2);
		Set<Integer> set = new HashSet<Integer>(list3);
		Collections.sort(list3);
		System.out.println("Merge List : " + list3);
 	}
}