import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class HashMapDemo {
	public static void main(String args[]) {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 213);
		stockPrice.put("Google", 421);
		stockPrice.put("Ford", 456);
		stockPrice.put("Novartis", 43);
		stockPrice.put("TCS", 23);

		Set keys = stockPrice.keySet();
		Iterator itr = keys.iterator();

		while (itr.hasNext()) {
			String key = (String) itr.next();

			if (stockPrice.get(key) < 50)
				itr.remove();

		}
		stockPrice.forEach((k, v) -> System.out.println("Company Name: " + k + " Stock Price: " + v));

		System.out.println("map before sorting: " + stockPrice);
		
		Map<Object, Object> sorted = stockPrice.entrySet().stream().sorted(Entry.comparingByKey())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println("map after sorting by key: " + sorted);

		sorted = stockPrice.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println("map after sorting by values: " + sorted);

		sorted = stockPrice.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println("map after reverse sorting by values: " + sorted);

	}
}
