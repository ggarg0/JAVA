package Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length < 1)
            return new int[][]{};

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] interval = intervals[0];
        result.add(interval);
        for (int[] currentInterval : intervals) {
            if (currentInterval[0] <= interval[1])
                interval[1] = Math.max(interval[1], currentInterval[1]);
            else {
                interval = currentInterval;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        System.out.println("Intervals to merge: " + Arrays.deepToString(intervals));
        int[][] result = mergeIntervals(intervals);
        System.out.println("Merged intervals: " + Arrays.deepToString(result));
    }
}
