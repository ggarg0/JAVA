import java.util.*;

public class ArrayListDemo {
	public static void main(String[] args) {
		try {
			List arraylist = new ArrayList();
			for (int i = 0; i < 5; i++) {
				arraylist.add(new Integer(i));
			}
			arraylist.add("jack");
			System.out.println("Size now =" + arraylist.size());
			System.out.println("6 now =" + arraylist.get(5));
			arraylist.remove(5);
			System.out.println("Size now =" + arraylist.size());
			Integer num = null;
			for (int i = 0; i < arraylist.size(); i++) {
				System.out.println(arraylist.get(i));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
