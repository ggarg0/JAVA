package StackAndQueue;

import java.util.Arrays;

public class QueueImplementation {
	public static void main(String[] args) {
		MyQueue<Object> myQueue = new MyQueue<Object>(5);
		System.out.println("Queue is full : " + myQueue.isFull());
		System.out.println("Queue is empty : " + myQueue.isEmpty());

		myQueue.enqueue(2);
		myQueue.enqueue(false);
		myQueue.enqueue(null);
		System.out.println("first() called : " + myQueue.first());
		myQueue.dequeue();
		myQueue.enqueue("queue");
		myQueue.enqueue("add");
		myQueue.enqueue(7);
		myQueue.enqueue(true);
	}
}

class MyQueue<V> {

	private int maxSize;
	private V[] queue;
	private int index = -1;

	public MyQueue() {
		this.maxSize = 0;
		queue = (V[]) new Object[0];
	}

	public MyQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = (V[]) new Object[maxSize];
	}

	public boolean isEmpty() {
		if (index == -1) {
			System.out.println("Queue is empty");
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (index == maxSize - 1) {
			System.out.println("Queue is full");
			return true;
		}
		return false;
	}

	public void printQueue(String operation) {
		System.out.println(operation + Arrays.toString(queue));
	}

	public void enqueue(V data) {
		if (isFull()) {
			System.out.println("Queue is full and resizing Queue");
			resizeQueue();
		}
		queue[++index] = data;
		printQueue("After enqueue [" + data + "] : ");
	}

	public V dequeue() {
		V result = null;
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			int counter = 0;
			result = queue[0];
			while (counter < index) {
				queue[counter] = queue[counter + 1];
				counter++;
			}			
			queue[index--] = null;
			printQueue("After dequeue : ");
		}
		return result;
	}

	public V first() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		}
		return queue[index];
	}

	public void resizeQueue() {
		maxSize = maxSize * 2;
		V[] temp = (V[]) new Object[maxSize];
		int counter = 0;

		while (counter <= index) {
			temp[counter] = queue[counter];
			counter++;
		}
		queue = temp;
		printQueue("After resizing : ");
	}
}
