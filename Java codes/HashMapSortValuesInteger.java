import java.util.*;
import java.util.Map.Entry;

public class HashMapSortValuesInteger {
	public static void main(String a[]){
		//Map<String, Integer> map = new HashMap<String, Integer>();
		Map hashmap=new HashMap();

		map.put("java", 20);
		map.put("C++", 45);
		map.put("Dot Net", 2);
		map.put("LINUX", 93);

		Set set = map.entrySet();
		List list = new ArrayList(set);

		Collections.sort( list, new Comparator() {
			public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ) {
				return (o1.getValue()).compareTo( o2.getValue() );
				}
			}
		);
		System.out.println("Sort by values");
		for(Map.Entry<String, Integer> entry:list){
			System.out.println("Key : " + entry.getKey()+", " + " Value : "+entry.getValue());
			}
		}
	}
