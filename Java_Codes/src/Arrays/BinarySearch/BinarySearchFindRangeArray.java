package Arrays.BinarySearch;

// with max 2 occurrences

public class BinarySearchFindRangeArray {

    public static int[] searchForKey(int[] arr, int key) {
        int[] result = new int[]{-1, -1};
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == key) {
                if (mid != arr.length - 1 && arr[mid + 1] == key) {
                    result[0] = mid;
                    result[1] = mid + 1;
                } else if (mid != 0 && arr[mid - 1] == key) {
                    result[1] = mid;
                    result[0] = mid - 1;
                } else {
                    result[0] = mid;
                    result[1] = mid;
                }
                break;
            }

            if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = searchForKey(new int[]{5, 7, 7, 8, 8, 10}, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = searchForKey(new int[]{1, 3, 10, 10, 15}, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = searchForKey(new int[]{1, 3, 8, 10, 15}, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
