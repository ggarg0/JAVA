package StackAndQueue;

import java.util.Stack;

public class EvaluatePostfix {

	public static int evaluatePostFix(String expression) {
		char[] arr = expression.toCharArray();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			char character = expression.charAt(i);
			if (!Character.isDigit(character)) {
				int s1 = stack.pop();
				int s2 = stack.pop();
				int result = 0;

				switch (character) {
				case '+':
					result = s2 + s1;
					break;

				case '-':
					result = s2 - s1;
					break;

				case '*':
					result = s2 * s1;
					break;

				case '/':
					result = s2 / s1;
					break;
				}
				stack.push(result);
			} else {
				stack.push(Character.getNumericValue(character));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String expression = "921*-8-4+";
		System.out.println(evaluatePostFix(expression));
	}
}
