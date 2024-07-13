package Collections;

import java.util.*;
import java.util.Collection;

public class TracePath {

    public static List<List<String>> tracePath(Map<String, String> cities) {
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
        List<List<String>> result = new ArrayList<>();
        if (start.isEmpty()) return null;

        while (cities.get(start) != null && start != null) {
            result.add(Arrays.asList(start, cities.get(start)));
            start = cities.get(start);
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
