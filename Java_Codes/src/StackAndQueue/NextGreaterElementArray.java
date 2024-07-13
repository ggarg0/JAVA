package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementArray {
	public static int[] nextGreaterElement(int[] arr) {
		int[] result = new int[arr.length];
		MyStack<Integer> stack = new MyStack<>(arr.length);

		for (int i = arr.length - 1; i >= 0; i--) {
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && arr[i] > stack.peek()) {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		stack.printStack("");
		return result;
	}

	public static int[] nextGreater(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && arr[i] >= stack.peek()) {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 4, 6, 11, 11, 14, 17 };
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(nextGreater(arr)));
	}

}
