package Collections;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	public static void main(String[] args) {
		Set<String> hashset = new HashSet<String>();
		hashset.add("jack");
		hashset.add("tom");
		hashset.add("2");
		hashset.add("jerry");
		hashset.add("Jerry");

		Iterator<String> iterator = hashset.iterator();
		while (iterator.hasNext()) {
			String o = (String) iterator.next();
			System.out.println("Old : " + o);
			if (o.equals("Jerry")) {
				iterator.remove();
				// break;
			}
		}
		iterator = hashset.iterator();
		while (iterator.hasNext()) {
			String o = (String) iterator.next();
			System.out.println("New : " + o);
		}
	}
}


