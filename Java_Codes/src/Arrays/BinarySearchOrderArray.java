package Arrays;

public class BinarySearchOrderArray {

    public static int search(int[] arr, int key) {
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        boolean ascending = (arr[start] < arr[end] ? true : false);

        while (start <= end) {

            if (arr[mid] == key) {
                index = mid;
                break;
            }

            if (ascending) {
                if (arr[mid] > key) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < key) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            mid = (start + end) / 2;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 4, 6, 7, 8, 9}, 5));
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(search(new int[]{10, 8, 6, 4, 3, 2, 1}, 7));
        System.out.println(search(new int[]{10, 6, 4}, 4));

    }

}
