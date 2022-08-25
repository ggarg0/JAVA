package StackAndQueue;

import java.util.Arrays;

public class StackImplementation {

	public static void main(String[] args) {
		MyStack myStack = new MyStack(5);
		System.out.println("Stack is full : " + myStack.isFull());
		System.out.println("Stack is empty : " + myStack.isEmpty());

		myStack.push(2);
		myStack.push(false);
		myStack.push(null);
		System.out.println("Peek() called : " + myStack.peek());
		myStack.pop();
		myStack.push("stack");
		myStack.push("add");
		myStack.push(7);
		myStack.push(true);
	}
}

class MyStack {

	private int index = -1;
	private int maxSize;
	private Object[] stack;

	public MyStack() {
		this.maxSize = 0;
		stack = new Object[0];
	}

	public MyStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new Object[maxSize];
	}

	public boolean isFull() {
		if (index == maxSize - 1)
			return true;

		return false;
	}

	public boolean isEmpty() {
		if (index == -1)
			return true;

		return false;
	}

	public void push(Object data) {
		if (isFull()) {
			System.out.println("Stack is full and resizing stack");
			resizeStack();
		}
		stack[++index] = data;
		printStack("After Push() : ");
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			stack[index--] = null;
			printStack("After Pop() : ");
		}
	}

	public Object peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return stack;
		}
		return stack[index];
	}

	public void resizeStack() {
		maxSize = maxSize * 2;
		Object[] temp = new Object[maxSize];
		int counter = 0;

		while (counter <= index) {
			temp[counter] = stack[counter];
			counter++;
		}
		stack = temp;
		printStack("After resizing : ");
	}

	public void printStack(String opertaion) {
		System.out.println(opertaion + Arrays.toString(stack));
	}

}