package Arrays.MergeIntervals;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-task-scheduler

import java.util.*;

public class TaskScheduler {
    public static int leastTime(char[] tasks, int n) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char t : tasks) {
            frequencies.put(t, frequencies.getOrDefault(t, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(frequencies.entrySet());
        Collections.sort(sortedFrequencies, (lhs, rhs) -> lhs.getValue().compareTo(rhs.getValue()));

        int maxFreq = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
        sortedFrequencies.remove(sortedFrequencies.size() - 1);

        int idleTime = (maxFreq - 1) * n;

        while (!sortedFrequencies.isEmpty() && idleTime > 0) {
            idleTime -= Math.min(maxFreq - 1, sortedFrequencies.get(sortedFrequencies.size() - 1).getValue());
            sortedFrequencies.remove(sortedFrequencies.size() - 1);
        }
        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }

    public static void main(String[] args) {
        char[] tasks = {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'};
        int n = 3;
        System.out.println("Tasks: " + Arrays.toString(tasks));
        System.out.println("Minimum time required to execute the tasks: " + leastTime(tasks, n));

    }
}


