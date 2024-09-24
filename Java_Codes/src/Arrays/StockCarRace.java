package Arrays;

import java.util.*;

public class StockCarRace {
    public static List<String> solution(String[][] laps) {
        Map<String, Integer> bestTimes = new HashMap<>();
        List<String> eliminationOrder = new ArrayList<>();

        for (String[] lap : laps) {
            for (String entry : lap) {
                String[] parts = entry.split(" ");
                String name = parts[0];
                int time = Integer.parseInt(parts[1]);
                if (!eliminationOrder.contains(name)) {
                    bestTimes.put(name, Math.min(bestTimes.getOrDefault(name, Integer.MAX_VALUE), time));
                }
            }

            if(bestTimes.isEmpty())
                continue;
            // Find the slowest best time
            int slowestTime = Collections.max(bestTimes.values());
            List<String> slowestDrivers = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : bestTimes.entrySet()) {
                if (entry.getValue() == slowestTime) {
                    slowestDrivers.add(entry.getKey());
                }
            }

            // Sort the slowest drivers alphabetically
            Collections.sort(slowestDrivers);
            eliminationOrder.addAll(slowestDrivers);

            // Remove the eliminated drivers from the best times map
            for (String driver : slowestDrivers) {
                bestTimes.remove(driver);
            }
        }
        return eliminationOrder;
    }

    public static void main(String[] args) {
        String[][] laps = {
                {"Harold 154", "Gina 155", "Juan 160"},
                {"Juan 152", "Gina 153", "Harold 160"},
                {"Harold 148", "Gina 150", "Juan 151"}
        };

        String[][] laps1 = {
                {"Gina 155", "Eddie 160", "Joy 161", "Harold 163"},
                {"Harold 151", "Gina 153",  "Joy 160", "Eddie 160"},
                {"Harold 149", "Joy 150", "Gina 152", "Eddie 154"},
                {"Harold 148", "Gina 150", "Eddie 151", "Joy 155"}
        };

        List<String> result = solution(laps1);
        System.out.println(result);  // Output: [Juan, Harold, Gina]
    }
}