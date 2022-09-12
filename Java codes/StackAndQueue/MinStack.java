package StackAndQueue;

public class MinStack {

	private int size;
	private MyStack<Integer> main;
	private MyStack<Integer> min;

	public MinStack() {
		this.size = 0;
		this.main = new MyStack<Integer>(this.size);
		this.min = new MyStack<Integer>(this.size);
	}

	public MinStack(int size) {
		this.size = size;
		main = new MyStack<Integer>(this.size);
		min = new MyStack<Integer>(this.size);
	}

	public int pop() {
		min.pop();
		return main.pop();		
	}

	
	public void push(Integer value) {
		main.push(value);
		if(!min.isEmpty() && min.peek() < value) {
			min.push(min.peek());
		}else {
			min.push(value);
		}
	}

	public int min() {
		return min.peek();
	}

	public static void main(String args[]) {

		MinStack stack = new MinStack(6);
		stack.push(5);
		stack.push(2);
		stack.push(4);
		stack.push(1);
		stack.push(3);
		stack.push(9);

		System.out.println(stack.min());

		stack.pop();
		stack.pop();
		stack.pop();

		System.out.println(stack.min());

	}
}
