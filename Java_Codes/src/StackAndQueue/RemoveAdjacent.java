package StackAndQueue;

import java.util.Stack;

public class RemoveAdjacent {

    public static String removeDuplicates(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
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
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "abbddaccaaabcd";
        System.out.println(removeDuplicates(input));
    }
}
