package StackAndQueue;

import java.util.Arrays;

public class QueueImplementation {
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue(5);
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

class MyQueue{

	private int maxSize;
	private Object[] queue;
	private int index = -1;

	public MyQueue(){
		this.maxSize = 0;
		queue = new Object[0];
	}

	public MyQueue(int maxSize){
		this.maxSize = maxSize;
		queue = new Object[maxSize];
	}

	public boolean isEmpty(){
		if(index == -1){
			System.out.println("Queue is empty");
			return true;
		}
		return false;
	}

	public boolean isFull(){
		if(index == maxSize - 1){
			System.out.println("Queue is full");
			return true;
		}
		return false;
	}

	public void printQueue(String operation){
		System.out.println(operation + Arrays.toString(queue));
	}

	public void enqueue(Object data){
		if(isFull()){
			System.out.println("Queue is full and resizing Queue");
			resizeQueue();
		}
		queue[++index]= data;
		printQueue("After enqueue [" + data + "] : ");
	}

	public void dequeue(){
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			int counter = 0;
			while (counter <= index){
				queue[counter] = queue[counter + 1];
				counter++;
			}

			queue[index--] = null;
			printQueue("After dequeue : ");
		}
	}

	public Object first(){
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return queue;
		}
		return queue[index];
	}
	
	public void resizeQueue() {
		maxSize = maxSize * 2;
		Object[] temp = new Object[maxSize];
		int counter = 0;

		while (counter <= index) {
			temp[counter] = queue[counter];
			counter++;
		}
		queue = temp;
		printQueue("After resizing : ");
	}
}
