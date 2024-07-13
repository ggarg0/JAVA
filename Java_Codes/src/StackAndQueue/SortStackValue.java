package StackAndQueue;

import java.util.Stack;

public class SortStackValue {

	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> newStack = new Stack<>();
		while (!stack.isEmpty()) {
			Integer value = stack.pop();
			if (!newStack.isEmpty() && newStack.peek() < value) {
				newStack.push(value);
			} else {
				while (!newStack.isEmpty() && newStack.peek() > value)
					stack.push(newStack.pop());
				newStack.push(value);
			}
		}
		return newStack;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(42);
		stack.push(12);
		stack.push(60);
		stack.push(23);
		System.out.println(stack);
		System.out.println(sortStack(stack));
	}

}
