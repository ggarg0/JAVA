package Collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TracePath {

	public static String tracePath(Map<String, String> cities) {
		String result = "";
		Set<String> departure = cities.keySet();
		Collection<String> arrival = cities.values();

		Iterator<String> itr = departure.iterator();
		String start = "";
		while (itr.hasNext()) {
			String from = itr.next();
			if (!arrival.contains(from)) {
				start = from;
				break;
			}
		}

		if (start.isEmpty())
			return "Wrong iternary";

		String to = cities.get(start);

		while (to != null) {
			result += "(" + start + "->" + to + ") ";
			start = to;
			to = cities.get(start);
		}

		return result;
	}

	public static void main(String[] args) {
		Map<String, String> cities = new HashMap<String, String>();
		cities.put("NewYork", "Chicago");
		cities.put("Boston", "Texas");
		cities.put("Missouri", "NewYork");
		cities.put("Texas", "Missouri");

		System.out.println(tracePath(cities));
	}

}
