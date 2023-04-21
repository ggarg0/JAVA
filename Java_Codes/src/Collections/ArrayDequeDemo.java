package Collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        // Creating Queue using the LinkedList class
        Queue<Integer> numbers = new ArrayDeque<>();

        // offer elements to the Queue
        numbers.offer(1);
        numbers.offer(2);
        numbers.add(3);
        System.out.println("Queue: " + numbers);

        // Access elements of the Queue
        int accessedNumber = numbers.peek();
        System.out.println("Accessed Element: " + accessedNumber);

        // Remove elements from the Queue
        int removedNumber = numbers.poll();
        System.out.println("Removed Element: " + removedNumber);

        System.out.println("Updated Queue: " + numbers);
    }
}
