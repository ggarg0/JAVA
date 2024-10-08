package StackAndQueue;

import java.util.Arrays;

public class MyQueue<V> {

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
        if (index != -1) {
            return false;
        }
        System.out.println("Queue is empty");
        return true;
    }

    public int size() {
        return index;
    }

    public boolean isFull() {
        if (index != maxSize - 1) {
            return false;
        }
        System.out.println("Queue is full");
        return true;
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

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        int counter = 0;
        V result = queue[0];
        while (counter < index) {
            queue[counter] = queue[counter + 1];
            counter++;
        }
        queue[index--] = null;
        printQueue("After dequeue : ");

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
		queue = Arrays.copyOf(queue, maxSize);
        printQueue("After resizing : ");
    }

    public static void main(String[] args) {
        MyQueue<Object> myQueue = new MyQueue<Object>(5);
        System.out.println("Queue is full : " + myQueue.isFull());
        System.out.println("Queue is empty : " + myQueue.isEmpty());

        myQueue.enqueue(2);
        myQueue.enqueue(false);
        myQueue.enqueue(56);
        System.out.println("first() called : " + myQueue.first());
        myQueue.dequeue();
        myQueue.enqueue("queue");
        myQueue.enqueue("add");
        myQueue.enqueue(7);
        myQueue.enqueue(true);
    }
}
