import java.util.*;

public class ListIteratorDemo {
	public static void main(String[] args)	{
		List<String> names = new LinkedList<>();
		names.add("ADD");
		names.add("SUB");
		names.add("MUL");
		names.add("DIV");

		ListIterator<String> listIterator = names.listIterator();
		// Traversing elements
		System.out.println("Forward Direction Iteration:");
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
		// Traversing elements
		System.out.println("Backward Direction Iteration:");
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
		}
	}
}