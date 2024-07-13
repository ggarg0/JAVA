package StackAndQueue;

import java.util.Stack;

public class CheckBalancedParentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean isBalance(String exp) {
        Stack<Character> stack = new Stack<>();
        char[] array = exp.toCharArray();
        for (char c : array) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop())
                        return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[({})]}"));
        System.out.println(isBalance("[]"));
    }
}
