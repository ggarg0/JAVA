package StackAndQueue;

public class QueueUsingMyStack {
	MyStack<Integer> stack1 = new MyStack<Integer>(5);
	MyStack<Integer> stack2 = new MyStack<Integer>(5);

	public boolean isEmpty() {
		if (stack1.isEmpty() && stack2.isEmpty())
			return true;

		return false;
	}

	public void enqueue(Integer data) {
		stack1.push(data);
		stack1.printStack("Enqueue (" + data + ") : ");
	}

	public Integer dequeue() {
		int result = -1;
		if (isEmpty()) {
			stack1.printStack("Dequeue : ");
			System.out.println("Queue is empty");
		} else {
			while (!stack1.isEmpty()) 
				stack2.push(stack1.pop());
			
			result = stack2.pop();

			while (!stack2.isEmpty()) 
				stack1.push(stack2.pop());
			
			stack1.printStack("Dequeue :");
		}
		return result;
	}

	public static void main(String[] args) {
		QueueUsingMyStack qs = new QueueUsingMyStack();
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
		qs.enqueue(9);
	}
}
