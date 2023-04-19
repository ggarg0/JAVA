package StackAndQueue;

public class ReverseFirstKElementsInQueue {

	public static void reverseFirstKElements(MyQueue<Integer> queue, int k) {
		if (queue.isEmpty() || k <= 0)
			return;

		MyStack<Integer> stack = new MyStack<Integer>(k);

		while (!stack.isFull())
			stack.push(queue.dequeue());

		while (!stack.isEmpty())
			queue.enqueue(stack.pop());

		for (int i = 0; i < k; i++)
			queue.enqueue(queue.dequeue());
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>(10);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);

		reverseFirstKElements(queue, 5);

	}

}
