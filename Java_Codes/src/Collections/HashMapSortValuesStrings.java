package Collections;

import java.util.*;
import java.util.Map.Entry;

public class HashMapSortValuesStrings {
	public static void main(String a[]){
		Map<String, String> map = new HashMap<String, String>();
		map.put("java", "a");
		map.put("C++", "y");
		map.put("Dot Net", "g");
		map.put("LINUX", "t");

		Set<Entry<String, String>> set = map.entrySet();
		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(set);

		Collections.sort( list, new Comparator<Map.Entry<String, String>>() {
			public int compare( Map.Entry<String, String> o1, Map.Entry<String, String> o2 ) {
				return (o1.getValue()).compareTo( o2.getValue() );
				}
			}
		);

		for(Map.Entry<String, String> entry:list){
			System.out.println(entry.getKey()+" ==== "+entry.getValue());
			}
		}
	}
