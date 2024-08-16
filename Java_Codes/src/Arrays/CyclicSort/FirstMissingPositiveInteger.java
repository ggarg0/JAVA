package Arrays.CyclicSort;

public class FirstMissingPositiveInteger {

    public static int firstMissingPositiveInteger(int[] arr) {
        int start = 0;
        int end = arr.length;
        int value = 0;

        while (start < end) {
            value = arr[start]-1;
            if (value >= 0 && value < end && arr[start] != arr[value]) {
                int temp = arr[start];
                arr[start] = arr[value];
                arr[value] = temp;
            } else {
                start++;
            }
        }

        for (int x = 1; x < end; x++) {
            if (x != arr[x-1]) {
                return x;
            } else{
                return end +1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("\n\tMissing number: " + firstMissingPositiveInteger(arr));
    }
}
