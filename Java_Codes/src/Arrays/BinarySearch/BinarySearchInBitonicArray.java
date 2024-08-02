package Arrays.BinarySearch;

/*
A Bitonic Sequence is a sequence of numbers that is first strictly increasing then after a point decreasing.
* https://www.educative.io/courses/binary-search-coding-interview/element-in-bitonic-array
*/

public class BinarySearchInBitonicArray {

    public static int findBitonicPoint(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int searchAscendingArray(int[] arr, int key, int bitonicPoint) {
        int start = 0;
        int end = bitonicPoint;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int searchDescendingArray(int[] arr, int key, int bitonicPoint) {
        int start = bitonicPoint + 1;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findElement(int[] arr, int key) {
        int bitonicPoint = findBitonicPoint(arr);
        int index = -1;

        if (arr[bitonicPoint] == key) {
            return bitonicPoint;
        }

        index = searchAscendingArray(arr, key, bitonicPoint);

        if (index == -1) {
            index = searchDescendingArray(arr, key, bitonicPoint);
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(findElement(new int[]{1, 3, 8, 12, 4, 2}, 8));
        System.out.println(findElement(new int[]{3, 8, 3, 1}, 31));
        System.out.println(findElement(new int[]{1, 3, 8, 12}, 12));
        System.out.println(findElement(new int[]{10, 9, 8}, 8));
    }
}
