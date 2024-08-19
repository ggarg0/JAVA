package Arrays.MergeIntervals;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/meeting-rooms-ii
//https://myinterview.guru/leetcode-253-meeting-rooms-2-52e6f0c6cae6

import java.util.Arrays;
import java.util.Comparator;

public class MinimumMeetingRooms {

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start, Comparator.comparingInt(a -> a));
        Arrays.sort(end, Comparator.comparingInt(a -> a));
        System.out.println("Start Intervals : " + Arrays.toString(start));
        System.out.println("End Intervals : " + Arrays.toString(end));

        int startPointer = 0, endPointer = 0;
        int usedRooms = 0;

        while (startPointer < intervals.length) {
            usedRooms++;
            if (start[startPointer] >= end[endPointer]) {
                usedRooms--;
                endPointer++;
            }
            startPointer++;
        }
        return usedRooms;
    }

    public static void main(String[] args) {
        int[][] intervals = {{8, 10}, {10, 13}, {11, 12}, {12, 15}, {17, 20}};
        System.out.println("Intervals : " + Arrays.deepToString(intervals));
        System.out.println("Minimum meeting room: " + minMeetingRooms(intervals));
    }

}
