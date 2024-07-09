package StackAndQueue;

import java.util.Arrays;

public class MyStack<V> {

	private int index = -1;
	private int size;
	private V[] stack;

	public MyStack(int size) {
		this.size = size;
		stack = (V[]) new Object[size];
	}

	public boolean isFull() {
        return index == size - 1;
    }

	public int getSize() {
		return size;
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
		size = size * 2;
		stack = Arrays.copyOf(stack, size);
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
		myStack.pop();
		myStack.push("stack");
		myStack.push("add");
		System.out.println("Peek() called : " + myStack.peek());
		myStack.push(7);
		myStack.push(true);
	}
}