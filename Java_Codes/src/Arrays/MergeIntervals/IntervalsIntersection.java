package Arrays.MergeIntervals;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-interval-list-intersections

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalsIntersection {

    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        List<int[]> intersections = new ArrayList<>();
        int i = 0, j = 0;

        while (i < intervalLista.length && j < intervalListb.length) {
            int start = Math.max(intervalLista[i][0], intervalListb[j][0]);
            int end = Math.min(intervalLista[i][1], intervalListb[j][1]);

            if (start <= end)
                intersections.add(new int[]{start, end});
            if (intervalLista[i][1] < intervalListb[j][1])
                i += 1;
            else
                j += 1;
        }

        return intersections.toArray(new int[0][]);
    }

    public static void main(String args[]) {
        int[][] inputIntervalLista = {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}};

        int[][] inputIntervalListb = {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}};

        System.out.println("Interval List A: " + Arrays.deepToString(inputIntervalLista));
        System.out.println("Interval List B: " + Arrays.deepToString(inputIntervalListb));
        System.out.println("Intersecting intervals in 'A' and 'B' are: " +
                Arrays.deepToString(intervalsIntersection(inputIntervalLista, inputIntervalListb)));

    }
}
