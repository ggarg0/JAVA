package Arrays.TwoPointers;

//https://www.educative.io/courses/data-structures-coding-interviews-java/solution-find-minimum-value-in-array

public class FindMinimumInArray {
    public static void main(String args[]) {

        int[] arr = {-41, -1, 3, -14, 5, 0, 7, -60};
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] < arr[end]) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(arr[start]);
    }
}
