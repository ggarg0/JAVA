package StackAndQueue;

import java.util.Arrays;

public class TwoStacksUsingSingleArray {

    public static void main(String[] args) {
        TwoStacks<Integer> stack = new TwoStacks<Integer>(5);

        stack.push1(11);
        stack.push1(3);
        stack.push1(7);
        stack.push2(1);
        stack.push2(9);
        stack.push2(15);
        stack.push1(77);
        stack.pop1();
        stack.pop2();
        stack.pop2();
        stack.pop2();
        stack.pop1();
    }
}

class TwoStacks<V> {

    private int maxSize;
    private V[] array;
    private int firstIndex;
    private int lastIndex;

    public TwoStacks(int maxSize) {
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];
        firstIndex = -1;
        lastIndex = maxSize;
    }

    public void push1(V value) {
        if (firstIndex >= lastIndex) {
            printStack("Push1 " + value);
            System.out.println("Stack1 is full");
        }
        array[++firstIndex] = value;
        printStack("Push1 " + value);
    }

    public V pop1() {
        V result = null;
        if (firstIndex == -1) {
            printStack("Pop1 ");
            System.out.println("Stack1 is empty");
            return null;
        }
        result = array[firstIndex];
        array[firstIndex--] = null;
        printStack("Pop1 ");
        return result;
    }

    public void push2(V value) {
        if (firstIndex >= lastIndex) {
            printStack("Push2 " + value);
            System.out.println("Stack2 is full");
        }
        array[--lastIndex] = value;
        printStack("Push2 " + value);
    }

    public V pop2() {
        V result = null;
        if (lastIndex == maxSize) {
            printStack("Pop2 ");
            System.out.println("Stack2 is empty");
            return null;
        }
        result = array[lastIndex];
        array[lastIndex++] = null;
        printStack("Pop2 ");

        return result;
    }

    public void printStack(String operation) {
        System.out.println(operation + " - " + Arrays.toString(array));
    }

}
