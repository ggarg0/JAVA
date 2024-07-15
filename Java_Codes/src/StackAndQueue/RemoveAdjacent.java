package StackAndQueue;

import java.util.Stack;

public class RemoveAdjacent {

    public static String removeDuplicates(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = input.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && input.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(input.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "abbddaccaaabcd";
        System.out.println(removeDuplicates(input));
    }
}
