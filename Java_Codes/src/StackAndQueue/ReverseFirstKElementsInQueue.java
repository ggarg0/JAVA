package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseFirstKElementsInQueue {

    public static ArrayDeque<Integer> reverseK(ArrayDeque<Integer> queue, int k) {

        if (queue.isEmpty() || k < 1 || k > queue.size())
            return queue;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        while (!stack.empty()) {
            queue.add(stack.pop());
        }
        System.out.println("queue in: " + queue);
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.remove());
        }
        return queue;
    }

    public static void reverseFirstKElements(MyQueue<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 0)
            return;

        MyStack<Integer> stack = new MyStack<Integer>(k);

        while (!stack.isFull())
            stack.push(queue.dequeue());

        while (!stack.isEmpty())
            queue.enqueue(stack.pop());

        for (int i = 0; i < queue.size() - k; i++)
            queue.enqueue(queue.dequeue());

        queue.printQueue(" print : ");
    }

    public static void main(String[] args) {
      /*
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
        queue.printQueue(" print : ");
        reverseFirstKElements(queue, 2);
*/
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(-4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        System.out.println("queue : " + queue);
        System.out.println("returned queue : " + reverseK(queue, 2));
    }

}
