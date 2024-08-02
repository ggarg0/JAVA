package Arrays.TwoPointers;
//https://leetcode.com/problems/find-closest-number-to-zero/

public class ArrayNumberCloseToZero {
    public static void main(String[] a) {

        int[] arr = {2, -1, 1};
        int closestNum = arr[0];
        int absValue = Math.abs(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (absValue > Math.abs(arr[i])) {
                absValue = Math.abs(arr[i]);
                closestNum = arr[i];
            } else if (absValue == Math.abs(arr[i])) {
                closestNum = Math.max(arr[i], closestNum);
            }
        }
        System.out.println("Closest Num : " + closestNum);
    }
}