package Arrays.General;

import java.util.*;

public class NumberOccurrence {
    public static void main(String[] args) {
        Integer[] a = {3, 4, 4, 4, 4, 2, 3, 3, 2, 1, 1};

        //Approach 1
        Map<Integer, Integer> freq = new HashMap<>();
        int result = 0;
        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (Objects.equals(e.getKey(), e.getValue())) {
                result = Math.max(result, e.getKey());
            }
        }
        System.out.println(result);

        //Approach 2
        int result1 = 0;
        List<Integer> list = Arrays.asList(a);
        Set<Integer> uniqueValues = new HashSet<>(list);
        // Count and print frequency of each unique number
        for (Integer num : uniqueValues) {
            int count = Collections.frequency(list, num);
            System.out.println("Number " + num + " occurs " + count + " times.");
        }


    }
}
