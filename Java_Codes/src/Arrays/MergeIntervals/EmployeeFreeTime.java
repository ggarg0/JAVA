package Arrays.MergeIntervals;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-employee-free-time
//https://walkccc.me/LeetCode/problems/759/#__tabbed_1_2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    public static List<Interval> freeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();

        schedule.forEach(s -> intervals.addAll(s));
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        int prevEnd = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start > prevEnd)
                ans.add(new Interval(prevEnd, interval.start));
            prevEnd = Math.max(prevEnd, interval.end);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Interval>> intervals = Arrays.asList(
                Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                Arrays.asList(new Interval(1, 3)),
                Arrays.asList(new Interval(4, 10))
        );
        System.out.println("Intervals : " + intervals.toString());
        System.out.println("Free time : " +  freeTime(intervals).toString());
    }


}
