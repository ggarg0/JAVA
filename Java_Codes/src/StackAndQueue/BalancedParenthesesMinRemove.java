package StackAndQueue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalancedParenthesesMinRemove {

    public static String minRemoveParentheses(String input) {
        StringBuilder result = new StringBuilder();
        Set<Integer> badIndex = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '('){
                stack.push(i);
            }else if(input.charAt(i) ==')'){
                if (!stack.isEmpty()){
                    stack.pop();
                }else{
                    badIndex.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            badIndex.add(stack.pop());
        }

        for (int i = 0; i < input.length(); i++) {
            if (!badIndex.contains(i)) {
                result.append(input.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "qi)(kl)((y(yt))(r(q(g)s)";
        System.out.println(minRemoveParentheses(input));
    }

}
