package Arrays.General;

//https://www.educative.io/courses/data-structures-coding-interviews-java/solution-find-second-maximum-value-in-an-array

public class FindSecondMaximum {
    public static void main(String args[]) {
        int[] arr = {0, 9, 2, 3, 2, 6, 8};

        int first, second;
        if (arr[0] > arr[1]) {
            first = arr[0];
            second = arr[1];
        } else {
            first = arr[1];
            second = arr[0];
        }

        for (int n = 2; n < arr.length; n++) {
            if (arr[n] > first) {
                second = first;
                first = arr[n];
            } else if (arr[n] > second) {
                second = arr[n];
            }
        }
        System.out.println("Second highest : " + second);

    }
}
