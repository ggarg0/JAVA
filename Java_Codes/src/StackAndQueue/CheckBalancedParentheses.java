package StackAndQueue;

public class CheckBalancedParentheses {
	public static boolean isBalanced(String s) {
		MyStack<Character> stack = new MyStack<Character>(s.length());

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

	public static void main(String[] args) {
		System.out.println(isBalanced("{[({})]}"));
		System.out.println(isBalanced("]"));
	}
}
