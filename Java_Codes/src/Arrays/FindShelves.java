package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FindShelves {
    public static int maxTypesAfterFreeingShelves(int[] A, int R) {
        int N = A.length;
        if (R >= N) return 0;  // All shelves removed

        // Step 1: Count total frequency of all item types
        Map<Integer, Integer> totalFreq = new HashMap<>();
        for (int item : A) {
            totalFreq.put(item, totalFreq.getOrDefault(item, 0) + 1);
        }
        int totalDistinct = totalFreq.size();

        // Step 2: Sliding window of size R to remove shelves
        Map<Integer, Integer> windowFreq = new HashMap<>();
        for (int i = 0; i < R; i++) {
            windowFreq.put(A[i], windowFreq.getOrDefault(A[i], 0) + 1);
        }

        // Step 3: Compute how many distinct remain after first window
        int distinctRemoved = 0;
        for (int key : windowFreq.keySet()) {
            if (totalFreq.get(key).equals(windowFreq.get(key))) {
                distinctRemoved++;
            }
        }
        int maxDistinctRemain = totalDistinct - distinctRemoved;

        // Step 4: Slide window and update counts
        for (int i = R; i < N; i++) {
            int add = A[i];
            int remove = A[i - R];

            // Remove old element from window
            windowFreq.put(remove, windowFreq.get(remove) - 1);
            if (windowFreq.get(remove) == 0) {
                windowFreq.remove(remove);
            }

            // Add new element to window
            windowFreq.put(add, windowFreq.getOrDefault(add, 0) + 1);

            // Recalculate distinctRemoved
            distinctRemoved = 0;
            for (int key : windowFreq.keySet()) {
                if (totalFreq.get(key).equals(windowFreq.get(key))) {
                    distinctRemoved++;
                }
            }

            maxDistinctRemain = Math.max(maxDistinctRemain, totalDistinct - distinctRemoved);
        }

        return maxDistinctRemain;
    }

    public static void main(String[] args) {
        int[] A = {1,100000,1};
        int R = 3;
        System.out.println("Maximum number of item types that can still be stored: "
                + maxTypesAfterFreeingShelves(A, R));
    }
}



