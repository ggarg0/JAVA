package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSortValuesStrings {
	public static void main(String a[]){
		List o = new ArrayList();
		
		Map map = new HashMap();
		map.put("java", "a");
		map.put("C++", "y");
		map.put("Dot Net", "g");
		map.put("LINUX", "t");
		
		map.put("java", 1);
		map.put("C++", 7);
		map.put("Dot Net", 6);
		map.put("LINUX", 23);


		Set<Entry> set = map.entrySet();
		List<Entry> list = new ArrayList(set);

		Collections.sort( list, new Comparator<Map.Entry>() {
			public int compare( Map.Entry o1, Map.Entry o2 ) {
				return ((String) o1.getValue()).compareTo( (String) o2.getValue() );
				}
			}
		);

		for(Map.Entry entry:list){
			System.out.println(entry.getKey()+" ==== "+entry.getValue());
			}
		}
	}
