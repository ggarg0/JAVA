import java.util.*;

public class ArrayListDemo {
	public static void main(String[] args) {
		try {

			List arraylist = new ArrayList();
			for (int i = 0; i < 5; i++) {
				arraylist.add(new Integer(i));
			}

			System.out.println("Size now =" + arraylist.size());
			arraylist.add(4, "jack");

			for (int i = 0; i < arraylist.size(); i++) {
				System.out.print(arraylist.get(i) + ", ");
			}
			System.out.println();
			System.out.println("Size after adding =" + arraylist.size());
			System.out.println("Element at index 5 =" + arraylist.get(5));

			arraylist.remove(4);
			System.out.println("Size after removing =" + arraylist.size());
			for (int i = 0; i < arraylist.size(); i++) {
				System.out.print(arraylist.get(i) + ", ");
			}
			System.out.println();
			System.out.println("Remove from list");

			List remove = new ArrayList();
			remove.add(2);
			remove.add(3);

			arraylist.removeAll(remove);
			for (int i = 0; i < arraylist.size(); i++) {
				System.out.print(arraylist.get(i) + ", ");
			}
			System.out.println();
			System.out.println("Add from list");

			arraylist.addAll(1, remove);
			for (int i = 0; i < arraylist.size(); i++) {
				System.out.print(arraylist.get(i) + ", ");
			}
			System.out.println();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
