package array;

public class MaxMinArray {
	public static void main(String args[]) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int len = arr.length;
		int start = 0;
		int end = len - 1;
		int[] result = new int[len];
		boolean flag = true;

		for (int i = 0; i < len; i++) {
			if (flag) {
				result[i] = arr[end];
				end--;
			} else {
				result[i] = arr[start];
				start++;
			}
			flag = !flag;
		}
		for (int l = 0; l < len; l++) {
			System.out.print(result[l] + ", ");
		}
	}
}
