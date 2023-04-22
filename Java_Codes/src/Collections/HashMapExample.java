package Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();

		hashMap.put(12, "John");
		hashMap.put(16, "Jane");
		hashMap.put(18, "Jim");
		hashMap.put(17, "Jason");
		hashMap.put(11, "Jack");

		System.out.println("HashMap : " + hashMap);
		System.out.println("Value with key 16 : " + hashMap.get(16));
		hashMap.remove(11);
		System.out.println("HashMap after removing key 11 : " + hashMap);
		System.out.println("Map contains key 18 : " + hashMap.containsKey(18));
		System.out.println(hashMap.size());

		System.out.println();
		System.out.println("Using iterator");
		Set<Integer> set = hashMap.keySet();
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			System.out.print(key + "=" + hashMap.get(key) + ", ");
		}
		
		System.out.println("Using entry set");
		for (Entry<Integer, String> e : hashMap.entrySet())
			System.out.print(e.getKey() + "=" + e.getValue() + ", ");
	}
}
