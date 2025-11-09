package Arrays.General;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class ArrayTargetSumWithIndex {
    public static void main(String[] args) {
        int[] arr = {-4, -1, -9, 1, -7, 6};
        int target = -5;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int[] indexes = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = target - arr[i];
            if (map.containsKey(temp)) {
                first = temp;
                second = arr[i];
                indexes[0] = map.get(temp);
                indexes[1] = i;
            }
            map.put(arr[i], i);
        }
        System.out.println(" result : " + Arrays.toString(indexes) + " n sum : " + (first + second));
    }
}
