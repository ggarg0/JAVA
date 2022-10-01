package Collections;

import java.util.*;
import java.util.Map.Entry;

public class HashMapSortValuesInteger {
	public static void main(String a[]){
		//Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> map=new HashMap<String, Integer>();

		map.put("java", 20);
		map.put("C++", 45);
		map.put("Dot Net", 2);
		map.put("LINUX", 93);

		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

		Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ) {
				return (o1.getValue()).compareTo( o2.getValue() );
				}
			}
		);

		for(Map.Entry<String, Integer> entry:list){
			System.out.println(entry.getKey()+" ==== "+entry.getValue());
			}
		}
	}
