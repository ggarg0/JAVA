package StackAndQueue;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(Integer data) {
        stack.push(data);
        if (min.isEmpty() || min.peek() > data) {
			min.push(data);
        } else {
			min.push(min.peek());
        }
    }

    public int pop() {
        min.pop();
        return stack.pop();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String args[]) {

        MinStack stack = new MinStack();
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
