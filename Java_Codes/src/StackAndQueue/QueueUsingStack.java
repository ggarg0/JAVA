package StackAndQueue;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Object> stack1 = new Stack<Object>();
    Stack<Object> stack2 = new Stack<Object>();

    public boolean isEmpty() {
        return stack1.empty() && stack2.empty();
    }

    public void printQueue(String operation) {
        int counter = 0;
        System.out.print(operation + " : ");
        while (counter < stack2.size()) {
            System.out.print("|" + stack2.get(counter) + "|");
            counter++;
        }

        counter = 0;
        while (counter < stack1.size()) {
            System.out.print("|" + stack1.get(counter) + "|");
            counter++;
        }
        System.out.println();
    }

    public void enqueue(Object data) {
        stack1.push(data);
        printQueue("Enqueue");
    }

    public Object dequeue() {
        Object result = -1;

        if (isEmpty()) {
            printQueue("Dequeue");
            System.out.println("Queue is empty");
            return result;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        result = stack2.pop();
        printQueue("Dequeue");
        return result;
    }

    Stack<Object> s1 = new Stack<>();
    Stack<Object> s2 = new Stack<>();

    public boolean empty() {
        return (s1.empty() && s2.empty());
    }

    public void print() {
        System.out.println("Queue : " + s1);
    }

    public void add(Object data) {
        s1.push(data);
    }

    public Object remove() {
        if (s1.empty()) {
            System.out.println("Queue is empty: ");
            return null;
        }

        while (!s1.empty())
            s2.push(s1.pop());

        Object temp = s2.pop();

        while (!s2.empty())
            s1.push(s2.pop());

        return temp;

    }

    public static void main(String[] args) {
        QueueUsingStack qs = new QueueUsingStack();
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

        System.out.println("Pop: " + qs.remove());
        qs.add(567);
        qs.add(34);
        qs.add("Test");
        qs.add(23);
        qs.print();
        System.out.println("Pop: " + qs.remove());
        qs.print();
        System.out.println("isEmpty : " + qs.empty());
    }
}
