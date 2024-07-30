package Collections;

import java.util.*;
import java.util.Map.Entry;
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

        System.out.println("map details: " + stockPrice);
        stockPrice.entrySet().stream()
                .filter(element -> element.getValue() < 50)
                .map(Entry::getKey)
                .collect(Collectors.toList()).forEach
                (stockPrice.keySet()::remove);

        System.out.println("Map after filter: " + stockPrice);


        Map<Object, Object> sorted = stockPrice.entrySet().stream().sorted(Entry.comparingByKey())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("map after sorting by key: " + sorted);

        sorted = stockPrice.entrySet().stream().sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("map after sorting by values: " + sorted);

        sorted = stockPrice.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("map after reverse sorting by values: " + sorted);

        List<String> expensiveStock = stockPrice.entrySet().stream()
                .filter(element -> element.getValue() > 400)
				.map(Map.Entry::getKey)
				.collect(Collectors.toCollection(ArrayList::new));

        expensiveStock.forEach(v -> System.out.println("Company : " + v));
        stockPrice.forEach((k, v) -> System.out.println(k + ":" + v));

        Map<String, Integer> expensiveStockMap = stockPrice.entrySet().stream()
                .filter(element -> element.getValue() > 400)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("expensive map : " + expensiveStockMap);
    }
}
