package StackAndQueue;

import java.util.Arrays;

public class MyStack<V> {

	private int index = -1;
	private int maxSize;
	private V[] stack;

	public MyStack() {
		this.maxSize = 0;
		stack = (V[]) new Object[0];
	}

	public MyStack(int maxSize) {
		this.maxSize = maxSize;
		stack = (V[]) new Object[maxSize];
	}

	public boolean isFull() {
        return index == maxSize - 1;
    }

	public boolean isEmpty() {
        return index == -1;
    }

	public void push(V data) {
		if (isFull()) {
			System.out.println("Stack is full and resizing stack");
			resizeStack();
		}
		stack[++index] = data;
		printStack("After Push() : ");
	}

	public V pop() {
		V result = null;
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		result = stack[index];
		stack[index--] = null;
		printStack("After Pop() : ");
		return result;
	}

	public V peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		}
		return stack[index];
	}

	public void resizeStack() {
		maxSize = maxSize * 2;
		stack = Arrays.copyOf(stack, maxSize);
		printStack("After resizing : ");
	}

	public void printStack(String opertaion) {
		System.out.println(opertaion + Arrays.toString(stack));
	}

	public static void main(String[] args) {
		MyStack<Object> myStack = new MyStack<Object>(5);
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