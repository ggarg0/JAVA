package Arrays.CyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstKMissingPositiveNumber {

    public static List<Integer> firstMissingPositiveInteger(int[] arr, int k) {
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        int count = 1;
        int found = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == count) {
                count++;
            } else {
                result.add(count);
                found++;
                if (found == k) {
                    break;
                }
            }
        }
        return result;
    }

    public static int missingK(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }


    public static void main(String[] args) {
        //  int[] arr = {1, 2, 3, 4};
        //  int[] arr =  {-1, 3, 5, 7, 1};
        // int[] arr = {-1, 0, 2, 1, 4};
        int[] arr = {2, 3, 4, 7, 11};
        System.out.println("Missing number: " + firstMissingPositiveInteger(arr, 4));
        System.out.println("Missing number: " + missingK(arr, arr.length, 4));
    }
}
