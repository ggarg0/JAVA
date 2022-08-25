package StackAndQueue;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Object> stack1 = new Stack<Object>();
	Stack<Object> stack2 = new Stack<Object>();

	public boolean isEmpty() {

		if (stack1.size() + stack2.size() == 0) {
			return true;
		}
		return false;
	}

	public void printQueue(String operation) {
		int counter = 0;
		System.out.print(operation + " : ");
		while (counter < stack2.size()) {
			System.out.print("|" + stack2.get(counter) + "|");
			counter++;
		}

		counter = 0;
		while (counter < stack1.size()) {
			System.out.print("|" + stack1.get(counter) + "|");
			counter++;
		}
		System.out.println();
	}

	public void enqueue(Object data) {
		stack1.push(data);
		printQueue("Enqueue");
	}

	public Object dequeue() {
		Object result = -1;

		if (isEmpty()) {
			printQueue("Dequeue");
			System.out.println("Queue is empty");
			return result;
		}

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		result = stack2.pop();
		printQueue("Dequeue");
		return result;
	}

	public static void main(String[] args) {
		QueueUsingStack qs = new QueueUsingStack();
		qs.dequeue();
		qs.enqueue(1);
		qs.enqueue(2);
		qs.dequeue();
		qs.enqueue(3);
		qs.enqueue(4);
		qs.enqueue(5);
		qs.dequeue();
		qs.enqueue(7);
		qs.enqueue(8);
	}
}
