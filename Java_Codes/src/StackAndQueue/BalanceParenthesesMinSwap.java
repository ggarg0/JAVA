package StackAndQueue;

import java.util.Stack;

public class BalanceParenthesesMinSwap {

    public static int minSwaps(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                open++;
            } else if (c == ']' && open > 0) {
                open--;
            }
        }
        return (open + 1) / 2;
    }

    public static int minSwapParentheses(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ']' && st.size() != 0 && st.peek() == '[') {
                st.pop();
            }
        }
        if (st.size() % 2 == 0)
            return st.size() / 2;
        else
            return (st.size() + 1) / 2;

    }

    public static void main(String[] args) {
        String input = "]]][[[";
        System.out.println(minSwapParentheses(input));
        System.out.println(minSwaps(input));
    }

}
