package Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        if (intervals.length < 1)
            return new int[][]{{newInterval[0], newInterval[1]}};

        List<int[]> result = new ArrayList<>();

        int elementCount = intervals.length;
        int counter = 0;

        while (counter < elementCount && intervals[counter][0] < newInterval[0]) {
            result.add(intervals[counter]);
            counter++;
        }

        if (result.isEmpty() || result.get(result.size() - 1)[1] < newInterval[0]) {
            result.add(newInterval);
        } else if (result.get(result.size() - 1)[1] >= newInterval[0]) {
            result.get(counter - 1)[1] = Math.max(newInterval[1], result.get(counter - 1)[1]);
        }

        while (counter < elementCount) {
            int[] currentInterval = result.get(result.size() - 1);
            if (currentInterval[1] >= intervals[counter][0]) {
                result.get(result.size() - 1)[1] = Math.max(intervals[counter][1], result.get(result.size() - 1)[1]);
            } else {
                result.add(intervals[counter]);
            }
            counter++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 5}, {9, 12}};
        int[] newInterval = {7, 16};
        System.out.println("Intervals to merge: " + Arrays.deepToString(intervals));
        int[][] result = insertInterval(intervals, newInterval);
        System.out.println("Merged intervals: " + Arrays.deepToString(result));
    }
}