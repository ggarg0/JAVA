package StackAndQueue;

import java.util.Arrays;

public class NextGreaterElementArray {
	public static int[] nextGreaterElement(int[] arr) {
		int[] result = new int[arr.length];
		MyStack<Object> stack = new MyStack<>(arr.length);

		for (int i = arr.length - 1; i >= 0; i--) {
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && (int) stack.peek() <= arr[i]) {
					stack.pop();
				}
			}
			if (stack.isEmpty()) {
				result[i] = -1;
			} else
				result[i] = (int) stack.peek();
			stack.push(arr[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 3, 2, 8, 1 };
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(nextGreaterElement(arr)));
	}

}
