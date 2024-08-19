package Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindOverlappingIntervals {
    public static int[][] findOverlappingIntervals(int[][] intervals) {

        if (intervals.length < 1)
            return new int[][]{};

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        System.out.println("Intervals : " + Arrays.deepToString(intervals));
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {

                if (!result.contains(intervals[i]))
                    result.add(intervals[i]);

                if (!result.contains(intervals[i + 1]))
                    result.add(intervals[i + 1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}, {17, 20}};
        System.out.println("Intervals to merge: " + Arrays.deepToString(intervals));
        int[][] result = findOverlappingIntervals(intervals);
        System.out.println("Overlapping intervals: " + Arrays.deepToString(result));
    }
}