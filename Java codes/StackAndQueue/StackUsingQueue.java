package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
	Queue<Object> queue1 = new ArrayDeque<Object>();
	Queue<Object> queue2 = new ArrayDeque<Object>();

	public boolean isEmpty() {

		if (queue1.size() + queue2.size() == 0) {
			return true;
		}
		return false;
	}

	public void push(Object data) {
		queue1.add(data);
		printQueue("Push");
	}

	public void swapQueue() {
		Queue<Object> queueTemp = queue1;
		queue1 = queue2;
		queue2 = queueTemp;
	}

	public Object pop() {
		Object result = -1;

		if (isEmpty()) {
			printQueue("Pop");
			System.out.println("Stack is empty");
			return result;
		}

		while (queue1.size() > 1) {
			queue2.add(queue1.remove());
		}

		queue1.remove();

		swapQueue();
		printQueue("Pop");
		return result;
	}

	public void printQueue(String operation) {
		System.out.println(operation + " : " + queue1.toString());
	}

	public static void main(String[] args) {
		StackUsingQueue sq = new StackUsingQueue();
		sq.pop();
		sq.push(3);
		sq.push(5);
		sq.push(true);
		sq.pop();
		sq.push(false);
		sq.push("Add");
	
	}

}
