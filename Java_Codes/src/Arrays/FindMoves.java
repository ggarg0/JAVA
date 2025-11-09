package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FindMoves {
    public static void main(String[] args) {
        int[] a = {1,1,3,4,4,4};
        int[] a1 = {1,2,2,2,5,5,5,8};
        System.out.println(solution(a1));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int moves = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            moves += Math.abs(count - value);
        }

        return moves;

    }
}
