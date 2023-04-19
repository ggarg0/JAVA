package StackAndQueue;

public class SortMyStackValue {
	public static void sortStack(MyStack<Integer> stack) {

		MyStack<Integer> newStack = new MyStack<>(4);
		while (!stack.isEmpty()) {
			Integer value = stack.pop();
			if (!newStack.isEmpty() && value >= newStack.peek()) {
				newStack.push(value);
			} else {
				while (!newStack.isEmpty() && newStack.peek() > value)
					stack.push(newStack.pop());
				newStack.push(value);
			}
		}

		while (!newStack.isEmpty())
			stack.push(newStack.pop());

	}

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>(4);
		stack.push(42);
		stack.push(12);
		stack.push(60);
		stack.push(23);
		sortStack(stack);
		stack.printStack("Result : ");
	}

}
