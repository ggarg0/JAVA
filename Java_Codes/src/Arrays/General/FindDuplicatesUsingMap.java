package Arrays.General;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FindDuplicatesUsingMap {

    public static void main(String[] args) {
        int[] arr = {7, 5, 4, 3, 11, 5, 11, 9, 3, 11};
        System.out.println("Array : " + Arrays.toString(arr) + " and duplicates found " + findDuplicates(arr).toString());
    }

    public static List<Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        System.out.println(map);

        System.out.println(map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Entry::getKey)
                .collect(Collectors.toList()));

        map.entrySet().stream()
                .filter(a -> a.getValue() <= 1)
                .map(Entry::getKey)
                .collect(Collectors.toList())
                .forEach(map.keySet()::remove);


        return map.entrySet().stream()
                .filter(a -> a.getValue() > 1)
                .map(Entry::getKey)
                .collect(Collectors.toList());
    }
}
