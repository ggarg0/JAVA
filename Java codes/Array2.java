import java.util.*;

class Array2
{
	public static void main(String arg[])
	{
		Integer[] array1 ={1,2,3,4,5,6,7,8,9,5};
		Integer[] array2 ={3,1,2,4,5,6,7,8};
		List list1 = Arrays.asList(array1);
		List list2 = Arrays.asList(array2);

		Arrays.sort(array1);
		List list3 = Arrays.asList(array1);
		Iterator  iterator = list3.iterator();
		while (iterator.hasNext()){
			Integer o= (Integer) iterator.next();
		  System.out.println("List : " + o);
		}
		Set<Integer> set1 = new HashSet<Integer>(list1);
		set1.removeAll(list2);
		iterator = set1.iterator();
		while (iterator.hasNext()){
			Integer o= (Integer) iterator.next();
		  System.out.println("Missing : " + o);
		}
 	}
}