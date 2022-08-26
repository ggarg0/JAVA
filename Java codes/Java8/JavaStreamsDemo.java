package Java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaStreamsDemo {
	public static void main(String args[]) {

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("first", "1");
		map1.put("second", "2");
		map1.put("third", "3");
		map1.put("fourth", "4");
		map1.put("fifth", "5");

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		data.add(map1);
		System.out.println(data.size() + " and " + (data));
		data.stream().filter(map -> map.get("fifth") == null || map.get("fifth").equals("5")).forEach(map -> {
			String term = map.get("second").toString();
			System.out.println(term);

		});

	}
}
