package Arrays.General;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {1, 8, 45, 6, 10, 8};
        int target = 16;
        System.out.println(sum(array, target));
    }

    public static List<Pair> sum(int[] array, int target) {
        Set<Integer> set = new HashSet<>();
        List<Pair> list = new ArrayList<>();
        for (int num : array) {
            int temp = target - num;
            if (set.contains(temp)) {
                list.add(new Pair(temp, num));
            }
            set.add(num);
        }
        return list;
    }
}

class Pair {
    private int x;
    private int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{x=" + x + ", y=" + y + "}";
    }
}