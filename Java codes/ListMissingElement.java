import java.util.*;

class ListMissingElement{
	public static void main(String arg[])	{
		Integer[] array1 = { 3, 7, 2, 90, 34, 67 };
		Integer[] array2 = { 2, 7, 34, 3, 67};

		// Using XOR
		Integer xor = 0;

		for (int i = 0; i < array1.length; i++) {
			xor ^= array1[i];
		}
		for (int i = 0; i < array2.length; i++) {
			xor ^= array2[i];
		}
		System.out.println("Missing Number using xor : " + xor);

		//Using collections
		List list1 = Arrays.asList(array1);
		List list2 = Arrays.asList(array2);

		Arrays.sort(array1);
		List list3 = Arrays.asList(array1);
		System.out.println("Sorted List : " + list3);

		Set<Integer> set = new HashSet<Integer>(list1);
		set.removeAll(list2);
		System.out.println("Missing Number using set : " + set);
 	}
}