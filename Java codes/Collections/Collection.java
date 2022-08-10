package Collections;

import java.util.*;
import java.util.Collections;

public class Collection {
	public static void main(String[] args) {
		try {
			final String[] a = { "gaurav", "garg", "vineet", "mahendra" };
			List list = Arrays.asList(a);
			List sublist = Arrays.asList("vineet");
			List searchList = Arrays.asList("mahendra");
			System.out.println("Elements in list : " + list);
			System.out.println("Elements in sublist : " + sublist);
			System.out.println("Elements in searchList : " + searchList);

			list.set(2, "garg");
			System.out.println("Elements in list set : " + list);
			Collections.copy(list, sublist);
			Collections.copy(list, sublist);
			System.out.println("copy of sublist : " + sublist + "and list " + list);

			// find and display maximum and minimum object value from list.
			System.out.println("object of max value : " + Collections.max(list));
			System.out.println("object of min value : " + Collections.min(list));

			// find and display index of first occurance of sublist in the list.
			System.out.println("First index of 'mahendra': " + Collections.indexOfSubList(list, searchList));

			// find and display index of last occurance of sublist in the list.
			System.out.println("Last index of 'mahendra': " + Collections.lastIndexOfSubList(list, searchList));

			// replace all objects in list by a new given object.
			Collections.replaceAll(list, "mahendra", "gaurav");
			System.out.println("After replace all 'gaurav': " + list);

			// list in reverse order.
			Collections.reverse(list);
			System.out.println("List in reverse order: " + list);

			// rotate the given number of objects in list,here 4
			Collections.rotate(list, 3);
			System.out.println("After rotation : " + list);

			// find size of the list
			System.out.println("Size of the list : " + list.size());

			/*
			 * Swap element in list. here swap specified element with element at 0th(first)
			 * position
			 */
			Collections.swap(list, 0, list.size() - 1);
			System.out.println("List after swapping : " + list);

			// Replace all the element with given element using fill()
			Collections.fill(list, "mahendra");
			System.out.println("After filling all 'mahendra' in list : " + list);

			/*
			 * ncopies() returns immutable list consisting of copies of the specified
			 * object.
			 */
			List raviList = Collections.nCopies(2, sublist);
			System.out.println("List created by ncopy() " + raviList);
			Collections.reverse(sublist);
			System.out.println("raviList in reverse order: " + raviList);
		} catch (Exception e) {
		}
	}
}