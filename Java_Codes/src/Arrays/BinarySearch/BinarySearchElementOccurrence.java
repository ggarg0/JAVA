package Arrays.BinarySearch;

public class BinarySearchElementOccurrence {


    public static int findIndexes(int[] arr, int key, boolean firstIndex) {
        int start = 0;
        int end = arr.length - 1;
        int index = -1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                index = mid;
                if (firstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 2, 3, 4, 4, 5, 6, 6, 9};
        int key = 1;
        int first = findIndexes(arr, key, true);
        int last = first == -1 ? 0 : findIndexes(arr, key, false);
        System.out.println("element occurrences : " + (first == -1 ? 0 : ((last - first) + 1)));
    }


}
