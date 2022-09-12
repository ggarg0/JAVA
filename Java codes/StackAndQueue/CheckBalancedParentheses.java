package StackAndQueue;

public class CheckBalancedParentheses {
	public static boolean isBalanced(String exp) {
		boolean result = true;
		MyStack<Character> stack = new MyStack<Character>(exp.length());

		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '{' || exp.charAt(i) == '[' || exp.charAt(i) == '(') {
				stack.push(exp.charAt(i));
			} else {
				switch (exp.charAt(i)) {
				case '}':
					if (stack.pop() != '{') {
						result = false;
					}
					break;

				case ']':
					if (stack.pop() != '[') {
						result = false;
					}
					break;

				case ')':
					if (stack.pop() != '(') {
						result = false;
					}
					break;

				default:
					System.out.println("Invalid Parentheses");
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(isBalanced("{[({})]}"));
		System.out.println(isBalanced("[{(}]"));
	}
}
